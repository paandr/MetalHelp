package com.gmail.gorbaserver.metalhelp.tabletheory;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.ToggleButton;

import com.gmail.gorbaserver.metalhelp.classes.DBMetal;
import com.gmail.gorbaserver.metalhelp.classes.Helper;
import com.gmail.gorbaserver.metalhelp.classes.MetalItem;
import com.gmail.gorbaserver.metalhelp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TrubaProfilFragment extends Fragment implements View.OnClickListener {

    ToggleButton tbKvadratnaya,tbPryamougolnaya;
    ListView listView;


    public TrubaProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_truba_profil, container, false);

        tbKvadratnaya = (ToggleButton)v.findViewById(R.id.tbKvadratnaya);
        tbPryamougolnaya = (ToggleButton)v.findViewById(R.id.tbPryamougolnaya);

        listView = (ListView) v.findViewById(R.id.lvTrubaProfil) ;

        tbKvadratnaya.setOnClickListener(this);
        tbPryamougolnaya.setOnClickListener(this);

        tbKvadratnaya.setChecked(true);

        ArrayList<MetalItem> items = getItemsByTypeName(getString(R.string.type_truba_kvadratnaya));
        setAdapter(items,listView);

        return  v;
    }

    @Override
    public void onClick(View view) {
        tbKvadratnaya.setChecked(false);
        tbPryamougolnaya.setChecked(false);

        ((ToggleButton)view).setChecked(true);
        String typeName = "";

        switch (view.getId()){
            case R.id.tbPryamougolnaya: typeName = getString(R.string.type_truba_pryamougolnaya); break;
            case R.id.tbKvadratnaya: typeName = getString(R.string.type_truba_kvadratnaya); break;
        }

        Animation animHide = AnimationUtils.loadAnimation(getContext(),R.anim.hide);
        Animation animShow = AnimationUtils.loadAnimation(getContext(),R.anim.show);

        ArrayList<MetalItem> items = getItemsByTypeName(typeName);

        listView.startAnimation(animHide);
        setAdapter(items,listView);
        listView.startAnimation(animShow);
    }

    private ArrayList<MetalItem> getItemsByTypeName(String typeName){

        DBMetal dbMetal = new DBMetal(getContext());
        dbMetal.open();

        ArrayList<MetalItem> items = dbMetal.getMetalItemsByTypeName(typeName);

        dbMetal.close();

        return items;
    }

    private void setAdapter(ArrayList<MetalItem> items,ListView listView){
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;


        for (MetalItem item : items) {
            map = new HashMap<String, Object>();
            map.put(Helper.ATTRIBUTE_NAME, item.getName());
            map.put(Helper.ATTRIBUTE_WEIGHT, item.getWeightString());
            map.put(Helper.ATTRIBUTE_METER_IN_TONNE, item.getMeterInTonneString());
            data.add(map);
        }

        String[] from = {
                Helper.ATTRIBUTE_NAME,
                Helper.ATTRIBUTE_WEIGHT,
                Helper.ATTRIBUTE_METER_IN_TONNE
        };

        int[] to = {R.id.tvName, R.id.tvWeight, R.id.tvMeterInTonne};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), data, R.layout.item_name_weight_meter, from, to);

        listView.setAdapter(simpleAdapter);
    }



}
