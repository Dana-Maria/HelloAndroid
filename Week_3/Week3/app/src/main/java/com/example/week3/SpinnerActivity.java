package com.example.week3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    private List<String> mSweets;
    private Spinner mSpinnerSweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        initView();
        populateList();
        setAdapter();

    }

    private void initView()
    {
        mSpinnerSweets = findViewById(R.id.spinner_id);
    }

    private void populateList()
    {
        mSweets = new ArrayList<>();
        mSweets.add("Cupcake");
        mSweets.add("Donut");
        mSweets.add("Eclair");
        mSweets.add("KitKat");
        mSweets.add("Pie");
    }


    private void setAdapter()
    {
        mSpinnerSweets.setAdapter(new ArrayAdapter<>(SpinnerActivity.this, android.R.layout.simple_list_item_1, mSweets));
    }
}
