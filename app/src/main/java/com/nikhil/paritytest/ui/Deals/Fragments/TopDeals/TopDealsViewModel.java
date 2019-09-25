package com.nikhil.paritytest.ui.Deals.Fragments.TopDeals;

import com.nikhil.paritytest.networks.Response.DealResponse;
import com.nikhil.paritytest.respositories.DealsRespositoty;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TopDealsViewModel extends ViewModel {



    private MutableLiveData<DealResponse> mutableLiveData;
    private DealsRespositoty dealsRespositoty;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        dealsRespositoty = DealsRespositoty.getInstance();
    }
    public MutableLiveData<DealResponse> getTopDeals(){
        return  dealsRespositoty.topDeals("68045fd226ab32029c98bf4533bfa98b3c50423094d292d70ca2702e61a9679b");
    }
}

