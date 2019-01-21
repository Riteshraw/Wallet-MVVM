package com.rr.project.walletmvvm.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.rr.project.walletmvvm.dao.Entry;
import com.rr.project.walletmvvm.dao.EntryDao;
import com.rr.project.walletmvvm.db.WalletRoomDB;

import java.util.List;

public class EntryRepo {
    private EntryDao entryDao;
    private LiveData<List<Entry>> listEntries;

    public EntryRepo(Application application) {
        WalletRoomDB db = WalletRoomDB.getDatabase(application);
        entryDao = db.entryDao();
        listEntries = entryDao.getAllEntries();
    }

    public LiveData<List<Entry>> getListEntries() {
        return listEntries;
    }

    public void insertEntry(Entry entry) {
        new insertAynscTask().execute(entry);
    }

    private class insertAynscTask extends AsyncTask<Entry, Void, Long> {

        @Override
        protected Long doInBackground(Entry... entries) {
            return entryDao.insert(entries[0]);
        }
    }
}
