package com.simplilearn.cabproapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Parsed {

   @SerializedName("housenumber")
   private String housenumber;

   @SerializedName("street")
   private String street;

   @SerializedName("postcode")
   private String postcode;

   @SerializedName("district")
   private String district;

   @SerializedName("country")
   private String country;

   @SerializedName("expected_type")
   private String expectedType;
}