package com.danamaria.traveljournal.home;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.danamaria.traveljournal.trip.AddTripFragment;
import com.danamaria.traveljournal.BaseFragment;
import com.danamaria.traveljournal.trip.Locatie;
import com.danamaria.traveljournal.trip.LocatieAdapter;
import com.danamaria.traveljournal.R;
import com.danamaria.traveljournal.RecyclerItemClickListener;
import com.danamaria.traveljournal.trip.TripDetailsFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    private RecyclerView mRecyclerViewLocatie;
    private Button mAddTripBtn;
    private List<Locatie> mLocatii;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
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
        setLayoutActivity();
        setAdapter();
        setLocatie();

        mRecyclerViewLocatie.addOnItemTouchListener(new RecyclerItemClickListener(getContext(),
                mRecyclerViewLocatie,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Fragment tripDetailsFragment = new TripDetailsFragment();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("trip", mLocatii.get(position));
                        tripDetailsFragment.setArguments(bundle);

                        BaseFragment.addFragment(getActivity(), R.id.content_main,
                                tripDetailsFragment);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        BaseFragment.addFragment(getActivity(), R.id.content_main,
                                new AddTripFragment());
                    }
                })
        );
    }

    @Override
    public void onResume() {
        super.onResume();
        setToolbarTitle("Home");
    }

    private void setButtonClickListener() {
        mAddTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseFragment.addFragment(getActivity(), R.id.content_main, new AddTripFragment());
            }
        });
    }

    private void setLocatie() {
        LocatieAdapter locatieAdapter = new LocatieAdapter(mLocatii);
        mRecyclerViewLocatie.setAdapter(locatieAdapter);

    }

    private void setAdapter() {

        getFirebaseLocations();

        Locatie loc_1 = new Locatie("Holiday 2018","Bahamas",R.mipmap.poza_bahamas);
        Locatie loc_2 = new Locatie("Fall 2018","Madrid",R.mipmap.poza_madrid);
        Locatie loc_3 = new Locatie("Winter 2018","Londra",R.mipmap.poza_londra);
        Locatie loc_4 = new Locatie("Summer 2018","Paris",R.mipmap.poza_paris);
        Locatie loc_5 = new Locatie("Spring 2018","Los Angeles",R.mipmap.poza_la);

        mLocatii.add(loc_1);
        mLocatii.add(loc_2);
        mLocatii.add(loc_3);
        mLocatii.add(loc_4);
        mLocatii.add(loc_5);
    }

    private void setLayoutActivity() {

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getContext());
        mRecyclerViewLocatie.setLayoutManager(layoutManager);
    }

    private void initView(View view) {
        mRecyclerViewLocatie = view.findViewById(R.id.listaCalatorii);
        mAddTripBtn = view.findViewById(R.id.addTripBtn);

        mLocatii = new ArrayList<>();
    }

    private void getFirebaseLocations() {
        FirebaseFirestore.getInstance().collection("trips")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot qds : task.getResult()) {
                                Locatie locatie = new Locatie();
                                locatie.setmTitlu(qds.get("mTitlu").toString());
                                locatie.setmSubtitlu(qds.get("mSubtitlu").toString());
                                locatie.setmImgId(R.mipmap.poza_bahamas);

                                mLocatii.add(locatie);
                            }
                            setLocatie();
                        }
                    }
                });
    }
}
