package com.simplilearn.cabproapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoCode {

    @SerializedName("type")
    private String type;

    @SerializedName("features")
    private List<Features> features;

    @SerializedName("query")
    private Query query;

}
