package com.rr.project.walletmvvm.retrofit;

import com.rr.project.walletmvvm.utils.Constants;
import com.rr.project.walletmvvm.dao.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {

    @POST(Constants.LOGIN_WITH_PWD)
    Call<User> loginWithPwd(@Body User user);
}
