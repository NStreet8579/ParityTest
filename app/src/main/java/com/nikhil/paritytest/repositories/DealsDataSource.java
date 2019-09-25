package com.nikhil.paritytest.repositories;

import com.nikhil.paritytest.networks.Response.DealResponse;
import com.nikhil.paritytest.networks.RetrofitClient;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DealsDataSource extends PageKeyedDataSource<Integer, DealResponse.Datum> {

    private String url,header;
    private static final int FIRST_PAGE= 1;

    DealsDataSource(String url, String header){
        this.url = url;
        this.header = header;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, DealResponse.Datum> callback) {

        RetrofitClient.getInstance().getApi().callDeals(url,header,10,FIRST_PAGE)
            .enqueue(new Callback<DealResponse>() {
                @Override
                public void onResponse(Call<DealResponse> call, Response<DealResponse> response) {
                    if (response.isSuccessful()){
                        callback.onResult(response.body().deals.data,null,FIRST_PAGE+1);
                    }
                }

                @Override
                public void onFailure(Call<DealResponse> call, Throwable t) {
                    t.printStackTrace();
                }
            });

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, DealResponse.Datum> callback) {


        RetrofitClient.getInstance().getApi().callDeals(url,header,10,params.key)
        .enqueue(new Callback<DealResponse>() {
            @Override
            public void onResponse(Call<DealResponse> call, Response<DealResponse> response) {

                int perviousKey = (params.key>1)? params.key-1 : null;
                if (response.isSuccessful()){
                    callback.onResult(response.body().deals.data,perviousKey);
                }
            }

            @Override
            public void onFailure(Call<DealResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, DealResponse.Datum> callback) {

        RetrofitClient.getInstance().getApi().callDeals(url,header,10,params.key)
        .enqueue(new Callback<DealResponse>() {
            @Override
            public void onResponse(Call<DealResponse> call, Response<DealResponse> response) {
                callback.onResult(response.body().deals.data,params.key+1);
            }

            @Override
            public void onFailure(Call<DealResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
