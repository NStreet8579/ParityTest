/*
package com.nikhil.paritytest.repositories;

import com.nikhil.paritytest.networks.Response.DealResponse;
import com.nikhil.paritytest.networks.RetrofitClient;
import com.nikhil.paritytest.networks.RetrofitInterface;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DealsRespositoty {

    private static DealsRespositoty dealsRespositoty;

    public static DealsRespositoty getInstance(){
        if (dealsRespositoty == null){
            dealsRespositoty = new DealsRespositoty();
        }
        return dealsRespositoty;
    }

    public  MutableLiveData<DealResponse> topDeals(String header){

        final MutableLiveData<DealResponse> liveData = new MutableLiveData<>();

        Call<DealResponse> call = RetrofitClient.getInstance().getApi().callTopDeals(header);
        call.enqueue(new Callback<DealResponse>() {
            @Override
            public void onResponse(Call<DealResponse> call, Response<DealResponse> response) {

                if (response.isSuccessful()){
                    liveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<DealResponse> call, Throwable t) {
                t.printStackTrace();
                System.out.println(t.getMessage());
                liveData.setValue(null);
            }
        });
        return liveData;
    }

    public  MutableLiveData<DealResponse> popularDeals(String header){

        final MutableLiveData<DealResponse> liveData = new MutableLiveData<>();

        Call<DealResponse> call = RetrofitClient.getInstance().getApi().callPopularDeals(header);
        call.enqueue(new Callback<DealResponse>() {
            @Override
            public void onResponse(Call<DealResponse> call, Response<DealResponse> response) {


                if (response.isSuccessful()){
                    liveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<DealResponse> call, Throwable t) {


                t.printStackTrace();
                System.out.println(t.getMessage());
                liveData.setValue(null);
            }
        });
        return liveData;
    }

    public  MutableLiveData<DealResponse> featureDeals(String header){

        final MutableLiveData<DealResponse> liveData = new MutableLiveData<>();

        Call<DealResponse> call = RetrofitClient.getInstance().getApi().callFeaturedDeals(header);
        call.enqueue(new Callback<DealResponse>() {
            @Override
            public void onResponse(Call<DealResponse> call, Response<DealResponse> response) {


                if (response.isSuccessful()){
                    liveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<DealResponse> call, Throwable t) {


                t.printStackTrace();
                System.out.println(t.getMessage());
                liveData.setValue(null);
            }
        });
        return liveData;
    }

}
*/
