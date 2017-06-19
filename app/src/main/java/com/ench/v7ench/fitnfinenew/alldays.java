package com.ench.v7ench.fitnfinenew;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vignesh2514 on 8/6/17.
 */

public class alldays implements Parcelable {
    String id;
    String daysofwhat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDaysofwhat() {
        return daysofwhat;
    }

    public void setDaysofwhat(String daysofwhat) {
        this.daysofwhat = daysofwhat;
    }

    public static Creator<alldays> getCREATOR() {
        return CREATOR;
    }

    protected alldays(Parcel in) {
        id = in.readString();
        daysofwhat = in.readString();
    }

    public static final Creator<alldays> CREATOR = new Creator<alldays>() {
        @Override
        public alldays createFromParcel(Parcel in) {
            return new alldays(in);
        }

        @Override
        public alldays[] newArray(int size) {
            return new alldays[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(daysofwhat);
    }
}
