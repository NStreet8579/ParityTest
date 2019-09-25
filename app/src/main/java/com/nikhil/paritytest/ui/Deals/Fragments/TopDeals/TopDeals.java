package com.nikhil.paritytest.ui.Deals.Fragments.TopDeals;

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

import java.util.List;

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
        mViewModel.init();
        mViewModel.getTopDeals().observe(this, newsResponse -> {
            List<DealResponse.Datum> data = newsResponse.deals.data;
            setupRecyclerView(data);
        });

        View view = inflater.inflate(R.layout.top_deals_fragment, container, false);

        rvTopDeals = view.findViewById(R.id.recycler_top_deals);

        return view;
    }

    private void setupRecyclerView(List<DealResponse.Datum> data) {

            DealsRecycleAdapter dealsRecycleAdapter = new DealsRecycleAdapter(getContext(), data);
            rvTopDeals.setLayoutManager(new LinearLayoutManager(getContext()));
            rvTopDeals.setAdapter(dealsRecycleAdapter);



    }
}
