package com.example.kroeber;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Configuration implements Serializable {

	public String name;
    public char color;
    public char height;
    public char frequency;

    public char getColor() {
        return color;
    }

    public char getHeight() {
        return height;
    }

    public char getFrequency() {
        return frequency;
    }

    public String getName() {
        return name;
    }
}
