package com.kodelabs.boilerplate.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jsivianes on 7/2/18.
 */

public class Picture implements Parcelable {

    private String large;
    private String medium;
    private String thumbnail;

    public Picture() {
    }

    protected Picture(Parcel in) {
        large = in.readString();
        medium = in.readString();
        thumbnail = in.readString();
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(large);
        dest.writeString(medium);
        dest.writeString(thumbnail);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Picture> CREATOR = new Creator<Picture>() {
        @Override
        public Picture createFromParcel(Parcel in) {
            return new Picture(in);
        }

        @Override
        public Picture[] newArray(int size) {
            return new Picture[size];
        }
    };

}