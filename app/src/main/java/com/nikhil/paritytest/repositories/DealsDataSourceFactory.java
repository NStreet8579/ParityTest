package com.nikhil.paritytest.repositories;

import com.nikhil.paritytest.networks.Response.DealResponse;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

public class DealsDataSourceFactory extends DataSource.Factory {


    private MutableLiveData<PageKeyedDataSource<Integer, DealResponse.Datum>> dataSourceMutableLiveData = new MutableLiveData<>();
    private String url,header;

    public DealsDataSourceFactory(String url, String header){
        this.url = url;
        this.header = header;
    }

    @Override
    public DataSource<Integer, DealResponse.Datum> create() {

        DealsDataSource dealsDataSource = new DealsDataSource(url,header);
        dataSourceMutableLiveData.postValue(dealsDataSource);
        return dealsDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, DealResponse.Datum>> getDealLiveDataSource() {
        return dataSourceMutableLiveData;
    }
}
