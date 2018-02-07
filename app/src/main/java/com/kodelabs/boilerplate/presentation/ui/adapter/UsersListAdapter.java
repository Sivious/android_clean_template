package com.kodelabs.boilerplate.presentation.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kodelabs.boilerplate.R;
import com.kodelabs.boilerplate.domain.model.User;
import com.kodelabs.boilerplate.presentation.ui.navigator.Navigator;
import com.kodelabs.boilerplate.presentation.ui.viewholders.UserViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jsivianes on 7/2/18.
 */

public class UsersListAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private List<User> userList;
    private Context context;
    private Activity activity;

    public UsersListAdapter(List<User> userList, Activity activity) {
        this.userList = userList;
        this.activity = activity;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_user, parent, false);

        this.context = parent.getContext();
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        final User user = userList.get(position);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Navigator(activity).openDetail(user);
            }
        });
        holder.name.setText(user.getFullName());
        holder.gender.setText(user.getGender());
        holder.email.setText(user.getEmail());

        Picasso.with(context).load(user.getPicture().getThumbnail()).into(holder.profile);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
