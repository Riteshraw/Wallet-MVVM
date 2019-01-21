package com.rr.project.walletmvvm.vm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.rr.project.walletmvvm.dao.Tab;
import com.rr.project.walletmvvm.repository.TabRepo;

import java.util.List;

public class TabViewModel extends AndroidViewModel {
    private TabRepo tabRepo;
    private LiveData<List<Tab>> listAllTabs;

    public TabViewModel(@NonNull Application application) {
        super(application);
        tabRepo = new TabRepo(application);
        listAllTabs = tabRepo.getListAllTabs();
    }

    public LiveData<List<Tab>> getAllTabs() {
        return listAllTabs;
    }

    public void insertTab(Tab tab) {
        tabRepo.insertTab(tab);
    }

}
