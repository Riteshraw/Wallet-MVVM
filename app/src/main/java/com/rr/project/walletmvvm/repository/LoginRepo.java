package com.rr.project.walletmvvm.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.rr.project.walletmvvm.WalletApplication;
import com.rr.project.walletmvvm.dao.User;
import com.rr.project.walletmvvm.retrofit.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginRepo {
    private static LoginRepo sInstance;
    private Retrofit retrofit;

    private LoginRepo() {
        retrofit = WalletApplication.getInstance().getApiClient();
    }

    public static LoginRepo getInstance() {
        if (sInstance == null) {
            synchronized (LoginRepo.class) {
                if (sInstance == null) {
                    sInstance = new LoginRepo();
                }
            }
        }
        return sInstance;
    }

    public MutableLiveData<User> onLogin(final User user) {
        final MutableLiveData<User> userLoginResult = null;

        retrofit.create(APIInterface.class).loginWithPwd(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.v("Response", "Response code: " + response.code()+", status: "+response.body().getStatusCode());
                userLoginResult.postValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
            }
        });
        return userLoginResult;
    }
}
