package com.gmail.gorbaserver.metalhelp.calculator;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.gmail.gorbaserver.metalhelp.classes.DBMetal;
import com.gmail.gorbaserver.metalhelp.classes.Helper;
import com.gmail.gorbaserver.metalhelp.classes.MetalItem;
import com.gmail.gorbaserver.metalhelp.R;

import java.text.DecimalFormat;

import static com.gmail.gorbaserver.metalhelp.classes.Helper.getDoubleFromEditText;

public class CalculatorFragment extends Fragment {

    Button btnOk;

    EditText etDiameter;
    EditText etValue;
    EditText etResult;
    EditText etThickness;

    TextView tvHeader;
    TextView tvDiameter;
    TextView tvValue;
    TextView tvResult;

    ToggleButton tbLengthToWeight;
    ToggleButton tbWeightToLength;

    LinearLayout llToggleButtonsConvert;
    LinearLayout llThickness;
    LinearLayout llDiameter;

    Spinner spinnerSize;
    Spinner spinnerMetalType;

    DBMetal dbMetal;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calculate_item, container, false);

        btnOk = (Button) v.findViewById(R.id.btnOk);
        etDiameter = (EditText) v.findViewById(R.id.etDiameter);
        etThickness = (EditText) v.findViewById(R.id.etThickness);
        etValue = (EditText) v.findViewById(R.id.etValue);
        etResult = (EditText) v.findViewById(R.id.etResult);

        tvHeader = (TextView)v.findViewById(R.id.header);
        tvDiameter = (TextView)v.findViewById(R.id.tvDiameter);
        tvValue = (TextView) v.findViewById(R.id.tvValue);
        tvResult = (TextView) v.findViewById(R.id.tvResult);

        tbLengthToWeight = (ToggleButton) v.findViewById(R.id.tbLengthToWeight);
        tbWeightToLength = (ToggleButton) v.findViewById(R.id.tbWeightToLength);

        llToggleButtonsConvert = (LinearLayout)v.findViewById(R.id.llToggleButtonsConvert);
        llThickness = (LinearLayout)v.findViewById(R.id.llThickness);
        llDiameter = (LinearLayout)v.findViewById(R.id.llDiameter);

        spinnerSize = (Spinner) v.findViewById(R.id.spinnerSize);
        spinnerMetalType = (Spinner) v.findViewById(R.id.spinnerMetalType);

        dbMetal = new DBMetal(getContext());
        dbMetal.open();

        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        dbMetal.close();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dbMetal.close();
    }

    public void checkButtons(View view) {

        tbLengthToWeight.setChecked(false);
        tbWeightToLength.setChecked(false);

        switch (view.getId()) {
            case R.id.tbLengthToWeight:
                tbLengthToWeight.setChecked(true);
                tvValue.setText(getString(R.string.length_m));
                tvResult.setText(getString(R.string.weight_kg));
                break;
            case R.id.tbWeightToLength:
                tbWeightToLength.setChecked(true);
                tvValue.setText(getString(R.string.weight_kg));
                tvResult.setText(getString(R.string.length_m));
                break;
        }
    }




    public AlertDialog createAlertDialog(String message) {
        AlertDialog.Builder adb = new AlertDialog.Builder(getContext());
        adb.setTitle(getString(R.string.attention))
                .setNeutralButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage(message);

        return adb.create();
    }


}
