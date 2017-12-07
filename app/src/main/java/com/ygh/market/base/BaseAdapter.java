package com.ygh.market.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<VH extends BaseAdapter.BaseHolder<T>, T> extends RecyclerView.Adapter<VH> {

    private List<T> data = new ArrayList<>();

    protected abstract int layoutID();

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(layoutID(), parent, false);
        return onCreateViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        BaseHolder<T> bh = holder;
        bh.setPosition(position);
        bh.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    protected abstract VH onCreateViewHolder(View itemView);

    public void setData(List<T> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public static abstract class BaseHolder<T> extends RecyclerView.ViewHolder {

        protected T data;
        protected int position;

        public BaseHolder(View itemView) {
            super(itemView);
        }

        private void setData(T data) {
            this.data = data;
            updateView(data);
        }

        private void setPosition(int position) {
            this.position = position;
        }

        protected abstract void updateView(T data);
    }
}
