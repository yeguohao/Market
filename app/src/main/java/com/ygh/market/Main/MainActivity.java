package com.ygh.market.Main;

import android.app.Fragment;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ygh.market.Main.fragment.Classification;
import com.ygh.market.Main.fragment.Popular;
import com.ygh.market.Main.fragment.Recommend;
import com.ygh.market.Main.fragment.Self;
import com.ygh.market.Main.fragment.Supervise;
import com.ygh.market.R;
import com.ygh.market.view.FixedTextTabLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_viewpager)
    ViewPager viewPager;

    @BindView(R.id.main_fixed_text)
    FixedTextTabLayout fixedTextTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fixedTextTabLayout.setupWithViewPager(viewPager);

        viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0: return Recommend.newInstance();
                    case 1: return Classification.newInstance();
                    case 2: return Popular.newInstance();
                    case 3: return Supervise.newInstance();
                    case 4: return Self.newInstance();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 5;
            }
        });
    }
}
