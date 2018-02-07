package com.kodelabs.boilerplate.presentation.ui.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kodelabs.boilerplate.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jsivianes on 7/2/18.
 */

public class UserViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.text_name)
    public TextView name;
    @BindView(R.id.text_email)
    public TextView email;
    @BindView(R.id.text_gender)
    public TextView gender;


    public UserViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
