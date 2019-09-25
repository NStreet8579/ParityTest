package com.nikhil.paritytest.ui.Deals.Fragments.PopularDeals;

import com.nikhil.paritytest.networks.Response.DealResponse;
import com.nikhil.paritytest.repositories.DealsDataSourceFactory;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

public class PopularDealsViewModel extends ViewModel {


    LiveData<PagedList<DealResponse.Datum>> dataList;
    LiveData<PageKeyedDataSource<Integer, DealResponse.Datum>> liveDataSource;

    //constructor
    public PopularDealsViewModel() {
        //getting our data source factory
        DealsDataSourceFactory dealsDataSourceFactory = new DealsDataSourceFactory("popular.json","68045fd226ab32029c98bf4533bfa98b3c50423094d292d70ca2702e61a9679b");

        //getting the live data source from data source factory
        liveDataSource = dealsDataSourceFactory.getDealLiveDataSource();

        //Getting PagedList config
        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(10).build();

        //Building the paged list
        dataList = (new LivePagedListBuilder(dealsDataSourceFactory, pagedListConfig))
                .build();
    }
}
