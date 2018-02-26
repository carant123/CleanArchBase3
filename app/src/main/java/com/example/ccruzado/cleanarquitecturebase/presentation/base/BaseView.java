package com.example.ccruzado.cleanarquitecturebase.presentation.base;

import com.example.ccruzado.cleanarquitecturebase.domain.model.Usuario;

import java.util.List;

/**
 * Created by ccruzado on 22/02/2018.
 */

public interface BaseView {

    void showLoading();

    void hideLoading();

    void onSuccess(List<Usuario> usuarios);

    void onError(String error);

}
