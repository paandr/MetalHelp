package com.gmail.gorbaserver.metalhelp.calculator;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.gorbaserver.metalhelp.R;

import java.text.DecimalFormat;

import static com.gmail.gorbaserver.metalhelp.classes.Helper.calcWeightTrubaKruglaya;
import static com.gmail.gorbaserver.metalhelp.classes.Helper.getDoubleFromEditText;

public class CalcTrubaKruglayaFragment extends CalculatorFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvHeader.setText(getString(R.string.calc_truba_kruglaya_header));
        tvDiameter.setText(getString(R.string.diameter_mm));
        tvValue.setText(getString(R.string.length_m));
        tvResult.setText(getString(R.string.weight_kg));

        btnOk.setOnClickListener(this);

        spinnerMetalType.setVisibility(View.GONE);
        llToggleButtonsConvert.setVisibility(View.GONE);
        spinnerSize.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnOk) {

            double diameter, thickness, length, weight;

            diameter = getDoubleFromEditText(etDiameter.getText().toString());
            thickness = getDoubleFromEditText(etThickness.getText().toString());
            length = getDoubleFromEditText(etValue.getText().toString());

            if (length <= 0) {
                createAlertDialog("Длина должна быть больше нуля!").show();
                return;
            }
            if (diameter <= 0) {
                createAlertDialog("Диаметр должен быть больше нуля!").show();
                return;
            }
            if (thickness >= diameter) {
                createAlertDialog("Толщина стенки должна быть меньше наружного диаметра!").show();
                return;
            }

            weight = calcWeightTrubaKruglaya(diameter, thickness, length);
            DecimalFormat df = new DecimalFormat("#.###");
            etResult.setText(df.format(weight));
        }
    }




}
