package com.example.ccruzado.cleanarquitecturebase.data.api;

import com.example.ccruzado.cleanarquitecturebase.model.MultipleResource;
import com.example.ccruzado.cleanarquitecturebase.model.Usuario;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ccruzado on 22/02/2018.
 */

public interface ApiService {

    @GET("rest/v2/region/Americas/{id}")
    Observable<Usuario> UsuarioInfo(@Path("id") int id);

    @GET("rest/v2/region/Americas")
    Observable<List<Usuario>> ListaUsuario();

    @GET("/api/unknown")
    Observable<MultipleResource> listMultiple();

}
