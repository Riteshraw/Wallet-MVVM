package com.rr.project.walletmvvm.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit INSTANCE = null;
    public static final String BASE_URL = "http://uathealthapi.nubiz.co.in/api/"/*"https://reqres.in/api/"*/;

    public static Retrofit getApiClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        /*OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + "-8nXC5vLknhzS2XJ5G3dkGtH1-o1YQv3YpymWMSDv7FXiR9oHCiSqozuhn0rue4GGBgToskV58xzaQW7JUon_nnD9vYQTWDEMneKr72njCh3LJcKK2xSnRwMu_uLy0lq3XQjIU9Z86N3X89-bjosSUQ_xf863I8P3JL-zoj_S0y7y41d3i8H9tpr3h-2tEkkanNVUkRYZmuMFUhr8iXV62XwhIw")
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();*/

        if (INSTANCE == null) {
            INSTANCE = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return INSTANCE;
    }
}
