package com.danamaria.traveljournal.trip;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.danamaria.traveljournal.BaseFragment;
import com.danamaria.traveljournal.R;
import com.danamaria.traveljournal.home.HomeFragment;
import com.danamaria.traveljournal.trip.Locatie;


/**
 * A simple {@link Fragment} subclass.
 */
public class TripDetailsFragment extends BaseFragment {

    private TextView mTripName;
    private TextView mDest;
    private ImageView mImg;
    private Button mBack;


    public TripDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trip_details, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        setButtonClickListener();
    }

    @Override
    public void onResume() {
        super.onResume();
        setToolbarTitle("Trip Details");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getData(this.getArguments());
    }

    private void initView(View view) {
        mTripName = view.findViewById(R.id.tripNameDetails);
        mDest = view.findViewById(R.id.destDetails);
        mImg = view.findViewById(R.id.imgDetails);
        mBack = view.findViewById(R.id.backButton);
    }

    private void setButtonClickListener() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseFragment.addFragment(getActivity(), R.id.content_main, new HomeFragment());
            }
        });
    }

    private void getData(Bundle savedInstanceState) {
        Locatie locatie = (Locatie)savedInstanceState.get("trip");

        mTripName.setText(locatie.getmTitlu());
        mDest.setText(locatie.getmSubtitlu());
        mImg.setImageResource(locatie.getmImgId());
    }
}
