package com.nikhil.paritytest.ui.Deals.Fragments.FeaturedDeals;

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

public class FeaturedDeals extends Fragment {

    private FeaturedDealsViewModel mViewModel;

    public static FeaturedDeals newInstance() {
        return new FeaturedDeals();
    }

    private RecyclerView rvFeatureDeals;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = ViewModelProviders.of(this).get(FeaturedDealsViewModel.class);

        View view = inflater.inflate(R.layout.featured_deals_fragment, container, false);

        rvFeatureDeals = view.findViewById(R.id.recycler_featured_deals);
        DealsPagingAdapter dealsPagingAdapter = new DealsPagingAdapter(getContext());
        rvFeatureDeals.setLayoutManager(new LinearLayoutManager(getContext()));

        mViewModel.dataList.observe(this, new Observer<PagedList<DealResponse.Datum>>() {
            @Override
            public void onChanged(PagedList<DealResponse.Datum> data) {
                dealsPagingAdapter.submitList(data);
            }
        });

        rvFeatureDeals.setAdapter(dealsPagingAdapter);
        return view;
    }
}
