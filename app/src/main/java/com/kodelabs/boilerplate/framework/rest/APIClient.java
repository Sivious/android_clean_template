package com.kodelabs.boilerplate.framework.rest;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kodelabs.boilerplate.domain.model.RandomUserResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jsivianes on 5/2/18.
 */

public class APIClient {

    private static Retrofit retrofit = null;

    static Retrofit getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/api")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

//    public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {
//
//        final UserAPI randomUserAPI = UserAPI.Factory.create();
//        randomUserAPI.getRandomUsers(20)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<RandomUserResponse>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("People", e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(RandomUserResponse response) {
////                        mPeopleFragmentBinding.rvPeopleList.setLayoutManager(setLayoutManager());
////                        mPeopleFragmentBinding.rvPeopleList.setHasFixedSize(true);
////                        mPeopleListAdapter = new PeopleListAdapter(getContext(), response.getResults());
////                        mPeopleFragmentBinding.rvPeopleList.setAdapter(mPeopleListAdapter);
//                        Log.e("People", response.toString());
//                    }
//                });
//    }

    public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .setLenient()
                .create();

        final Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        T service = restAdapter.create(clazz);

        return service;
    }


}