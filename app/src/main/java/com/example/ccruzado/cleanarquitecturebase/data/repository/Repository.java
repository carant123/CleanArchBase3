package com.example.ccruzado.cleanarquitecturebase.data.repository;

import com.example.ccruzado.cleanarquitecturebase.model.MultipleResource;
import com.example.ccruzado.cleanarquitecturebase.model.Usuario;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ccruzado on 22/02/2018.
 */

public interface Repository {

    Observable<List<Usuario>> userList();

    Observable<Usuario> user(final int id);

    Observable<MultipleResource> listMultiple();

}
