package com.example.samsungretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RandomPoem {

    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("author")
    @Expose
    public String author;
    @SerializedName("lines")
    @Expose
    public List<String> lines;
    @SerializedName("linecount")
    @Expose
    public String linecount;

    @Override
    public String toString() {
        return "RandomPoem{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", lines=" + lines +
                ", linecount='" + linecount + '\'' +
                '}';
    }
}