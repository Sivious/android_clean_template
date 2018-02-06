package com.kodelabs.boilerplate.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.kodelabs.boilerplate.R;
import com.kodelabs.boilerplate.domain.model.RandomUserResponse;
import com.kodelabs.boilerplate.framework.rest.UserAPI;
import com.kodelabs.boilerplate.presentation.presenters.MainPresenter.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity implements View {

    @BindView(R.id.texview_main_hello_world)
    TextView hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        //loadJson();
        getRandomUsers();
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

    private void getRandomUsers(){
        final UserAPI randomUserAPI = UserAPI.Factory.create();

        randomUserAPI.getRandomUsers(20)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RandomUserResponse>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RandomUserResponse randomUserResponse) {
                        Log.d("TAG", "tag");
                    }
                });

        Log.d("TAG", "tag");
    }

//    private void loadJson(){
//        Gson gson = new GsonBuilder()
//                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//                .create();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://randomuser.me/")
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
//
//        UserAPI restClient = retrofit.create(UserAPI.class);
//
//        Call<RandomUserResponse> call = restClient.getUsers(20);
//
//        call.enqueue(new Callback<RandomUserResponse>() {
//            @Override
//            public void onResponse(Call<RandomUserResponse> call, Response<RandomUserResponse> response) {
//                switch (response.code()) {
//                    case 200:
//                        RandomUserResponse data = response.body();
//                        //view.notifyDataSetChanged(data.getResults());
//                        break;
//                    case 401:
//
//                        break;
//                    default:
//
//                        break;
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RandomUserResponse> call, Throwable t) {
//                Log.d("TAG", "Failure");
//            }
//        });
//
//
//    }
}
