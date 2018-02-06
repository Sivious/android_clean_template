package com.kodelabs.boilerplate.domain.interactors.impl;

import android.util.Log;

import com.kodelabs.boilerplate.domain.interactors.UsersInteractor;
import com.kodelabs.boilerplate.domain.model.RandomUserResponse;
import com.kodelabs.boilerplate.framework.rest.UserAPI;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by javie on 06/02/2018.
 */

public class UsersInteractorImpl implements UsersInteractor {
    private static final String TAG = "UsersInteractorImpl";

    @Override
    public void execute(final Callback callback) {
        final UserAPI randomUserAPI = UserAPI.Factory.create();

        randomUserAPI.getRandomUsers(20)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RandomUserResponse>() {

                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "Completed transaction");
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError();
                    }

                    @Override
                    public void onNext(RandomUserResponse randomUserResponse) {
                        callback.onSuccess(randomUserResponse.getResults());
                    }
                });

        Log.d("TAG", "tag");
    }
}
