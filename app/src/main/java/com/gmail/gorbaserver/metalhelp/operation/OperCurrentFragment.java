package com.gmail.gorbaserver.metalhelp.operation;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.gmail.gorbaserver.metalhelp.R;
import com.gmail.gorbaserver.metalhelp.classes.DBMetal;
import com.gmail.gorbaserver.metalhelp.classes.Helper;
import com.gmail.gorbaserver.metalhelp.classes.Operation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static com.gmail.gorbaserver.metalhelp.classes.Helper.writeToLog;


public class OperCurrentFragment extends OperationFragment {

    DBMetal dbMetal;
    ListView lvList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_operation, container, false);

        lvList = (ListView) v.findViewById(R.id.lvList);

        writeToLog(this.getClass().getCanonicalName()+" onCreateView");

        return v;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        writeToLog(this.getClass().getCanonicalName()+" onViewCreated");
        dbMetal = new DBMetal(getContext());
        dbMetal.open();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        writeToLog(this.getClass().getCanonicalName()+" onAttach");
    }

    @Override
    public void onResume() {
        super.onResume();
        writeToLog(this.getClass().getCanonicalName()+" onResume");
        ArrayList<Operation> operations = dbMetal.getOperations();

        ArrayList<Map<String, Object>> data = new ArrayList<>();

        Map<String, Object> map;

        for (Operation o : operations) {
            map = new HashMap<>();
            map.put(Helper.ATTRIBUTE_NAME, o.getName());
            map.put(Helper.ATTRIBUTE_POINT_FINISH, o.getFinish());
            map.put(Helper.ATTRIBUTE_DATE, Helper.sdf_ddMMyyyy.format(o.getDate()));
            map.put(Helper.ATTRIBUTE_TIME, Helper.sdf_HHmm.format(o.getDate()));
            data.add(map);
        }

        String[] from = {Helper.ATTRIBUTE_NAME,
                Helper.ATTRIBUTE_POINT_FINISH,
                Helper.ATTRIBUTE_DATE,
                Helper.ATTRIBUTE_TIME};

        int[] to = {R.id.tvName, R.id.tvPointFinish, R.id.tvDate,R.id.tvTime};

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), data, R.layout.item_operation_current, from, to);
        lvList.setAdapter(adapter);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dbMetal.close();
    }
}
