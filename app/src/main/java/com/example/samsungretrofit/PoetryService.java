package com.example.samsungretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PoetryService {

    @GET("author")
    Call<Authors> getAuthorList();

    @GET("random")
    Call<List<RandomPoem>> getRandomPoem();

}
