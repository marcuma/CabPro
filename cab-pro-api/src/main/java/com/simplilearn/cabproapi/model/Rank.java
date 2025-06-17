package com.simplilearn.cabproapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Rank {

   @SerializedName("importance")
   private double importance;

   @SerializedName("popularity")
   private double popularity;

   @SerializedName("confidence")
   private int confidence;

   @SerializedName("confidence_city_level")
   private int confidenceCityLevel;

   @SerializedName("confidence_street_level")
   private int confidenceStreetLevel;

   @SerializedName("confidence_building_level")
   private int confidenceBuildingLevel;

   @SerializedName("match_type")
   private String matchType;
}