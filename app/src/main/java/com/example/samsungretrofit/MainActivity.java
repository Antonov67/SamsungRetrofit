package com.example.samsungretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://poetrydb.org";
    Retrofit retrofit;
    TextView textView;
    List<String> authorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PoetryService service = retrofit.create(PoetryService.class);
        Call<Authors> call = service.getAuthorList();
        call.enqueue(new Callback<Authors>() {
            @Override
            public void onResponse(Call<Authors> call, Response<Authors> response) {
                authorList.clear();
                authorList.addAll(response.body().authors);
                for (String s : authorList) {
                    textView.setText(textView.getText() + s + "\n");
                }
            }

            @Override
            public void onFailure(Call<Authors> call, Throwable t) {
                Toast.makeText(getApplication(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        Call<List<RandomPoem>>  call2 = service.getRandomPoem();
        call2.enqueue(new Callback<List<RandomPoem>>() {
            @Override
            public void onResponse(Call<List<RandomPoem>> call, Response<List<RandomPoem>> response) {
                Toast.makeText(MainActivity.this, response.body().get(0).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<RandomPoem>> call, Throwable t) {

            }
        });


    }
}