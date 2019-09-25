package com.nikhil.paritytest.networks;

import com.nikhil.paritytest.networks.Response.DealResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface RetrofitInterface {


    @GET("top.json")
    Call<DealResponse> callTopDeals(@Header("X-Desidime-Client") String header);

    @GET("popular.json")
    Call<DealResponse> callPopularDeals(@Header("X-Desidime-Client") String header);

    @GET("featured.json")
    Call<DealResponse> callFeaturedDeals(@Header("X-Desidime-Client") String header);
}
