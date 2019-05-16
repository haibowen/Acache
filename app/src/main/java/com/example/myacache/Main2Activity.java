package com.example.myacache;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Main2Activity extends AppCompatActivity {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ListView mListview;
    private String[] data = {"1", "2", "3", "4", "5", "6", "7", "8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                            mListview.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(Main2Activity.this, R.anim.layout_animation_fall_down));
                            mListview.scheduleLayoutAnimation();
                            mSwipeRefreshLayout.setRefreshing(false);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }
                }).start();




            }

        });
        mListview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data));


    }

    private void initView() {
        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        mListview = findViewById(R.id.list_view);
    }
}
