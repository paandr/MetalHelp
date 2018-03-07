package com.gmail.gorbaserver.metalhelp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.gmail.gorbaserver.metalhelp.calculator.CalcKrugFragment;
import com.gmail.gorbaserver.metalhelp.calculator.CalcKvadratFragment;
import com.gmail.gorbaserver.metalhelp.classes.ViewPagerAdapter;
import com.gmail.gorbaserver.metalhelp.operation.AddOperationActivity;
import com.gmail.gorbaserver.metalhelp.operation.OperCurrentFragment;
import com.gmail.gorbaserver.metalhelp.operation.OperationFragment;

import static com.gmail.gorbaserver.metalhelp.classes.Helper.writeToLog;

public class OperationActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddOperationActivity.class));
            }
        });


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OperCurrentFragment(), getString(R.string.current));
        adapter.addFragment(new OperationFragment(), getString(R.string.past));


        ViewPager pager = (ViewPager) findViewById(R.id.vpPager);
        pager.setAdapter(adapter);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(pager);

        tabs.addOnTabSelectedListener(this);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        if (tab.getText().toString().equals(getString(R.string.current))){
            fab.setVisibility(View.VISIBLE);
        }else {
            fab.setVisibility(View.GONE);
        }

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        writeToLog("Tab Reselected:"+tab.getText().toString());
    }
}
