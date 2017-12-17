package com.ygh.market.Main.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ygh.market.R;

public class Self extends Fragment {

    public static Self newInstance() {
        
        Bundle args = new Bundle();
        
        Self fragment = new Self();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_self, container, false);

        return root;
    }
}
