package com.ygh.market.Main.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ygh.market.Main.javabean.ApplicationSeries;
import com.ygh.market.Main.javabean.ApplicationSynopsis;
import com.ygh.market.Main.javabean.ApplicationTopic;
import com.ygh.market.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class RecommendRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TOPIC = 0;
    private static final int SERIES = 1;

    private List<Object> data = new ArrayList<>();

    public void setData(List<?> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        if (viewType == TOPIC) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recommend_application_topic, parent, false);
            holder = new ApplicationList(itemView);
        } else {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recommend_application_series, parent, false);
            holder = new ApplicationImage(itemView);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == TOPIC) {
            ApplicationList list = (ApplicationList) holder;
            list.setData((ApplicationTopic) data.get(position));
        } else {
            ApplicationImage list = (ApplicationImage) holder;
            list.setData((ApplicationSeries) data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object obj = data.get(position);
        if (obj instanceof ApplicationTopic) {
            return TOPIC;
        }
        return SERIES;
    }

    static class ApplicationList extends RecyclerView.ViewHolder {

        @BindView(R.id.recommend_item_topic)
        TextView topic;

        @BindView(R.id.recommend_item_recycler)
        RecyclerView recyclerView;

        private ApplicationTopic data;
        private SynopsisRecyclerAdapter adapter;

        private ApplicationList(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            adapter = new SynopsisRecyclerAdapter();
            recyclerView.setLayoutManager(
                    new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setAdapter(adapter);
        }

        @OnClick(R.id.recommend_item_more)
        void more() {

        }

        @OnItemClick(R.id.recommend_item_recycler)
        void applicationDetail() {

        }

        private void setData(ApplicationTopic data) {
            this.data = data;
            topic.setText(data.getTopicTitle());
            adapter.setData(data.getApplications());
        }
    }

    static class ApplicationImage extends RecyclerView.ViewHolder {

        @BindView(R.id.recommend_item_series_1)
        ImageView series_1;

        @BindView(R.id.recommend_item_series_2)
        ImageView series_2;

        private ApplicationImage(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick({R.id.recommend_item_series_1, R.id.recommend_item_series_2})
        void series(View view) {
            if (view == series_1) {

            } else {

            }
        }

        private void setData(ApplicationSeries series) {
            Glide.with(itemView).load(series.getThumbnailUrl_1()).into(series_1);
            Glide.with(itemView).load(series.getThumbnailUrl_2()).into(series_2);
        }
    }

}
