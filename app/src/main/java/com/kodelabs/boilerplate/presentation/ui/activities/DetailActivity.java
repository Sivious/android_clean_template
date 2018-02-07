package com.kodelabs.boilerplate.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.kodelabs.boilerplate.R;
import com.kodelabs.boilerplate.common.Constants;
import com.kodelabs.boilerplate.domain.model.User;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jsivianes on 7/2/18.
 */

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.image_detail_picture)
    ImageView picture;
    @BindView(R.id.text_detail_name)
    TextView name;
    @BindView(R.id.text_detail_location)
    TextView location;
    @BindView(R.id.text_detail_phone)
    TextView phone;
    @BindView(R.id.text_detail_email)
    TextView email;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user = (User) getIntent().getExtras().get(Constants.USER_INTENT);

        setUserData();
    }

    private void setUserData() {
        Picasso.with(this).load(user.getPicture().getLarge()).into(picture);
        name.setText(user.getFullName());
        location.setText(user.getLocation().getStreet());
        phone.setText(user.getCell());
        email.setText(user.getEmail());
    }
}
