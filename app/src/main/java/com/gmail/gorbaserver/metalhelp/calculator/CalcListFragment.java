package com.gmail.gorbaserver.metalhelp.calculator;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.gmail.gorbaserver.metalhelp.classes.MetalItem;
import com.gmail.gorbaserver.metalhelp.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.gmail.gorbaserver.metalhelp.classes.Helper.getDoubleFromEditText;

public class CalcListFragment extends CalculatorFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvHeader.setText(getString(R.string.calc_list_header));
        tvDiameter.setText(getString(R.string.size_mm_x_mm_x_mm));
        tvValue.setText(getString(R.string.quantity_sht));
        tvResult.setText(getString(R.string.weight_kg));

        etDiameter.setVisibility(View.GONE);
        llThickness.setVisibility(View.GONE);
        llToggleButtonsConvert.setVisibility(View.GONE);

        btnOk.setOnClickListener(this);

        initSpinnerSize(getString(R.string.type_list_stalnoy));


        String[] types = {
                getString(R.string.type_list_stalnoy)
                ,getString(R.string.type_list_otsynkovany)
                ,getString(R.string.type_list_rifleny)};
        ArrayAdapter<String> adapterType
                = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, types);
        spinnerMetalType.setAdapter(adapterType);
        spinnerMetalType.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnOk:
                double weightInList, quantity;

                weightInList = ((MetalItem) spinnerSize.getSelectedItem()).getWeight();
                quantity = getDoubleFromEditText(etValue.getText().toString());

                DecimalFormat df = new DecimalFormat("#.###");
                etResult.setText(df.format(weightInList*quantity));

                break;
        }


    }

    private void initSpinnerSize(String typeName){
        ArrayList<MetalItem> items = dbMetal.getMetalItemsByTypeName(typeName);

        for (MetalItem item : items){
            item.setName(item.getName()+"x"+item.getSize());
        }

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
