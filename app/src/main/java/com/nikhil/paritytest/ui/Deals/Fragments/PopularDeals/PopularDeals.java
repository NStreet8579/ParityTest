package com.nikhil.paritytest.ui.Deals.Fragments.PopularDeals;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nikhil.paritytest.Adapters.DealsRecycleAdapter;
import com.nikhil.paritytest.R;
import com.nikhil.paritytest.networks.Response.DealResponse;
import com.nikhil.paritytest.ui.Deals.Fragments.TopDeals.TopDealsViewModel;

import java.util.List;

public class PopularDeals extends Fragment {

    private PopularDealsViewModel mViewModel;

    public static PopularDeals newInstance() {
        return new PopularDeals();
    }

    RecyclerView rvPopularDeals;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(PopularDealsViewModel.class);
        mViewModel.init();
        mViewModel.getPopularDeals().observe(this, newsResponse -> {
            List<DealResponse.Datum> data = newsResponse.deals.data;
            setupRecyclerView(data);
        });

        View view = inflater.inflate(R.layout.popular_deals_fragment, container, false);

        rvPopularDeals= view.findViewById(R.id.recycler_popular_deals);

        return view;
    }


    private void setupRecyclerView(List<DealResponse.Datum> data) {

        DealsRecycleAdapter dealsRecycleAdapter = new DealsRecycleAdapter(getContext(), data);
        rvPopularDeals.setLayoutManager(new LinearLayoutManager(getContext()));
        rvPopularDeals.setAdapter(dealsRecycleAdapter);



    }
}
