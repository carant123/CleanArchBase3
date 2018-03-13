package com.example.ccruzado.cleanarquitecturebase.di.module;

import com.example.ccruzado.cleanarquitecturebase.data.api.ApiService;
import com.example.ccruzado.cleanarquitecturebase.data.api.SoapApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.SimpleXMLConverter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by ccruzado on 22/02/2018.
 */

@Module
public class NetModule {

//    @PerActivityScope
//    @Provides
//    CountryDataStoreFactory provideCountryDataStoreFactory() {
//        return new CountryDataStoreFactory();
//    }




    @Provides
    ApiService provideApiService() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                //.baseUrl("http://restcountries.eu/")
                .baseUrl("https://reqres.in")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(ApiService.class);
    }


    @Provides
    SoapApi provideSoapService() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        Strategy strategy = new AnnotationStrategy();

        Serializer serializer = new Persister(strategy);

/*        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                //.baseUrl("http://restcountries.eu/")
                .baseUrl("https://reqres.in")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                        SimpleXmlConverterFactory.createNonStrict(
                                new Persister(strategy // important part!
                                )
                        ))
                .build();*/


        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                //.baseUrl("http://restcountries.eu/")
                .baseUrl("https://reqres.in")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                .build();


        return retrofit.create(SoapApi.class);

    }




/*    @Provides
    public UsStatesApi providesApi(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Strategy strategy = new AnnotationStrategy();

        Serializer serializer = new Persister(strategy);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build();

        Retrofit retrofit =  new Retrofit.Builder()
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                .baseUrl("http://www.webservicex.net/")
                .client(okHttpClient)
                .build();

        return retrofit.create( UsStatesApi.class);

    }*/


}