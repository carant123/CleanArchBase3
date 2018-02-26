package com.example.ccruzado.cleanarquitecturebase.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.ccruzado.cleanarquitecturebase.R;
import com.example.ccruzado.cleanarquitecturebase.StartApplication;
import com.example.ccruzado.cleanarquitecturebase.di.component.ActivityComponent;
import com.example.ccruzado.cleanarquitecturebase.di.component.DaggerActivityComponent;

import butterknife.ButterKnife;

/**
 * Created by ccruzado on 22/02/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setupToolbar();
        ButterKnife.bind(this);
        initDagger();
        init();

    }

    public void initDagger() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent(((StartApplication) getApplication()).getAppComponent())
                .build();

    }

    public void setupToolbar() {
/*        getActionBar().hide();
        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }*/
    }

    public ActivityComponent getComponent() {
        return activityComponent;
    }

    @Nullable public Toolbar getToolbar() {
        return mToolbar;
    }

    protected abstract int getLayoutId();

    protected abstract void init();


}
