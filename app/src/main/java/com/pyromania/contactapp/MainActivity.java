package com.pyromania.contactapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvContactTitle;
    Button btnAdd;
    ImageView ivType, ivCall, ivWeb, ivLocation;

    final int INPUT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContactTitle = findViewById(R.id.tvContactTitle);
        btnAdd = findViewById(R.id.btnAdd);
        ivType = findViewById(R.id.ivType);
        ivCall = findViewById(R.id.ivCall);
        ivWeb = findViewById(R.id.ivWeb);
        ivLocation = findViewById(R.id.ivLocation);

        // set images to be invisible upon load
        ivType.setVisibility(View.GONE);
        ivCall.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);
        ivLocation.setVisibility(View.GONE);

        // selecting "add contact" and moving to Input Activity
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.pyromania.contactapp.Input.class);
                startActivityForResult(intent, INPUT);
            }
        });
    }

    // Method needed to get back result from INPUT activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
