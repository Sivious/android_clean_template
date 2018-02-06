package com.kodelabs.boilerplate.presentation.presenters;

import com.kodelabs.boilerplate.domain.model.User;
import com.kodelabs.boilerplate.presentation.presenters.base.BasePresenter;
import com.kodelabs.boilerplate.presentation.ui.BaseView;

import java.util.List;


public interface MainPresenter extends BasePresenter {
    void getUsers();

    interface View extends BaseView {
        void showUsers(List<User> results);
    }
}
