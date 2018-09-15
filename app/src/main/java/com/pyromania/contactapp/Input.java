package com.pyromania.contactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Input extends AppCompatActivity {

    EditText etName, etNumber, etWebsite, etLocation;
    ImageView ivSunny, ivNight;
    Button btnSubmit;
    String active;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etWebsite = findViewById(R.id.etWebsite);
        etLocation = findViewById(R.id.etLocation);
        ivSunny = findViewById(R.id.ivSunny);
        ivNight = findViewById(R.id.ivNight);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // select active period either day or night
                ivSunny.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        active = "day";
                    }
                });

                ivNight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        active = "night";
                    }
                });

                Intent intentActive = new Intent();
                intentActive.putExtra("active", active);
                setResult(RESULT_OK, intentActive);

                // see if all required fields are entered
                if (etName.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty() || etWebsite.getText().toString().isEmpty() || etLocation.getText().toString().isEmpty()) {
                    Toast.makeText(Input.this, "Please complete all fields!", Toast.LENGTH_SHORT).show();
                } else {
                    String name = etName.getText().toString().trim();
                    int phone = Integer.parseInt(etNumber.getText().toString().trim());
                    String web = etWebsite.getText().toString().trim();
                    String location = etLocation.getText().toString().trim();

                    Intent intentName = new Intent();
                    intentName.putExtra("name", name);
                    setResult(RESULT_OK, intentName);

                    Intent intentPhone = new Intent();
                    intentPhone.putExtra("phone",phone);
                    setResult(RESULT_OK, intentPhone);

                    Intent intentWeb = new Intent();
                    intentWeb.putExtra("website", web);
                    setResult(RESULT_OK, intentWeb);

                    Intent intentLocation = new Intent();
                    intentLocation.putExtra("location", location);
                    setResult(RESULT_OK, intentLocation);

                    Input.this.finish();
                }
            }
        });
    }
}
