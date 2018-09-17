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
    String active = "unselected";

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

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // see if all required fields are entered
                if (etName.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty() || etWebsite.getText().toString().isEmpty() || etLocation.getText().toString().isEmpty() || active.equals("unselected")) {
                    Toast.makeText(Input.this, "Please complete all fields!", Toast.LENGTH_SHORT).show();
                } else {
                    String name = etName.getText().toString().trim();
                    int phone = Integer.parseInt(etNumber.getText().toString().trim());
                    String web = etWebsite.getText().toString().trim();
                    String location = etLocation.getText().toString().trim();

                    Intent intent = new Intent();
                    intent.putExtra("name", name);
                    intent.putExtra("phone",phone);
                    intent.putExtra("website", web);
                    intent.putExtra("location", location);
                    intent.putExtra("active", active);

                    setResult(RESULT_OK, intent);

                    Input.this.finish();
                }
            }
        });
    }
}
