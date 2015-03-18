package com.Codelabs.crimezone;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentDetailKejahatan extends Fragment {

    public FragmentDetailKejahatan() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_detail_kejahatan, container, false);

        return rootView;
    }
}
