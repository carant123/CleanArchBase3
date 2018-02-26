package com.example.ccruzado.cleanarquitecturebase.data.model;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by ccruzado on 22/02/2018.
 */


public class UsuarioEntity implements Serializable {

    private String nombre;
    private String apellido;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
