package com.rr.project.walletmvvm.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rr.project.walletmvvm.R;
import com.rr.project.walletmvvm.dao.Entry;
import com.rr.project.walletmvvm.dao.Tab;
import com.rr.project.walletmvvm.databinding.RecyclerviewItemBinding;

import java.util.List;

public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.TabViewHolder> {
    private final LayoutInflater mInflater;
    private List<Entry> entries; // Cached copy of words

    public EntryAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    class TabViewHolder extends RecyclerView.ViewHolder {
//        private final TextView tabItemView;
        private RecyclerviewItemBinding binding;

        private TabViewHolder(View itemView) {
            super(itemView);
//            tabItemView = itemView.findViewById(R.id.textView);
        }

        private TabViewHolder(RecyclerviewItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }

    @Override
    public TabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
//        return new TabViewHolder(itemView);
        RecyclerviewItemBinding itemBinding = DataBindingUtil.inflate(mInflater, R.layout.recyclerview_item, parent, false);
        return new TabViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(TabViewHolder holder, int position) {
        if (entries != null) {
            Entry current = entries.get(position);
//            holder.tabItemView.setText(current.getNote());
            holder.binding.entry.setText(current.getNote());
        } else {
            // Covers the case of data not being ready yet.
//            holder.tabItemView.setText("No Entry");
        }
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (entries != null)
            return entries.size();
        else return 0;
    }
}
