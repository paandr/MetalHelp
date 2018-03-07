package com.gmail.gorbaserver.metalhelp.tabletheory;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.gmail.gorbaserver.metalhelp.classes.DBItem;
import com.gmail.gorbaserver.metalhelp.classes.DBMetal;
import com.gmail.gorbaserver.metalhelp.classes.Helper;
import com.gmail.gorbaserver.metalhelp.classes.MetalItem;
import com.gmail.gorbaserver.metalhelp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.gmail.gorbaserver.metalhelp.classes.Helper.writeToLog;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArmaturaFragment extends Fragment {

    ListView lvArmatura;
    ArrayAdapter<MetalItem> adapter;
    DBMetal dbMetal;

    public ArmaturaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_armatura, null);

        dbMetal = new DBMetal(getContext());
        dbMetal.open();


        lvArmatura = (ListView) v.findViewById(R.id.lvArmaturaFragment);

        ArrayList<MetalItem> items = dbMetal.getMetalItemsByTypeName(DBItem.Armatura.NAME);

        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;


        for (MetalItem item : items) {
            map = new HashMap<String, Object>();
            map.put(Helper.ATTRIBUTE_NAME, item.getName());
            map.put(Helper.ATTRIBUTE_WEIGHT, item.getWeightString());
            map.put(Helper.ATTRIBUTE_METER_IN_TONNE, item.getMeterInTonneString());
            data.add(map);
        }

        String[] from = {Helper.ATTRIBUTE_NAME,
                Helper.ATTRIBUTE_WEIGHT,
                Helper.ATTRIBUTE_METER_IN_TONNE};

        int[] to = {R.id.tvName, R.id.tvWeight, R.id.tvMeterInTonne};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), data, R.layout.item_name_weight_meter, from, to);

        lvArmatura.setAdapter(simpleAdapter);

        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        dbMetal.close();

    }
}
