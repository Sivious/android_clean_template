package com.kodelabs.boilerplate.presentation.ui.navigator;

import android.app.Activity;
import android.content.Intent;

import com.kodelabs.boilerplate.common.Constants;
import com.kodelabs.boilerplate.domain.model.User;
import com.kodelabs.boilerplate.presentation.ui.activities.DetailActivity;

/**
 * Created by jsivianes on 7/2/18.
 */

public class Navigator {
    private final Activity context;

    public Navigator(Activity context) {
        this.context = context;
    }

    private void startActivity(Intent intent) {
        context.startActivity(intent);
    }

    public void openDetail(User user){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(Constants.USER_INTENT, user);
        context.startActivity(intent);
    }
}
