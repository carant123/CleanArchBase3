package com.example.ccruzado.cleanarquitecturebase.domain.usecase.base;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by ccruzado on 22/02/2018.
 */

public abstract class UseCaseObserver<T> extends DisposableObserver<T> {

    @Override public void onComplete() {
    }

    @Override public void onError(Throwable e) {
    }

    @Override public void onNext(T t) {
    }
}