package com.example.ccruzado.cleanarquitecturebase;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.ccruzado.cleanarquitecturebase.di.component.AppComponent;
import com.example.ccruzado.cleanarquitecturebase.di.component.DaggerAppComponent;
import com.example.ccruzado.cleanarquitecturebase.di.module.AppModule;

/**
 * Created by ccruzado on 22/02/2018.
 */

public class StartApplication extends Application {

    private static StartApplication sInstance;
    private static AppComponent appComponent;
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
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        //appComponent.inject(this);

    }

    public static AppComponent getAppComponent(){
        return appComponent;
    }




}
