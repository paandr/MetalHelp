package com.gmail.gorbaserver.metalhelp;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.gmail.gorbaserver.metalhelp.calculator.CalcArmaturaFragment;
import com.gmail.gorbaserver.metalhelp.calculator.CalcKrugFragment;
import com.gmail.gorbaserver.metalhelp.calculator.CalcKvadratFragment;
import com.gmail.gorbaserver.metalhelp.calculator.CalcListFragment;
import com.gmail.gorbaserver.metalhelp.calculator.CalcTrubaKruglayaFragment;
import com.gmail.gorbaserver.metalhelp.calculator.CalcTrubaProfilFragment;
import com.gmail.gorbaserver.metalhelp.classes.ViewPagerAdapter;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        ViewPagerAdapter adapter =  new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CalcTrubaKruglayaFragment(),getString(R.string.type_truba_kruglaya));
        adapter.addFragment(new CalcKrugFragment(),getString(R.string.type_krug));
        adapter.addFragment(new CalcArmaturaFragment(),getString(R.string.type_armatura));
        adapter.addFragment(new CalcKvadratFragment(),getString(R.string.type_kvadrat));
        adapter.addFragment(new CalcTrubaProfilFragment(),getString(R.string.type_truba_profilnaya));
        adapter.addFragment(new CalcListFragment(),getString(R.string.type_list));

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        vpPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(vpPager);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }
}
