package com.rr.project.walletmvvm.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.rr.project.walletmvvm.dao.Tab;
import com.rr.project.walletmvvm.dao.TabDao;
import com.rr.project.walletmvvm.db.WalletRoomDB;

import java.util.List;

public class TabRepo {
    public TabDao tabDao;
    public LiveData<List<Tab>> listAllTabs;

    public TabRepo(Application application) {
        WalletRoomDB db = WalletRoomDB.getDatabase(application);
        this.tabDao = db.tabDao();
        this.listAllTabs = tabDao.getAllTabs();
    }

    public LiveData<List<Tab>> getListAllTabs() {
        return listAllTabs;
    }

    public void insertTab(Tab tab){
        new insertAynsTask(tabDao).execute(tab);
    }

    private static class insertAynsTask extends AsyncTask<Tab,Void,Void>{
        private TabDao asyncTabDao;

        public insertAynsTask(TabDao tabDao) {
            asyncTabDao = tabDao;
        }

        @Override
        protected Void doInBackground(Tab... tabs) {
            asyncTabDao.insertTab(tabs[0]);
            return null;
        }
    }

}
