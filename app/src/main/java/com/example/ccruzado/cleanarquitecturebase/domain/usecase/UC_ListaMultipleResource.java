package com.example.ccruzado.cleanarquitecturebase.domain.usecase;

import com.example.ccruzado.cleanarquitecturebase.data.repository.MultipleResourceApiData;
import com.example.ccruzado.cleanarquitecturebase.data.repository.Repository;
import com.example.ccruzado.cleanarquitecturebase.domain.usecase.base.UseCase;
import com.example.ccruzado.cleanarquitecturebase.model.MultipleResource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Carlos on 24/02/2018.
 */

public class UC_ListaMultipleResource extends UseCase<MultipleResource> {

    private Repository repository;

/*    @Inject public UC_ListaMultipleResource(@Named("executor_thread") Scheduler executorThread,
                                    @Named("ui_thread") Scheduler uiThread) {
        super(executorThread, uiThread);
        this.repository = new MultipleResourceApiData();
    }*/

    @Inject
    public UC_ListaMultipleResource() {
        super(Schedulers.io(), AndroidSchedulers.mainThread());
        this.repository = new MultipleResourceApiData();
    }



    @Override
    protected Observable<MultipleResource> createObservableUseCase() {
        return this.repository.listMultiple();
    }


}
