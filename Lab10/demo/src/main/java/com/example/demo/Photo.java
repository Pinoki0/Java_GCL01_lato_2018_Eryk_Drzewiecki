package com.example.demo;

import java.io.Serializable;

public class Photo implements Serializable {

    private static final long serialVersionUID = 4869938283265271350L;
    private final int index;
    private final String name;
    private final String resolution;
    private final int size;
    private final long created;

    public Photo(int index, String name, String resolution, int size, long created) {
        this.index = index;
        this.name = name;
        this.resolution = resolution;
        this.size = size;
        this.created = created;
    }


    public int getIndex() {
        return index;

    }

    public String getName() {
        return name;
    }

    public String getResolution() {
        return resolution;
    }

    public int getSize() {
        return size;
    }

    public long getCreated() {
        return created;
    }
}
