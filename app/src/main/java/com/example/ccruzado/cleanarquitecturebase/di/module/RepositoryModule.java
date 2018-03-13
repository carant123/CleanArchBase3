package com.example.ccruzado.cleanarquitecturebase.di.module;

import com.example.ccruzado.cleanarquitecturebase.data.repository.MultipleResourceApiData;
import com.example.ccruzado.cleanarquitecturebase.data.repository.Repository;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ccruzado on 13/03/2018.
 */

@Module
public class RepositoryModule {

    @Provides
    @Named("Repository_MultipleResourceApiData")
    Repository provideRepository() {
        return new MultipleResourceApiData();
    }

}
