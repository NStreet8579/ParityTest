package com.nikhil.paritytest.ui.Deals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.nikhil.paritytest.Adapters.DealsFragmentAdapter;
import com.nikhil.paritytest.R;
import com.nikhil.paritytest.ui.Deals.Fragments.FeaturedDeals.FeaturedDeals;
import com.nikhil.paritytest.ui.Deals.Fragments.PopularDeals.PopularDeals;
import com.nikhil.paritytest.ui.Deals.Fragments.TopDeals.TopDeals;

public class DealsActivity extends AppCompatActivity {


    ViewPager viewPager;
    TabLayout tabLayout;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals);

        viewPager = findViewById(R.id.deals_pager);
        tabLayout = findViewById(R.id.tab_deals);
        mToolbar = findViewById(R.id.toolbar_deals);

        mToolbar.setTitle("Deals");
        setSupportActionBar(mToolbar);

        DealsFragmentAdapter adapter = new DealsFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new TopDeals(), "Top");
        adapter.addFragment(new PopularDeals(), "Popular");
        adapter.addFragment(new FeaturedDeals(), "Feature");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
