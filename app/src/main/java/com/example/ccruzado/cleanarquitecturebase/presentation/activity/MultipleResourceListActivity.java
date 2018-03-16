package com.example.ccruzado.cleanarquitecturebase.presentation.activity;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ccruzado.cleanarquitecturebase.R;
import com.example.ccruzado.cleanarquitecturebase.StartApplication;
import com.example.ccruzado.cleanarquitecturebase.model.MultipleResource;
import com.example.ccruzado.cleanarquitecturebase.presentation.AdapterRetrofit;
import com.example.ccruzado.cleanarquitecturebase.presentation.base.BaseActivity;
import com.example.ccruzado.cleanarquitecturebase.presentation.presenter.ListaMultipleResourcePresenter;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Carlos on 24/02/2018.
 */

public class MultipleResourceListActivity extends BaseActivity implements ListaMultipleResourcePresenter.View {

    @Inject ListaMultipleResourcePresenter presenter;
    @BindView(R.id.recycleViewList) RecyclerView recycleViewList;
    private Context mContext;
    private AdapterRetrofit adapter;
    private static final String TAG = MultipleResourceListActivity.class.getSimpleName();

    @Override
    protected void init() {

        ((StartApplication) getApplication()).getComponent().inject(this);

        this.mContext = getApplicationContext();
        presenter.setView(this);
        disableTitleFromToolbar();
        //initializeRecyclerView();
        //initializeAdapter();
        presenter.initialize();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }



    @Override
    protected int getLayoutId() {
        return R.layout.recycleview_layout;
    }

    private void disableTitleFromToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }


    @Override
    public void showLoading() {
        Log.i(TAG, "showing loader");
        //recycleViewList.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        Log.i(TAG, "hiding loader");
        //recycleViewList.setVisibility(View.VISIBLE);
        if(recycleViewList == null){
            Log.i(TAG, "recycleViewList null1 ");
        }
    }

/*    private void initializeAdapter() {
        adapter = new AdapterRetrofit(data,this.mContext);
    }*/

    private void initializeRecyclerView() {
        Log.i(TAG, "initializeRecyclerView");
        recycleViewList.setLayoutManager(new LinearLayoutManager(this));
        recycleViewList.addItemDecoration(new android.support.v7.widget.DividerItemDecoration(this,
                android.support.v7.widget.DividerItemDecoration.VERTICAL));
        recycleViewList.setHasFixedSize(true);
        recycleViewList.setAdapter(adapter);
        Log.i(TAG, "initializeRecyclerView");
    }



    @Override
    public void MuestraListaMultipleResource(MultipleResource userList) {
        Log.i(TAG, "userListMuestraListaMultipleResource: " + userList.page);
        CargarRecycleView(userList);
        //adapter = new AdapterRetrofit(userList,this.mContext);
        //initializeRecyclerView();

    }

    public void CargarRecycleView(MultipleResource userList){

        if(recycleViewList == null){
            Log.i(TAG, "recycleViewList null2 ");
        }

        adapter = new AdapterRetrofit(userList,this.mContext);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this.mContext);
        recycleViewList.setLayoutManager(linearLayout);
        recycleViewList.setAdapter(this.adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycleViewList.getContext(),
                linearLayout.getOrientation());
        recycleViewList.addItemDecoration(dividerItemDecoration);


    }

}
