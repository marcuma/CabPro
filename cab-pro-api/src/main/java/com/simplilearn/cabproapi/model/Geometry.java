package com.simplilearn.cabproapi.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Geometry {

   @SerializedName("type")
   private String type;

   @SerializedName("coordinates")
   private List<Double> coordinates;
}