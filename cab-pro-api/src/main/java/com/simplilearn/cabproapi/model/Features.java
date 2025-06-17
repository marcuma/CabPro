package com.simplilearn.cabproapi.model;

import java.util.List;
import java.util.Properties;

import com.google.gson.annotations.SerializedName;
import lombok.Data;


@Data
public class Features {

   @SerializedName("type")
   private String type;

   @SerializedName("properties")
   private GeoProperties properties;

   @SerializedName("geometry")
   private Geometry geometry;

   @SerializedName("bbox")
   private List<Double> bbox;
}