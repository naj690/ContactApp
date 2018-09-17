package com.pyromania.contactapp;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvContactTitle, tvTest;
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
        tvTest = findViewById(R.id.tvTest);

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

        if (requestCode == INPUT) {
            if (resultCode == RESULT_OK) {
                String frontPic = data.getStringExtra("active");
                int telephone = Integer.parseInt(data.getStringExtra("phone"));


                ivType.setVisibility(View.VISIBLE);
                ivCall.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);
                ivLocation.setVisibility(View.VISIBLE);

                if (frontPic.equals("night")) {
                    ivType.setImageResource(R.drawable.night);
                } else {
                    ivType.setImageResource(R.drawable.sunny);
                }

                tvTest.setText(data.getStringExtra("name") + " " + data.getStringExtra("phone") + " " + data.getStringExtra("website") + " " + data.getStringExtra("location") + " " + data.getStringExtra("active") + " " + frontPic);

                // action for the CALL button
                ivCall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + telephone));
                        startActivity(intent);
                    }
                });

                // action for the WEB button
                ivWeb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

                //set action for the location button
                ivLocation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }

            if (resultCode == RESULT_CANCELED) {
                tvTest.setText("No data received!");
            }
        }
    }
}
