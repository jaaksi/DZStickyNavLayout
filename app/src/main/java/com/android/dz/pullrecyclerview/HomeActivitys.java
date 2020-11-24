package com.android.dz.pullrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.android.dz.pullrecyclerview.adapter.HomeAdapters;
import com.android.dz.pullrecyclerview.view.DZStickyNavLayouts;


public class HomeActivitys extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);

        DZStickyNavLayouts layout = (DZStickyNavLayouts) findViewById(R.id.head_home_layout);
        layout.setOnStartActivity(new DZStickyNavLayouts.OnStartActivityListener() {
            @Override
            public void onStart() {
                Intent intent = new Intent(HomeActivitys.this, MainActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView mHeadRecyclerView = (RecyclerView) findViewById(R.id.head_home_recyclerview);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        mHeadRecyclerView.setLayoutManager(layoutManager2);
        new PagerSnapHelper().attachToRecyclerView(mHeadRecyclerView);
        HomeAdapters mHomeAdapter = new HomeAdapters();
        mHeadRecyclerView.setAdapter(mHomeAdapter);
    }
}
