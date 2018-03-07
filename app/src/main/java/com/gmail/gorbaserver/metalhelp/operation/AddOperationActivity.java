package com.gmail.gorbaserver.metalhelp.operation;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gmail.gorbaserver.metalhelp.R;
import com.gmail.gorbaserver.metalhelp.classes.DBMetal;
import com.gmail.gorbaserver.metalhelp.classes.DatePickerFragment;
import com.gmail.gorbaserver.metalhelp.classes.Helper;
import com.gmail.gorbaserver.metalhelp.classes.Operation;
import com.gmail.gorbaserver.metalhelp.classes.TimePickerFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddOperationActivity extends AppCompatActivity
        implements View.OnClickListener,
        DatePickerFragment.OnSetDateListener,
        TimePickerFragment.OnSetTimeListener {

    private DBMetal dbMetal;
    private ArrayList<Operation> operations;

    private EditText etName;
    private EditText etNote;
    private EditText etDistance;
    private EditText etFinish;
    private TextView tvDate;
    private TextView tvTime;

    private Calendar calDate;

    private Button btnSave;
    private Button btnAddPosition;

    private LinearLayout llAddOperation;

    int FLAG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_operation);

        dbMetal = new DBMetal(this);
        dbMetal.open();

        etName = (EditText) findViewById(R.id.etName);
        int currentId = dbMetal.getMaxOperationId();
        etName.setText("Операция №" + ++currentId);

        etNote = (EditText)findViewById(R.id.etNote);
        etDistance = (EditText)findViewById(R.id.etDistance);
        etFinish = (EditText)findViewById(R.id.etFinish);

        tvDate = (TextView) findViewById(R.id.tvDate);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvDate.setOnClickListener(this);
        tvTime.setOnClickListener(this);

        calDate = Calendar.getInstance(Locale.getDefault());
        setTextDateAndTime(calDate);

        btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        btnAddPosition = (Button)findViewById(R.id.btnAddPosition);
        btnAddPosition.setOnClickListener(this);

        llAddOperation = (LinearLayout)findViewById(R.id.llAddoperation);

        operations = new ArrayList<>();

        Operation item1 = new Operation("Note1", "Name1", new Date(System.currentTimeMillis()), 1.47, "London");
        Operation item2 = new Operation("Note2", "Name2", new Date(System.currentTimeMillis()), 1.48, "Tokyo");
        Operation item3 = new Operation("Note3", "Name3", new Date(System.currentTimeMillis()), 1.49, "Milan");
        Operation item4 = new Operation("Note4", "Name4", new Date(System.currentTimeMillis()), 1.51, "Paris");


        operations.add(item1);
        operations.add(item2);
        operations.add(item3);
        operations.add(item4);

        if (FLAG == 2) {
            for (Operation item : operations) {
                addOperation(item);
            }
        }
    }


    private void addOperation(Operation item) {
        dbMetal.addOperation(item);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbMetal.close();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvDate: {
                DialogFragment frag = new DatePickerFragment();
                frag.show(getFragmentManager(), "Date Picker");
            }
            break;
            case R.id.tvTime:
                TimePickerFragment frag = new TimePickerFragment();
                frag.show(getFragmentManager(), "Time Picker");
                break;
            case R.id.btnSave:
                Operation o = new Operation();
                o.setName(etName.getText().toString());
                o.setNote(etNote.getText().toString());
                o.setDistance(Helper.getDoubleFromEditText(etDistance.getText().toString()));
                o.setFinish(etFinish.getText().toString());
                o.setDate(calDate.getTime());

                addOperation(o);
                finish();
                break;
            case R.id.btnAddPosition: {
                startActivityForResult(new Intent(this,AddPositionActivity.class),Helper.CODE_ADD_POSITION);
            }
                break;
            default:
                break;
        }
    }


    void sss(){
        LinearLayout.LayoutParams params
                = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView tv = new TextView(this);
        tv.setLayoutParams(params);

        tv.setText("sdfsdfsdfs");

        llAddOperation.addView(tv,llAddOperation.getChildCount()-1);
    }


    @Override
    public void onSetDate(Calendar calendar) {
        calDate.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
        calDate.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        calDate.set(Calendar.YEAR, calendar.get(Calendar.YEAR));

        setTextDateAndTime(calendar);
    }

    @Override
    public void onSetTime(Calendar calendar) {
        calDate.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        calDate.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));

        setTextDateAndTime(calendar);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    private void setTextDateAndTime(Calendar calendar) {
        tvTime.setText(Helper.sdf_HHmm.format(calendar.getTime()));
        tvDate.setText(Helper.sdf_ddMMyyyy.format(calendar.getTime()));
    }
}
