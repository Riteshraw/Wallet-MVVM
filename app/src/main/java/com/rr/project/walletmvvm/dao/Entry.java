package com.rr.project.walletmvvm.dao;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "entry_table")
public class Entry {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String note;
    private String amount;
    private boolean isDebit;
    private String balance;
    private String type;
    private long date;

    public Entry(/*int id,*/ String note, String amount, boolean isDebit, String type, long date) {
//        this.id = id;
        this.note = note;
        this.amount = amount;
        this.isDebit = isDebit;
        this.type = type;
        this.date = date;
    }

    public Entry() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public boolean isDebit() {
        return isDebit;
    }

    public void setDebit(boolean debit) {
        isDebit = debit;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
