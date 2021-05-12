package com.aabhishekpatel.adminjaganjameen_1.Front;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.aabhishekpatel.adminjaganjameen_1.Adapter.AdsAdapter;
import com.aabhishekpatel.adminjaganjameen_1.Model.Ads;
import com.aabhishekpatel.adminjaganjameen_1.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdsActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST_CODE = 1;


    RecyclerView recyclerView;
    AdsAdapter adsAdapter;
    List<Ads> adsList;

    DatabaseReference reference;

    private ProgressBar progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);

        /*------------------------------- Recycleview -------------------------------*/
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        adsList = new ArrayList<Ads>();

        /*------------------------------- Load Land data to recycleview -------------------------------*/
        reference = FirebaseDatabase.getInstance().getReference().child("Comments");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Ads ads = dataSnapshot1.getValue(Ads.class);
                    adsList.add(ads);
                }
                adsAdapter = new AdsAdapter(getApplicationContext(),adsList);
                recyclerView.setAdapter(adsAdapter);
                //progress_bar.setVisibility(View.INVISIBLE);
                adsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getApplicationContext(),"Opsss... Somthing is wrong...",Toast.LENGTH_SHORT).show();
                //progress_bar.setVisibility(View.INVISIBLE);
            }
        });
    }
}
