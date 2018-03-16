package com.example.ccruzado.cleanarquitecturebase.data.api;

import com.example.ccruzado.cleanarquitecturebase.data.api.RequestResponse.Post;
import com.example.ccruzado.cleanarquitecturebase.data.api.RequestResponse.RequestEnvelope;
import com.example.ccruzado.cleanarquitecturebase.model.MultipleResource;

import com.example.ccruzado.cleanarquitecturebase.data.api.RequestResponse.model.request.*;
import com.example.ccruzado.cleanarquitecturebase.data.api.RequestResponse.model.response.*;
import com.example.ccruzado.cleanarquitecturebase.model.NewDataSet;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by ccruzado on 13/03/2018.
 */

public interface SoapApi {
    @Headers({
            "Content-Type: application/soap+xml",
            "Accept-Charset: utf-8"
    })
    @POST("/Service1.asmx")
    Observable<MultipleResource> uploadRequest(@Body RequestEnvelope body);

    @Headers({
            "Content-Type: text/xml",
            "Accept-Charset: utf-8"
    })
    @POST("/uszip.asmx")
    Observable<UsStatesResponseEnvelope> requestStateInfo(@Body UsStatesRequestEnvelope body);

    @GET("/api/unknown")
    Observable<MultipleResource> listMultiple();


    @POST("/posts")
    Observable<Post> postPost(@Body Post post);


    @GET("/GetCountries")
    Observable<NewDataSet> GetCountries();




}