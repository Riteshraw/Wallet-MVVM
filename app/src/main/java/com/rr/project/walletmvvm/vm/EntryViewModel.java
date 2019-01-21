package com.rr.project.walletmvvm.vm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.rr.project.walletmvvm.dao.Entry;
import com.rr.project.walletmvvm.repository.EntryRepo;

import java.util.List;

public class EntryViewModel extends AndroidViewModel {

    private final LiveData<List<Entry>> listAllEntries;
    private final EntryRepo entryRepo;

    public EntryViewModel(@NonNull Application application) {
        super(application);
        entryRepo = new EntryRepo(application);
        listAllEntries = entryRepo.getListEntries();
    }

    public LiveData<List<Entry>> getAllEntries() {
        return listAllEntries;
    }

    public void insertEntry(Entry entry) {
        entryRepo.insertEntry(entry);
    }
}
