package com.example.ccruzado.cleanarquitecturebase.presentation.presenter;

import android.util.Log;

import com.example.ccruzado.cleanarquitecturebase.domain.usecase.UC_ListaMultipleResource;
import com.example.ccruzado.cleanarquitecturebase.domain.usecase.UC_ListarUsuarios;
import com.example.ccruzado.cleanarquitecturebase.domain.usecase.base.UseCaseObserver;
import com.example.ccruzado.cleanarquitecturebase.model.MultipleResource;
import com.example.ccruzado.cleanarquitecturebase.model.Usuario;
import com.example.ccruzado.cleanarquitecturebase.presentation.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Created by Carlos on 24/02/2018.
 */

public class ListaMultipleResourcePresenter extends BasePresenter<ListaMultipleResourcePresenter.View> {

    private UC_ListaMultipleResource uc_listaMultipleResource = new UC_ListaMultipleResource();

/*    @Inject
    public ListaMultipleResourcePresenter(@NonNull UC_ListaMultipleResource uc_listaMultipleResource) {
        this.uc_listaMultipleResource = uc_listaMultipleResource;
    }*/


    @Override
    public void initialize() {
        super.initialize();
        getView().showLoading();
        uc_listaMultipleResource.execute(new ListaMultipleResourcePresenter.ListaMultipleResourceObserver());
    }

    public void destroy() {
        this.uc_listaMultipleResource.dispose();
        setView(null);
    }

    private final class ListaMultipleResourceObserver extends UseCaseObserver<MultipleResource> {

        @Override public void onComplete() {
            getView().hideLoading();
        }

        @Override public void onError(Throwable e) {
            getView().hideLoading();
            e.printStackTrace();
        }

        @Override public void onNext(MultipleResource teamList) {
            Log.d("MultipleResource","MultipleResource: " + teamList.page);
            getView().MuestraListaMultipleResource(teamList);
        }
    }




    public interface View extends BasePresenter.View {
        void MuestraListaMultipleResource(MultipleResource userList);
    }


}
