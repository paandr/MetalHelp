package com.gmail.gorbaserver.metalhelp.tabletheory;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.gmail.gorbaserver.metalhelp.classes.DBMetal;
import com.gmail.gorbaserver.metalhelp.classes.Helper;
import com.gmail.gorbaserver.metalhelp.classes.MetalItem;
import com.gmail.gorbaserver.metalhelp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class KvadratFragment extends Fragment {

    ListView lvKvadrat;
    ArrayAdapter<MetalItem> adapter;
    DBMetal dbMetal;

    public KvadratFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_kvadrat, null);

        dbMetal = new DBMetal(getContext());
        dbMetal.open();


        lvKvadrat = (ListView) v.findViewById(R.id.lvKvadratFragment);

        ArrayList<MetalItem> items = dbMetal.getMetalItemsByTypeName(getString(R.string.type_kvadrat));

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

        lvKvadrat.setAdapter(simpleAdapter);

        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        dbMetal.close();

    }
}
