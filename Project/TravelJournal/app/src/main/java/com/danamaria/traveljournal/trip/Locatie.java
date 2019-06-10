package com.danamaria.traveljournal.trip;

import java.io.Serializable;

public class Locatie implements Serializable {

    private String mTitlu;
    private String mSubtitlu;
    private Integer mImgId;

    public Locatie(String mTitlu, String mSubtitlu, Integer mImgId) {
        this.mTitlu = mTitlu;
        this.mSubtitlu = mSubtitlu;
        this.mImgId = mImgId;
    }

    public Locatie() {
    }

    public String getmTitlu() {
        return mTitlu;
    }

    public void setmTitlu(String mTitlu) {
        this.mTitlu = mTitlu;
    }

    public String getmSubtitlu() {
        return mSubtitlu;
    }

    public void setmSubtitlu(String mSubtitlu) {
        this.mSubtitlu = mSubtitlu;
    }

    public Integer getmImgId() {
        return mImgId;
    }

    public void setmImgId(Integer mImgId) {
        this.mImgId = mImgId;
    }
}
