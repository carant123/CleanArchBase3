package com.example.ccruzado.cleanarquitecturebase.presentation.presenter;

import com.example.ccruzado.cleanarquitecturebase.model.Usuario;
import com.example.ccruzado.cleanarquitecturebase.domain.usecase.UC_ListarUsuarios;
import com.example.ccruzado.cleanarquitecturebase.domain.usecase.base.UseCaseObserver;
import com.example.ccruzado.cleanarquitecturebase.presentation.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Created by ccruzado on 22/02/2018.
 */

public class UsuarioListPresenter extends BasePresenter<UsuarioListPresenter.View> {

    private UC_ListarUsuarios uc_listarUsuarios = new UC_ListarUsuarios();

/*    @Inject
    public UsuarioListPresenter(@NonNull UC_ListarUsuarios uc_listarUsuarios) {
        this.uc_listarUsuarios = uc_listarUsuarios;
    }*/

    @Override
    public void initialize() {
        super.initialize();
        getView().showLoading();
        uc_listarUsuarios.execute(new UsuarioListObserver());
    }

    public void destroy() {
        this.uc_listarUsuarios.dispose();
        setView(null);
    }

    private final class UsuarioListObserver extends UseCaseObserver<List<Usuario>> {

        @Override public void onComplete() {
            getView().hideLoading();
        }

        @Override public void onError(Throwable e) {
            getView().hideLoading();
            e.printStackTrace();
        }

        @Override public void onNext(List<Usuario> teamList) {
/*            List<TeamViewModel> teamViewModels = mapper.reverseMap(teamList);
            getView().showEuroTeams(teamViewModels);*/
        }
    }




    public interface View extends BasePresenter.View {
        void MuestraListaUsuarios(List<Usuario> userList);
        void SeleccionUsuario(Usuario user);
    }


}
