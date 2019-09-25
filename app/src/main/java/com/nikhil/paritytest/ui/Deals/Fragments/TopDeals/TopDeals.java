package com.nikhil.paritytest.ui.Deals.Fragments.TopDeals;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nikhil.paritytest.Adapters.DealsPagingAdapter;
import com.nikhil.paritytest.R;
import com.nikhil.paritytest.networks.Response.DealResponse;

public class TopDeals extends Fragment {

    private TopDealsViewModel mViewModel;

    public static TopDeals newInstance() {
        return new TopDeals();
    }

    RecyclerView rvTopDeals;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = ViewModelProviders.of(this).get(TopDealsViewModel.class);

        View view = inflater.inflate(R.layout.top_deals_fragment, container, false);

        rvTopDeals = view.findViewById(R.id.recycler_top_deals);
        DealsPagingAdapter dealsPagingAdapter = new DealsPagingAdapter(getContext());
        rvTopDeals.setLayoutManager(new LinearLayoutManager(getContext()));

       mViewModel.dataList.observe(this, new Observer<PagedList<DealResponse.Datum>>() {
           @Override
           public void onChanged(PagedList<DealResponse.Datum> data) {
                dealsPagingAdapter.submitList(data);
           }
       });

        rvTopDeals.setAdapter(dealsPagingAdapter);
        return view;
    }
}
