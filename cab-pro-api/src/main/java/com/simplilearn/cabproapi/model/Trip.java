package com.simplilearn.cabproapi.model;

import lombok.Data;

@Data
public class Trip {
    private String from;
    private String to;
    private String cabRate;
    private String rate;
    private String distance;
    private double fromLatitude;
    private double fromLongitude;
    private double toLatitude;
    private double toLongitude;
}
