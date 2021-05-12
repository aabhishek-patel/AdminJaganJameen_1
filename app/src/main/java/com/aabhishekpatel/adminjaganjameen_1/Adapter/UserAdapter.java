package com.aabhishekpatel.adminjaganjameen_1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aabhishekpatel.adminjaganjameen_1.Model.Ads;
import com.aabhishekpatel.adminjaganjameen_1.Model.Users;
import com.aabhishekpatel.adminjaganjameen_1.R;
import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    public Context mcontext;
    public List<Users> usersList;

    private static final int REQUEST_CALL =1;

    DatabaseReference reference;

    public UserAdapter(Context mcontext, List<Users> usersList) {
        this.mcontext = mcontext;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.user, viewGroup, false);
        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int i) {
        reference= FirebaseDatabase.getInstance().getReference("Users");
        final Users users = usersList.get(i);

        holder.name.setText(usersList.get(i).getUsername());
        holder.phone.setText(usersList.get(i).getPhoneNo());

        //holder.profile.setImageURI(users.getProfile());

        //Loading image from Glide library.
        Picasso.get().load(users.getProfile()).into(holder.profile);
        //Glide.with(context).load(.getImageURL()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, phone;
        ImageView profile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
            profile = itemView.findViewById(R.id.profile);
        }
    }
}
