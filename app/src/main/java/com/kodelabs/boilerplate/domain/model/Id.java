package com.kodelabs.boilerplate.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Guendouz on 22/11/2016.
 */

public class Id implements Parcelable {

    private String name;
    private String value;

    public Id() {
    }

    protected Id(Parcel in) {
        name = in.readString();
        value = in.readString();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(value);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Id> CREATOR = new Creator<Id>() {
        @Override
        public Id createFromParcel(Parcel in) {
            return new Id(in);
        }

        @Override
        public Id[] newArray(int size) {
            return new Id[size];
        }
    };
}
