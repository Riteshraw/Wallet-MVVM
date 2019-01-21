package com.rr.project.walletmvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rr.project.walletmvvm.adapter.EntryAdapter;
import com.rr.project.walletmvvm.adapter.TabAdapter;
import com.rr.project.walletmvvm.dao.Entry;
import com.rr.project.walletmvvm.dao.Tab;
import com.rr.project.walletmvvm.fragments.AddNewTabDialogFragment;
import com.rr.project.walletmvvm.vm.EntryViewModel;
import com.rr.project.walletmvvm.vm.TabViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private TabViewModel tabViewModel;
    private EntryViewModel entryViewModel;
    private TabAdapter tabAdapter;
    private EntryAdapter entryAdapter;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        tabViewModel = ViewModelProviders.of(this).get(TabViewModel.class);
        entryViewModel = ViewModelProviders.of(this).get(EntryViewModel.class);

        /*tabViewModel.getAllTabs().observe(this, new Observer<List<Tab>>() {
            @Override
            public void onChanged(@Nullable List<Tab> tabs) {
                tabAdapter.setTabs(tabs);
            }
        });*/

        entryViewModel.getAllEntries().observe(this, new Observer<List<Entry>>() {
            @Override
            public void onChanged(@Nullable List<Entry> entries) {
                 entryAdapter.setEntries(entries);
            }
        });

//        tabAdapter = new TabAdapter(this);
//        recyclerview.setAdapter(tabAdapter);

        entryAdapter = new EntryAdapter(this);
        recyclerview.setAdapter(entryAdapter);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    /*@OnClick(R.id.img_toolbar_add_tab)
    void addNewTab(View view) {
        if (view.getId() == R.id.img_toolbar_add_tab) {
            AddNewTabDialogFragment newFragment = new AddNewTabDialogFragment();
            newFragment.show(getSupportFragmentManager(), "TAB");
        }
    }*/

    @OnClick(R.id.fab)
    void addNewTab(View view) {
        if (view.getId() == R.id.fab) {
//            tabViewModel.insertTab(new Tab("Tab 1",1540314816));
            entryViewModel.insertEntry(new Entry("Test note 1","10000",false,"ICICI",1540314816));
        }
    }
}
