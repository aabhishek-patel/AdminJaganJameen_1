package com.aabhishekpatel.adminjaganjameen_1.Front;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.aabhishekpatel.adminjaganjameen_1.Adapter.AdsAdapter;
import com.aabhishekpatel.adminjaganjameen_1.Adapter.UserAdapter;
import com.aabhishekpatel.adminjaganjameen_1.Model.Ads;
import com.aabhishekpatel.adminjaganjameen_1.Model.Users;
import com.aabhishekpatel.adminjaganjameen_1.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    UserAdapter userAdapter;
    List<Users> usersList;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        /*------------------------------- Recycleview -------------------------------*/
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        usersList = new ArrayList<Users>();

        /*------------------------------- Load Land data to recycleview -------------------------------*/
        reference = FirebaseDatabase.getInstance().getReference().child("Users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Users users = dataSnapshot1.getValue(Users.class);
                    usersList.add(users);
                }
                userAdapter = new UserAdapter(getApplicationContext(),usersList);
                recyclerView.setAdapter(userAdapter);
                //progress_bar.setVisibility(View.INVISIBLE);
                userAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getApplicationContext(),"Opsss... Somthing is wrong...",Toast.LENGTH_SHORT).show();
                //progress_bar.setVisibility(View.INVISIBLE);
            }
        });
    }
}