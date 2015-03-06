package com.Codelabs.crimezone;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Alfons on 3/3/2015.
 */
public class FragmentTimeline extends Fragment {

    public FragmentTimeline() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_timeline, container, false);

        return rootView;
    }
}
