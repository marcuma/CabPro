package com.simplilearn.cabproapi.model;

import lombok.Data;

@Data
public class GeoProperties {
    private Datasource datasource;
    private String country;
    private String country_code;
    private String state;
    private String county;
    private String city;
    private String postcode;
    private String street;
    private String housenumber;
    private String iso3166_2;
    private double lon;
    private double lat;
    private String state_code;
    private String result_type;
    private String formatted;
    private String address_line1;
    private String address_line2;
    private Timezone timezone;
    private String plus_code;
    private Rank rank;
    private String place_id;
}
