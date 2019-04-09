package com.example.challenge2activity;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class PersAdapter extends RecyclerView.Adapter<PersoanaViewHolder> {

    private List<Persoana> lista_pers;

    public PersAdapter(List<Persoana> lista_pers) {
        this.lista_pers = lista_pers;
    }

    @NonNull
    @Override
    public PersoanaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.persoana_view, viewGroup, false);

        return new PersoanaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersoanaViewHolder persoanaViewHolder, int i) {

        Persoana curr = lista_pers.get(i);
        if (curr != null) {
            if (curr.getNume() != null) {
                persoanaViewHolder.getmNume().setText(curr.getNume());
            }
            if (curr.getPrenume() != null) {
                persoanaViewHolder.getmPrenume().setText(curr.getPrenume());
            }

        }

        if (i % 2 == 0) {
            persoanaViewHolder.itemView.setBackgroundColor(Color.GRAY);
        }
    }

    @Override
    public int getItemCount() {
        return lista_pers.size();
    }
}
