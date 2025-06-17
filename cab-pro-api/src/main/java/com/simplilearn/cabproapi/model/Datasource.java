package com.simplilearn.cabproapi.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;


@Data
public class Datasource {

   @SerializedName("sourcename")
   private String sourcename;

   @SerializedName("attribution")
   private String attribution;

   @SerializedName("license")
   private String license;

   @SerializedName("url")
   private String url;

}