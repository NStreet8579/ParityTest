package com.nikhil.paritytest.networks;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    private static RetrofitClient mInstance;


    private RetrofitClient(){

        retrofit = new Retrofit.Builder()
                .baseUrl("https://stagingapi.desidime.com/v3/deals/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){

        if (mInstance == null){
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public RetrofitInterface getApi(){

        return retrofit.create(RetrofitInterface.class);
    }
}
