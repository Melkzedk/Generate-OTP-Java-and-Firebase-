package com.example.craiglist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class OptionSelectionActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView STUDINFO,GENOTP,TOTALINFO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_selection);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,Activity_Login.class));
        }
        GENOTP = findViewById(R.id.genotp);
        STUDINFO = findViewById(R.id.studinfo);
        TOTALINFO = findViewById(R.id.totalinfo);
        GENOTP.setOnClickListener(this);
        STUDINFO.setOnClickListener(this);
        TOTALINFO.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == STUDINFO){
            startActivity(new Intent(OptionSelectionActivity.this,StudentInfoActivity.class));
        }
        if (v == GENOTP){
            Intent intent =new Intent(OptionSelectionActivity.this,LastActivity.class);
            intent.putExtra("Selected Option", "genotp");
            startActivity(intent);
        }
        if (v == TOTALINFO){
            Intent intent =new Intent(OptionSelectionActivity.this,LastActivity.class);
            intent.putExtra("Selected Option", "total");
            startActivity(intent);
        }

    }
}
