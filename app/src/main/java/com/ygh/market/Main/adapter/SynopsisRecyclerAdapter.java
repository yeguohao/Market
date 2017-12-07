package com.ygh.market.Main.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ygh.market.Main.javabean.ApplicationSynopsis;
import com.ygh.market.R;
import com.ygh.market.base.BaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SynopsisRecyclerAdapter extends BaseAdapter<SynopsisRecyclerAdapter.ViewHolder, ApplicationSynopsis> {

    @Override
    protected int layoutID() {
        return R.layout.item_recommend_application_synopsis;
    }

    protected SynopsisRecyclerAdapter.ViewHolder onCreateViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    static class ViewHolder extends BaseAdapter.BaseHolder<ApplicationSynopsis> {

        @BindView(R.id.recommend_item_synopsis_icon)
        ImageView icon;

        @BindView(R.id.recommend_item_apk_title)
        TextView apkTitle;

        @BindView(R.id.recommend_item_apk_size)
        TextView apkSize;

        private ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(v -> {

            });
        }

        private void adjustMargin(boolean end) {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) itemView.getLayoutParams();

            if (end) {
                params.setMarginEnd(params.getMarginStart());
            } else {
                params.setMarginEnd(0);
            }
        }

        @Override
        protected void updateView(ApplicationSynopsis data) {
            adjustMargin(position == 1);

            apkTitle.setText(data.getTitle());
            apkSize.setText(data.getApkSize());

            Glide.with(itemView).load(data.getIconUrl()).into(icon);
        }
    }
}
