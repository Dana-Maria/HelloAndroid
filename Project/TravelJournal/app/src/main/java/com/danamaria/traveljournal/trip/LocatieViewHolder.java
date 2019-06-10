package com.danamaria.traveljournal.trip;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.danamaria.traveljournal.R;

public class LocatieViewHolder extends RecyclerView.ViewHolder {


    private ImageView mLocatiePoza;
    private TextView mLocatieTitlu;
    private TextView mLocatieSubtitlu;

    public ImageView getmLocatiePoza() {
        return mLocatiePoza;
    }

    public TextView getmLocatieTitlu() {
        return mLocatieTitlu;
    }

    public TextView getmLocatieSubtitlu() {
        return mLocatieSubtitlu;
    }

    public LocatieViewHolder(@NonNull View itemView) {
        super(itemView);

        mLocatiePoza = itemView.findViewById(R.id.imgLocation);
        mLocatieSubtitlu = itemView.findViewById(R.id.textSubsol);
        mLocatieTitlu = itemView.findViewById(R.id.textTitlu);
    }
}
