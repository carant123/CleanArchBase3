package com.example.ccruzado.cleanarquitecturebase;

import android.app.Application;

import com.example.ccruzado.cleanarquitecturebase.di.component.ApplicationComponent;
import com.example.ccruzado.cleanarquitecturebase.di.component.DaggerApplicationComponent;
import com.example.ccruzado.cleanarquitecturebase.di.module.ApplicationModule;
import com.example.ccruzado.cleanarquitecturebase.di.module.NetModule;

/**
 * Created by ccruzado on 22/02/2018.
 */

public class StartApplication extends Application {

    private static StartApplication sInstance;
    private static ApplicationComponent appComponent;
    //private AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        //initilizeRoom();
        initializeInjector();
    }

//    private void initilizeRoom(){
//        if(db == null) {
//            db = Room.databaseBuilder(getApplicationContext(),
//                    AppDatabase.class, "databaseRoom")
//                    .build();
//        }
//    }

/*    public AppDatabase Database(){
        return db;
    }*/

    public static synchronized StartApplication getInstance() {
        return sInstance;
    }


    private void initializeInjector() {
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule())
                .build();
        //appComponent.inject(this);

    }

    public static ApplicationComponent getComponent(){
        return appComponent;
    }




}
