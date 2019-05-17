package com.example.managetrip;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class LocatieAdapter extends RecyclerView.Adapter<LocatieViewHolder> {

    private List<Locatie> mLocatii;

    public LocatieAdapter(List<Locatie> mLocatii) {
        this.mLocatii = mLocatii;
    }

    @NonNull
    @Override
    public LocatieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.travel_view, viewGroup, false);


        return new LocatieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LocatieViewHolder locatieViewHolder, int i) {

        Locatie curent = mLocatii.get(i);
        if(curent != null) {
            if (curent.getmImgId() != null) {
                locatieViewHolder.getmLocatiePoza().setImageResource(curent.getmImgId());
            }
            if(curent.getmTitlu() != null)
            {
                locatieViewHolder.getmLocatieTitlu().setText(curent.getmTitlu());
            }
            if(curent.getmSubtitlu() != null)
            {
                locatieViewHolder.getmLocatieSubtitlu().setText(curent.getmSubtitlu());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mLocatii.size();
    }
}
