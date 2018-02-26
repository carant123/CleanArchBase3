package com.example.ccruzado.cleanarquitecturebase.di.component;

import com.example.ccruzado.cleanarquitecturebase.data.repository.MultipleResourceApiData;
import com.example.ccruzado.cleanarquitecturebase.data.repository.UsuarioApiData;
import com.example.ccruzado.cleanarquitecturebase.data.api.ApiService;
import com.example.ccruzado.cleanarquitecturebase.di.PerActivityScope;
import com.example.ccruzado.cleanarquitecturebase.di.module.AppModule;
import com.example.ccruzado.cleanarquitecturebase.di.module.NetModule;
import com.example.ccruzado.cleanarquitecturebase.domain.usecase.UC_ListaMultipleResource;
import com.example.ccruzado.cleanarquitecturebase.domain.usecase.UC_ListarUsuarios;
import com.example.ccruzado.cleanarquitecturebase.presentation.activity.MultipleResourceListActivity;
import com.example.ccruzado.cleanarquitecturebase.presentation.activity.UsuarioListActivity;

import dagger.Component;
import io.reactivex.Scheduler;

/**
 * Created by ccruzado on 22/02/2018.
 */

@PerActivityScope
@Component(dependencies = AppComponent.class, modules = { NetModule.class })
public interface ActivityComponent {

    void inject(UsuarioListActivity activity);
    void inject(MultipleResourceListActivity activity);

    void inject(UsuarioApiData databaseapi);
    void inject(MultipleResourceApiData multipleResourceApiData);



    // todo lo que se expone a los modulos
    // tiene como dependencia el aplication componente

    ApiService getApiService();
/*    Scheduler provideExecutorThread();
    Scheduler provideUiThread();*/


}