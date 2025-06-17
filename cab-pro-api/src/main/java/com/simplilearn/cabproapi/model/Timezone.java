package com.simplilearn.cabproapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Timezone {

   @SerializedName("name")
   private String name;

   @SerializedName("offset_STD")
   private String offsetSTD;

   @SerializedName("offset_STD_seconds")
   private int offsetSTDSeconds;

   @SerializedName("offset_DST")
   private String offsetDST;

   @SerializedName("offset_DST_seconds")
   private int offsetDSTSeconds;

   @SerializedName("abbreviation_STD")
   private String abbreviationSTD;

   @SerializedName("abbreviation_DST")
   private String abbreviationDST;
}