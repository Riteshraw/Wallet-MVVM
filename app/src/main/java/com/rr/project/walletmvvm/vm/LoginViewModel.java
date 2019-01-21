package com.rr.project.walletmvvm.vm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.rr.project.walletmvvm.WalletApplication;
import com.rr.project.walletmvvm.dao.User;
import com.rr.project.walletmvvm.repository.LoginRepo;

public class LoginViewModel extends AndroidViewModel {
    private final LoginRepo loginRepo;
    private final Application application;
    private LiveData<User> userLoginResponse;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginRepo = WalletApplication.getLoginRepo();
        this.application = application;
//        userLoginResponse = loginRepo.onLogin(new User("9716123123", "qwerty", "123456789", "123456789"));
    }

    public void loginUserService(User user) {
//        userLoginResponse = loginRepo.onLogin(user);
        userLoginResponse = loginRepo.onLogin(new User("9716123123", "qwerty", "123456789", "123456789"));
        Toast.makeText(application, "Result: "/*+ userLoginResponse.getValue().getStatusCode()*/, Toast.LENGTH_SHORT).show();
    }

    public LiveData<User> getUserLoginResponse() {
        if (userLoginResponse == null) {
            userLoginResponse = new MutableLiveData<User>();
        }
        return userLoginResponse;
    }
}
