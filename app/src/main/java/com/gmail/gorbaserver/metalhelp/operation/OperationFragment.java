package com.gmail.gorbaserver.metalhelp.operation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.gorbaserver.metalhelp.R;

import static com.gmail.gorbaserver.metalhelp.classes.Helper.writeToLog;



public class OperationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_operation, container, false);

        TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.tabs);

        //String str = tabLayout.getTabAt(tabLayout.getSelectedTabPosition()).getText().toString();
        //((TextView) v.findViewById(R.id.tvTest)).setText("Test"+this.hashCode());

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
