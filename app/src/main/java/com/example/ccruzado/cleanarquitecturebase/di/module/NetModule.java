package com.example.ccruzado.cleanarquitecturebase.di.module;

import com.example.ccruzado.cleanarquitecturebase.data.api.ApiService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ccruzado on 22/02/2018.
 */

@Module
public class NetModule {

//    @PerActivityScope
//    @Provides
//    CountryDataStoreFactory provideCountryDataStoreFactory() {
//        return new CountryDataStoreFactory();
//    }




    @Provides
    ApiService provideApiService() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                //.baseUrl("http://restcountries.eu/")
                .baseUrl("https://reqres.in")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(ApiService.class);
    }


/*    @Named("executor_thread")
    @Provides
    Scheduler provideExecutorThread() {
        return Schedulers.io();
    }


    @Named("ui_thread")
    @Provides
    Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }*/

}