package com.simplilearn.cabproapi.model;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Query {

   @SerializedName("text")
   private String text;

   @SerializedName("parsed")
   private Parsed parsed;
}