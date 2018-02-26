package com.example.ccruzado.cleanarquitecturebase.di.module;

import android.app.Application;
import android.content.Context;

import com.example.ccruzado.cleanarquitecturebase.data.repository.MultipleResourceApiData;
import com.example.ccruzado.cleanarquitecturebase.data.repository.Repository;
import com.example.ccruzado.cleanarquitecturebase.data.repository.UsuarioApiData;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ccruzado on 22/02/2018.
 */

@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

/*    @Provides
    @Singleton
    public Repository provideRepository(MultipleResourceApiData multipleResourceApiData) {
        return multipleResourceApiData;
    }*/

/*    @Provides
    @Singleton
    public Repository provideRepository(){
        return new MultipleResourceApiData();
    }*/




/*    @Provides
    @Singleton
    Repository provideRepository2(UsuarioApiData usuarioApiData) {
        return usuarioApiData;
    }*/



    @Provides
    @Singleton
    Application getApplication() {
        return mApplication;
    }


    @Provides
    @Singleton
    Context getContext() {
        return mApplication;
    }


    @Provides
    @Named("executor_thread")
    Scheduler provideExecutorThread() {
        return Schedulers.io();
    }

    @Provides
    @Named("ui_thread") Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }



}
