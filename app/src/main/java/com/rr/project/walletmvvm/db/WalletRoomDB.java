package com.rr.project.walletmvvm.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.rr.project.walletmvvm.dao.Entry;
import com.rr.project.walletmvvm.dao.EntryDao;
import com.rr.project.walletmvvm.dao.Tab;
import com.rr.project.walletmvvm.dao.TabDao;

@Database(entities = {Tab.class, Entry.class}, version = 1)
public abstract class WalletRoomDB extends RoomDatabase {

    public abstract TabDao tabDao();

    public abstract EntryDao entryDao();

    public static volatile WalletRoomDB INSTANCE;

    public static WalletRoomDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WalletRoomDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,WalletRoomDB.class,"wallet_db").build();
                }
            }
        }
        return INSTANCE;
    }
}
