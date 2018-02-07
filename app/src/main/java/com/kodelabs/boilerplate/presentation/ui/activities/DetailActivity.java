package com.kodelabs.boilerplate.presentation.ui.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.kodelabs.boilerplate.R;
import com.kodelabs.boilerplate.common.Constants;
import com.kodelabs.boilerplate.domain.model.User;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jsivianes on 7/2/18.
 */

public class DetailActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
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
        location.setText(user.getLocation().toString());
        phone.setText(user.getCell());
        email.setText(user.getEmail());
    }

    @OnClick(R.id.image_detail_phone)
    public void onPhoneCall() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + user.getCell()));

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
        } else {
            try {
                startActivity(callIntent);
            } catch(SecurityException e) {
                e.printStackTrace();
            }
        }
    }

    @OnClick(R.id.image_detail_email)
    public void onSendEmail(){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",user.getEmail(), null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
        startActivity(Intent.createChooser(emailIntent, ""));
    }

}
