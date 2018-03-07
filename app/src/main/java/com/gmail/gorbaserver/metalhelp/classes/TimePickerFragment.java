package com.gmail.gorbaserver.metalhelp.classes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    public interface OnSetTimeListener{
        public abstract void onSetTime(Calendar calendar);
    }

    OnSetTimeListener timeListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.timeListener = (OnSetTimeListener)activity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //Use the current date as the default date in the date picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT,this,hour,minute,true);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,i);
        c.set(Calendar.MINUTE,i1);
        timeListener.onSetTime(c);
    }
}
