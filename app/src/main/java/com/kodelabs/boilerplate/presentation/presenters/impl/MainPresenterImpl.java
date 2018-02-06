package com.kodelabs.boilerplate.presentation.presenters.impl;

import android.content.Context;

import com.kodelabs.boilerplate.R;
import com.kodelabs.boilerplate.domain.interactors.UsersInteractor;
import com.kodelabs.boilerplate.domain.interactors.impl.UsersInteractorImpl;
import com.kodelabs.boilerplate.domain.model.User;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter;

import java.util.List;

/**
 * Created by dmilicic on 12/13/15.
 */
public class MainPresenterImpl implements MainPresenter {

    private final Context context;
    private MainPresenter.View mView;
    private UsersInteractor usersInteractor;

    public MainPresenterImpl(View view, Context context) {
        mView = view;
        this.context = context;
        usersInteractor = new UsersInteractorImpl();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void getUsers() {
        usersInteractor.execute(new UsersInteractor.Callback() {
            @Override
            public void onSuccess(List<User> results) {
                mView.showUsers(results);
            }

            @Override
            public void onError() {
                mView.showError(context.getString(R.string.users_error));
            }
        });
    }
}
