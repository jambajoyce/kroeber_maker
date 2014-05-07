package com.example.kroeber;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Configuration implements Serializable {

	public String name;
    public String color;
    public String height;
    public String frequency;

    public String getColor() {
        return color;
    }

    public String getHeight() {
        return height;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getName() {
        return name;
    }
}
