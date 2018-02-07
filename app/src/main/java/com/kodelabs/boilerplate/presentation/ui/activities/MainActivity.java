package com.kodelabs.boilerplate.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.kodelabs.boilerplate.R;
import com.kodelabs.boilerplate.domain.model.RandomUserResponse;
import com.kodelabs.boilerplate.domain.model.User;
import com.kodelabs.boilerplate.framework.rest.UserAPI;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter.View;
import com.kodelabs.boilerplate.presentation.presenters.impl.MainPresenterImpl;
import com.kodelabs.boilerplate.presentation.ui.adapter.UsersListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity implements View {
    MainPresenter presenter;
    UsersListAdapter usersListAdapter;

    @BindView(R.id.recycler_view_users)
    RecyclerView mRecyclerViewUsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();

        //loadJson();
        //getRandomUsers();
    }

    private void init() {
        presenter = new MainPresenterImpl(this, getApplicationContext());
        presenter.getUsers();
    }

    @Override
    public void showProgress() {
    }

    @Override
    public void hideProgress() {
    }

    @Override
    public void showError(String message) {
    }

//    private void getRandomUsers(){
//        final UserAPI randomUserAPI = UserAPI.Factory.create();
//
//        randomUserAPI.getRandomUsers(20)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<RandomUserResponse>() {
//
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(RandomUserResponse randomUserResponse) {
//                        Log.d("TAG", "tag");
//                    }
//                });
//
//        Log.d("TAG", "tag");
//    }

    @Override
    public void showUsers(List<User> users) {
        usersListAdapter = new UsersListAdapter(users);
        mRecyclerViewUsers.setAdapter(usersListAdapter);
        mRecyclerViewUsers.setLayoutManager(new LinearLayoutManager(this));

        usersListAdapter.notifyDataSetChanged();
    }

}
