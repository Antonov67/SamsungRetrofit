package com.example.samsungretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Authors {

    @SerializedName("authors")
    @Expose
    public List<String> authors;

}