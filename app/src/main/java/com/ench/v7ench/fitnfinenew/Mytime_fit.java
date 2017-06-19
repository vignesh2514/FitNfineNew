package com.ench.v7ench.fitnfinenew;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vignesh2514 on 8/6/17.
 */

public class Mytime_fit implements Parcelable {
    String id;
    String timewise;
    String 	daywise;
    String task_fit;
    String image_task;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimewise() {
        return timewise;
    }

    public void setTimewise(String timewise) {
        this.timewise = timewise;
    }

    public String getDaywise() {
        return daywise;
    }

    public void setDaywise(String daywise) {
        this.daywise = daywise;
    }

    public String getTask_fit() {
        return task_fit;
    }

    public void setTask_fit(String task_fit) {
        this.task_fit = task_fit;
    }

    public String getImage_task() {
        return image_task;
    }

    public void setImage_task(String image_task) {
        this.image_task = image_task;
    }

    public static Creator<Mytime_fit> getCREATOR() {
        return CREATOR;
    }

    protected Mytime_fit(Parcel in) {
        id = in.readString();
        timewise = in.readString();
        daywise = in.readString();
        task_fit = in.readString();
        image_task = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(timewise);
        dest.writeString(daywise);
        dest.writeString(task_fit);
        dest.writeString(image_task);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Mytime_fit> CREATOR = new Creator<Mytime_fit>() {
        @Override
        public Mytime_fit createFromParcel(Parcel in) {
            return new Mytime_fit(in);
        }

        @Override
        public Mytime_fit[] newArray(int size) {
            return new Mytime_fit[size];
        }
    };
}
