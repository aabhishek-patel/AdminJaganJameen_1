package com.aabhishekpatel.adminjaganjameen_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aabhishekpatel.adminjaganjameen_1.Front.AdsActivity;
import com.aabhishekpatel.adminjaganjameen_1.Front.BuildActivity;
import com.aabhishekpatel.adminjaganjameen_1.Front.HousesActivity;
import com.aabhishekpatel.adminjaganjameen_1.Front.InteriorActivity;
import com.aabhishekpatel.adminjaganjameen_1.Front.LandActivity;
import com.aabhishekpatel.adminjaganjameen_1.Front.UsersActivity;

public class MainActivity extends AppCompatActivity {

    Button comments,add_product,add_interior,add_houses,add_build,users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comments = findViewById(R.id.comments);
        add_product = findViewById(R.id.add_product);
        add_houses = findViewById(R.id.add_houses);
        add_interior = findViewById(R.id.add_interior);
        add_build = findViewById(R.id.add_build);
        users = findViewById(R.id.users);

        comments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AdsActivity.class));
            }
        });

        add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LandActivity.class));
            }
        });

        add_interior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InteriorActivity.class));
            }
        });

        add_houses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HousesActivity.class));
            }
        });

        add_build.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BuildActivity.class));
            }
        });

        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UsersActivity.class));
            }
        });
    }
}
