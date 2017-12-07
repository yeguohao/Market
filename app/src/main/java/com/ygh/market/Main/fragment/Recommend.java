package com.ygh.market.Main.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ygh.market.Main.adapter.RecommendRecyclerAdapter;
import com.ygh.market.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Recommend extends Fragment {

    @BindView(R.id.recommend_recycler)
    RecyclerView recyclerView;

    public static Recommend newInstance() {
        
        Bundle args = new Bundle();
        
        Recommend fragment = new Recommend();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(root);

        recyclerView.setAdapter(new RecommendRecyclerAdapter());
        return root;
    }

}
