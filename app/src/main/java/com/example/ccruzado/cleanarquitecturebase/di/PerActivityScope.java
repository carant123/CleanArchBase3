package com.example.ccruzado.cleanarquitecturebase.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by ccruzado on 22/02/2018.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivityScope {
}
