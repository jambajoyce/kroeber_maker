package com.example.kroeber;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Configuration implements Serializable {

	public String name;
    public int color;
    public int height;
    public int frequency;

    public int getColor() {
        return color;
    }

    public int getHeight() {
        return height;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getName() {
        return name;
    }
}
