package com.kodelabs.boilerplate.domain.interactors;

import com.kodelabs.boilerplate.domain.model.User;

import java.util.List;

/**
 * Created by javie on 06/02/2018.
 */

public interface UsersInteractor {

    void execute(Callback callback);

    interface Callback {
        void onSuccess(List<User> results);

        void onError();
    }

}
