package com.kodelabs.boilerplate.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kodelabs.boilerplate.R;
import com.kodelabs.boilerplate.domain.model.User;
import com.kodelabs.boilerplate.presentation.ui.viewholders.UserViewHolder;

import java.util.List;

/**
 * Created by jsivianes on 7/2/18.
 */

public class UsersListAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private List<User> userList;

    public UsersListAdapter(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_user, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = userList.get(position);

        holder.name.setText(user.getName().getFirst() + " " + user.getName().getLast());
        holder.gender.setText(user.getGender());
        holder.email.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
