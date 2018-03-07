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


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements View.OnClickListener {

    ToggleButton tbColdWarm,tbOtsynkovany,tbRifleny;
    ListView listView;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_list, container, false);

        tbColdWarm = (ToggleButton)view.findViewById(R.id.tbColdWarm);
        tbOtsynkovany = (ToggleButton)view.findViewById(R.id.tbOtsynkovany);
        tbRifleny = (ToggleButton)view.findViewById(R.id.tbRifleny);
        listView = (ListView) view.findViewById(R.id.lvList) ;

        tbColdWarm.setOnClickListener(this);
        tbOtsynkovany.setOnClickListener(this);
        tbRifleny.setOnClickListener(this);

        tbColdWarm.setChecked(true);

        ArrayList<MetalItem> items = getItemsByTypeName(getString(R.string.type_list_stalnoy));
        setAdapter(items,listView);

        return view;
    }


    @Override
    public void onClick(View view) {
        tbColdWarm.setChecked(false);
        tbOtsynkovany.setChecked(false);
        tbRifleny.setChecked(false);

        ((ToggleButton)view).setChecked(true);
        String typeName = "";

        switch (view.getId()){
            case R.id.tbColdWarm: typeName = getString(R.string.type_list_stalnoy); break;
            case R.id.tbOtsynkovany: typeName = getString(R.string.type_list_otsynkovany); break;
            case R.id.tbRifleny: typeName = getString(R.string.type_list_rifleny); break;
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
            map.put(Helper.ATTRIBUTE_SIZE, item.getSize());
            map.put(Helper.ATTRIBUTE_WEIGHT, item.getWeightString());
            data.add(map);
        }

        String[] from = {
                Helper.ATTRIBUTE_NAME,
                Helper.ATTRIBUTE_SIZE,
                Helper.ATTRIBUTE_WEIGHT
        };

        int[] to = {R.id.tvName, R.id.tvSize, R.id.tvWeight};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), data, R.layout.item_name_size_weight, from, to);

        listView.setAdapter(simpleAdapter);
    }

}
