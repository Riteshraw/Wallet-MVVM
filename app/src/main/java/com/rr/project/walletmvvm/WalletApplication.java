package com.rr.project.walletmvvm;

import android.app.Application;

import com.rr.project.walletmvvm.repository.LoginRepo;
import com.rr.project.walletmvvm.retrofit.ApiClient;

import retrofit2.Retrofit;

public class WalletApplication extends Application {
    private static WalletApplication appInstance;

     public static WalletApplication getInstance(){
         if(appInstance == null)
             appInstance = new WalletApplication();

         return appInstance;
     }

     private WalletApplication(){
         appInstance = this;
     }

     public Retrofit getApiClient(){
         return ApiClient.getApiClient();
     }

    public static LoginRepo getLoginRepo() {
        return LoginRepo.getInstance();
    }
}
