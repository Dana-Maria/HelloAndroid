package com.example.challenge2activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PersoanaViewHolder extends RecyclerView.ViewHolder {

    private TextView mPrenume;
    private TextView mNume;

    public TextView getmPrenume() {
        return mPrenume;
    }

    public TextView getmNume() {
        return mNume;
    }

    public PersoanaViewHolder(@NonNull View itemView) {
        super(itemView);

        mPrenume = itemView.findViewById(R.id.text_view_prenume);
        mNume = itemView.findViewById(R.id.text_view_nume);

    }
}
