package com.gmail.gorbaserver.metalhelp.classes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

import static com.gmail.gorbaserver.metalhelp.classes.Helper.writeToLog;


public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public interface OnSetDateListener {
        public abstract void onSetDate(Calendar calendar);
    }


    OnSetDateListener dateListener;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.dateListener = (OnSetDateListener) activity;
        }
        catch (final ClassCastException e) {
            writeToLog(activity.toString() + " must implement OnCompleteListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use the current date as the default date in the date picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT,this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,i);
        c.set(Calendar.MONTH,i1);
        c.set(Calendar.DAY_OF_MONTH,i2);
        dateListener.onSetDate(c);
    }
}
