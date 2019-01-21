package com.rr.project.walletmvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rr.project.walletmvvm.dao.EntryDao;
import com.rr.project.walletmvvm.dao.User;
import com.rr.project.walletmvvm.vm.LoginViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.edt_login)
    EditText edt_login;
    @BindView(R.id.edt_pass)
    EditText edt_pass;

    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        loginViewModel.getUserLoginResponse().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null)
                    Toast.makeText(LoginActivity.this, "Status : " + user.getStatusCode(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onSubmitClick(View view) {
        loginViewModel.loginUserService(new User(edt_login.getText().toString(), edt_pass.getText().toString(), "123456789", "123456789"));
        Toast.makeText(LoginActivity.this, "OnClick\nNumber: " + edt_login.getText() + "\nPassword: " + edt_pass.getText(), Toast.LENGTH_SHORT).show();
    }

    public class MyHolder {

    }
}
