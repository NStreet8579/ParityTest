package com.nikhil.paritytest.networks;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(){

        retrofit = new Retrofit.Builder()
                .baseUrl("https://stagingapi.desidime.com/v3/deals/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
