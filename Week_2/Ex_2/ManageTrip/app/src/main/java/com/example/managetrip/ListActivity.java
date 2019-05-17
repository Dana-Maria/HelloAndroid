package com.example.managetrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewLocatie;
    private List<Locatie> mLocatii;
    private Button mAddTripBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initView();
        setLayoutActivity();
        setAdapter();
        setLocatie();
        setButtonClickEvents();
    }

    private void setButtonClickEvents() {
        mAddTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListActivity.this, MainActivity.class));
            }
        });
    }

    private void setLocatie() {
        LocatieAdapter locatieAdapter = new LocatieAdapter(mLocatii);
        mRecyclerViewLocatie.setAdapter(locatieAdapter);

    }

    private void setAdapter() {

        mLocatii = new ArrayList<>();
        Locatie loc_1 = new Locatie("Holiday 2018","Bahamas",R.drawable.poza_bahamas);
        Locatie loc_2 = new Locatie("Fall 2018","Madrid",R.drawable.poza_madrid);
        Locatie loc_3 = new Locatie("Winter 2018","Londra",R.drawable.poza_londra);
        Locatie loc_4 = new Locatie("Summer 2018","Paris",R.drawable.poza_paris);
        Locatie loc_5 = new Locatie("Spring 2018","Los Angeles",R.drawable.poza_la);

        mLocatii.add(loc_1);
        mLocatii.add(loc_2);
        mLocatii.add(loc_3);
        mLocatii.add(loc_4);
        mLocatii.add(loc_5);
    }

    private void setLayoutActivity() {

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this);
        mRecyclerViewLocatie.setLayoutManager(layoutManager);
    }

    private void initView() {
        mRecyclerViewLocatie = findViewById(R.id.listaCalatorii);
        mAddTripBtn = findViewById(R.id.addTripBtn);
    }
}
