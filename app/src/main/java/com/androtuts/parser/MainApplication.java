package com.androtuts.parser;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainApplication extends Application {

    private static MainApplication application;
    private Retrofit retrofit = new Retrofit.Builder().baseUrl(APIController.Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }

    public APIController getApiServices(){
        return retrofit.create(APIController.class);
    }

    public static MainApplication getInstance(){
        return application;
    }
}
