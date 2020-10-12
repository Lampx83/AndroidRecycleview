package com.mycompany.recylerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtDescription =  findViewById(R.id.txtDescription);

        Intent intent = getIntent();

        if (intent != null) {
            Email email = (Email) intent.getSerializableExtra("email");

            if (email != null) {
                setTitle(email.title);
                txtDescription.setText(email.description);
            }
        }
    }
}