package com.rr.project.walletmvvm.dao;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tab_table")
public class Tab {

    @PrimaryKey(autoGenerate = true)
    int id;
    String tabName;
    long date;

    public Tab() {
    }

    public Tab(int id, String tabName, long date) {
        this.id = id;
        this.tabName = tabName;
        this.date = date;
    }

    public Tab(String tabName, long date) {
        this.tabName = tabName;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
