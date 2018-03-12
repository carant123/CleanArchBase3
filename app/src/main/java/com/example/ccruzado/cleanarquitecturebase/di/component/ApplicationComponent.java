package com.example.ccruzado.cleanarquitecturebase.di.component;

import com.example.ccruzado.cleanarquitecturebase.data.api.ApiService;
import com.example.ccruzado.cleanarquitecturebase.data.repository.MultipleResourceApiData;
import com.example.ccruzado.cleanarquitecturebase.data.repository.UsuarioApiData;
import com.example.ccruzado.cleanarquitecturebase.di.module.ApplicationModule;
import com.example.ccruzado.cleanarquitecturebase.di.module.NetModule;
import com.example.ccruzado.cleanarquitecturebase.presentation.activity.MultipleResourceListActivity;
import com.example.ccruzado.cleanarquitecturebase.presentation.activity.UsuarioListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ccruzado on 12/03/2018.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface ApplicationComponent {

    void inject(UsuarioListActivity activity);
    void inject(MultipleResourceListActivity activity);

    void inject(UsuarioApiData databaseapi);
    void inject(MultipleResourceApiData multipleResourceApiData);

    ApiService getApiService();

}