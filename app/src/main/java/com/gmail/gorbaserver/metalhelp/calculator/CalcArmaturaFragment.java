package com.gmail.gorbaserver.metalhelp.calculator;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.gmail.gorbaserver.metalhelp.classes.Helper;
import com.gmail.gorbaserver.metalhelp.classes.MetalItem;
import com.gmail.gorbaserver.metalhelp.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.gmail.gorbaserver.metalhelp.classes.Helper.getDoubleFromEditText;

public class CalcArmaturaFragment extends CalculatorFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvHeader.setText(getString(R.string.calc_krug_header));
        tvDiameter.setText(getString(R.string.diameter_mm));

        btnOk.setOnClickListener(this);
        tbLengthToWeight.setOnClickListener(this);
        tbWeightToLength.setOnClickListener(this);

        etDiameter.setVisibility(View.GONE);
        llThickness.setVisibility(View.GONE);
spinnerMetalType.setVisibility(View.GONE);


        checkButtons(tbLengthToWeight);

        ArrayList<MetalItem> items = dbMetal.getMetalItemsByTypeName(getString(R.string.type_armatura));
        ArrayAdapter<MetalItem> adapter
                = new ArrayAdapter<MetalItem>(getContext(), android.R.layout.simple_spinner_dropdown_item, items);

        spinnerSize.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tbLengthToWeight:
            case R.id.tbWeightToLength:
                super.checkButtons(view);
                break;
            case R.id.btnOk:
                double weightInMeter, value, result = 0;

                weightInMeter = ((MetalItem) spinnerSize.getSelectedItem()).getWeight();
                value = getDoubleFromEditText(etValue.getText().toString());

                if (value <= 0) {
                    if (tbLengthToWeight.isChecked()) {
                        createAlertDialog("Длина должна быть больше нуля!").show();
                    } else if (tbWeightToLength.isChecked()) {
                        createAlertDialog("Вес должен быть больше нуля!").show();
                    }
                    return;
                }

                if (tbLengthToWeight.isChecked()) {
                    result = Helper.calcWeightInLength(weightInMeter, value);
                } else if (tbWeightToLength.isChecked()) {
                    result = Helper.calcLengthInWeight(weightInMeter, value);
                }

                DecimalFormat df = new DecimalFormat("#.###");
                etResult.setText(df.format(result));

                break;
        }


    }



}
