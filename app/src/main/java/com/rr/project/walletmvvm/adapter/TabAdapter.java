package com.rr.project.walletmvvm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rr.project.walletmvvm.R;
import com.rr.project.walletmvvm.dao.Tab;

import java.util.List;

public class TabAdapter extends RecyclerView.Adapter<TabAdapter.TabViewHolder> {
    private final LayoutInflater mInflater;
    private List<Tab> tabs; // Cached copy of words

    public TabAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    class TabViewHolder extends RecyclerView.ViewHolder {
        private final TextView tabItemView;

        private TabViewHolder(View itemView) {
            super(itemView);
            tabItemView = itemView.findViewById(R.id.entry);
        }
    }


    @Override
    public TabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new TabViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TabViewHolder holder, int position) {
        if (tabs != null) {
            Tab current = tabs.get(position);
            holder.tabItemView.setText(current.getTabName());
        } else {
            // Covers the case of data not being ready yet.
            holder.tabItemView.setText("No tab");
        }
    }

    public void setTabs(List<Tab> tabs) {
        this.tabs = tabs;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (tabs != null)
            return tabs.size();
        else return 0;
    }
}
