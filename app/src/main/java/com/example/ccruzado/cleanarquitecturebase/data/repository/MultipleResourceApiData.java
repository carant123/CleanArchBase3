package com.example.ccruzado.cleanarquitecturebase.data.repository;

import com.example.ccruzado.cleanarquitecturebase.StartApplication;
import com.example.ccruzado.cleanarquitecturebase.data.api.ApiService;
import com.example.ccruzado.cleanarquitecturebase.di.component.DaggerActivityComponent;
import com.example.ccruzado.cleanarquitecturebase.model.MultipleResource;
import com.example.ccruzado.cleanarquitecturebase.data.model.UsuarioEntity;
import com.example.ccruzado.cleanarquitecturebase.model.Usuario;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Carlos on 24/02/2018.
 */

@Singleton
public class MultipleResourceApiData implements Repository {

    @Inject
    ApiService apiservice;


    public MultipleResourceApiData() {
        DaggerActivityComponent.builder()
                .appComponent(StartApplication.getAppComponent())
                .build().inject(this);
    }

    @Override
    public Observable<List<Usuario>> userList() {
        return apiservice.ListaUsuario();
    }

    @Override
    public Observable<Usuario> user(int id) {
        return apiservice.UsuarioInfo(id);
    }

    @Override
    public Observable<MultipleResource> listMultiple() {
        return apiservice.listMultiple();
    }

}
