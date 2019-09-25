package com.nikhil.paritytest.ui.Deals.Fragments.FeaturedDeals;

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
import com.nikhil.paritytest.ui.Deals.Fragments.PopularDeals.PopularDealsViewModel;

import java.util.List;

public class FeaturedDeals extends Fragment {

    private FeaturedDealsViewModel mViewModel;

    public static FeaturedDeals newInstance() {
        return new FeaturedDeals();
    }

    RecyclerView rvFeatureDeals;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = ViewModelProviders.of(this).get(FeaturedDealsViewModel.class);
        mViewModel.init();
        mViewModel.getFeatureDeals().observe(this, newsResponse -> {
            List<DealResponse.Datum> data = newsResponse.deals.data;
            setupRecyclerView(data);
        });

        View view = inflater.inflate(R.layout.featured_deals_fragment, container, false);
        rvFeatureDeals = view.findViewById(R.id.recycler_featured_deals);
        return view;
    }

    private void setupRecyclerView(List<DealResponse.Datum> data) {

        DealsRecycleAdapter dealsRecycleAdapter = new DealsRecycleAdapter(getContext(), data);
        rvFeatureDeals.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFeatureDeals.setAdapter(dealsRecycleAdapter);



    }
}
