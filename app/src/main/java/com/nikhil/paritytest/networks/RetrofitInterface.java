package com.nikhil.paritytest.networks;

import com.nikhil.paritytest.networks.Response.DealResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RetrofitInterface {


    @GET
    Call<DealResponse> callDeals(@Url String url,
                                    @Header("X-Desidime-Client") String header,
                                    @Query("per_page")int perPage,
                                    @Query("page")int pageNo);

    @GET
    Call<DealResponse> callPopularDeals(@Header("X-Desidime-Client") String header);

    @GET
    Call<DealResponse> callFeaturedDeals(@Header("X-Desidime-Client") String header,
                                         @Query("per_page")int perPage,
                                         @Query("page")int pageNo);
}
