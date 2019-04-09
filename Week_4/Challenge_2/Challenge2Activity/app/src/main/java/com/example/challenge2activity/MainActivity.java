package com.example.challenge2activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewPersoana;
    private List<Persoana> mPersoana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setLayoutActvity();
        setAdapter();
        setPersoana();

    }

    private void setAdapter() {
        mPersoana = new ArrayList<>();
        Persoana pers1 = new Persoana("Nume 1", "Prenume 1" );
        Persoana pers2 = new Persoana("Nume 2", "Prenume 2" );
        Persoana pers3 = new Persoana("Nume 3", "Prenume 3" );
        Persoana pers4 = new Persoana("Nume 4", "Prenume 4" );
        Persoana pers5 = new Persoana("Nume 5", "Prenume 5" );
        Persoana pers6 = new Persoana("Nume 6", "Prenume 6" );
        mPersoana.add(pers1);
        mPersoana.add(pers2);
        mPersoana.add(pers3);
        mPersoana.add(pers4);
        mPersoana.add(pers5);
        mPersoana.add(pers6);
    }

    private void setPersoana() {

        PersAdapter persAdapter = new PersAdapter(mPersoana);
        mRecyclerViewPersoana.setAdapter(persAdapter);
    }

    private void setLayoutActvity() {

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this);
        mRecyclerViewPersoana.setLayoutManager(layoutManager);

    }

    private void initView() {
       mRecyclerViewPersoana = findViewById(R.id.recycler_view_name);
    }
}
