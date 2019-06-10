package com.danamaria.traveljournal.trip;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import com.danamaria.traveljournal.BaseFragment;
import com.danamaria.traveljournal.R;
import com.danamaria.traveljournal.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddTripFragment extends BaseFragment {

    private Button mSaveBtn;
    private EditText mTripName;
    private EditText mDest;

    private RadioGroup mTripType;
    private SeekBar mPrice;

    private FirebaseFirestore mFirestore;

    public AddTripFragment() {
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
        return inflater.inflate(R.layout.fragment_add_trip, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setButtonClickListener();
    }

    @Override
    public void onResume() {
        super.onResume();
        setToolbarTitle("Add Trip");
    }

    private void initViews(View view) {
        mSaveBtn = view.findViewById(R.id.saveBtnAddTrip);
        mDest = view.findViewById(R.id.destinationEditTxtAddTrip);
        mTripName = view.findViewById(R.id.tripNameEditTxtAddTrip);
        mTripType = view.findViewById(R.id.tripTypeRdGroupAddTrip);
        mPrice = view.findViewById(R.id.priceSeekBarAddTrip);

        mFirestore = FirebaseFirestore.getInstance();
    }

    private void setButtonClickListener() {
        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tripName = mTripName.getText().toString();
                String destination = mDest.getText().toString();

                Locatie locatie = new Locatie(tripName, destination, 0);
                mFirestore.collection("trips")
                        .add(locatie)
                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                if (task.isSuccessful()) {
                                    BaseFragment.addFragment(getActivity(), R.id.content_main,
                                            new HomeFragment());
                                } else {
                                    Log.e("SERVER", "An error occured while inserting trip");
                                }
                            }
                        });
            }
        });
    }
}
