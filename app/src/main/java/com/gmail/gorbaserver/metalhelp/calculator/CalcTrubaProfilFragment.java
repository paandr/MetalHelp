package com.gmail.gorbaserver.metalhelp.calculator;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.gmail.gorbaserver.metalhelp.classes.Helper;
import com.gmail.gorbaserver.metalhelp.classes.MetalItem;
import com.gmail.gorbaserver.metalhelp.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.gmail.gorbaserver.metalhelp.classes.Helper.getDoubleFromEditText;

public class CalcTrubaProfilFragment extends CalculatorFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvHeader.setText(getString(R.string.calc_truba_kvadratnaya_header));
        tvDiameter.setText(getString(R.string.size_mm_x_mm_x_mm));

        etDiameter.setVisibility(View.GONE);
        llThickness.setVisibility(View.GONE);

        btnOk.setOnClickListener(this);
        tbWeightToLength.setOnClickListener(this);
        tbLengthToWeight.setOnClickListener(this);

        initSpinnerSize(getString(R.string.type_truba_kvadratnaya));

        super.checkButtons(tbLengthToWeight);

        String[] types = {
                getString(R.string.type_truba_kvadratnaya), getString(R.string.type_truba_pryamougolnaya)};
        ArrayAdapter<String> adapterType
                = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, types);
        spinnerMetalType.setAdapter(adapterType);
        spinnerMetalType.setOnItemSelectedListener(this);
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

    private void initSpinnerSize(String typeName){
        ArrayList<MetalItem> items = dbMetal.getMetalItemsByTypeName(typeName);
        ArrayAdapter<MetalItem> adapterSize
                = new ArrayAdapter<MetalItem>(getContext(), android.R.layout.simple_spinner_dropdown_item, items);
        spinnerSize.setAdapter(adapterSize);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        initSpinnerSize(adapterView.getSelectedItem().toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
