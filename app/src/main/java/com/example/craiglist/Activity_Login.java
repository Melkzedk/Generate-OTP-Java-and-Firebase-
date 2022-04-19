package com.example.craiglist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Activity_Login extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout rellay1, rellay2, rellay3;
    private Button LSignUp,LLogin;
    private Button Fpassword;
    private EditText LUsername,LPassword;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
            rellay3.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        rellay1 = findViewById(R.id.rellay1);
        rellay2 = findViewById(R.id.rellay2);
        rellay3 = findViewById(R.id.rellay3);

        handler.postDelayed(runnable, 1700);

        progressDialog = new ProgressDialog(this);

        LSignUp= findViewById(R.id.lsignup);
        LLogin= findViewById(R.id.llogin);
        Fpassword = findViewById(R.id.Fpassword);
        LUsername= findViewById(R.id.lusername);
        LPassword= findViewById(R.id.lpassword);
        LSignUp.setOnClickListener(this);
        LLogin.setOnClickListener(this);
        Fpassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == LSignUp){
            startActivity(new Intent(Activity_Login.this,SignUpActivity.class));
        }
        if (view == Fpassword){
            startActivity(new Intent(Activity_Login.this, ResetPasswordActivity.class));
        }
        if (view == LLogin){
            userLogin();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        finish();
        startActivity(intent);
    }

    private void userLogin() {
        String username = LUsername.getText().toString().trim();
        String password = LPassword.getText().toString().trim();

        if (TextUtils.isEmpty(username)){
            Toast.makeText(this, "Please Enter Username",Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please Enter Password",Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Logging In...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(username,password)
                .addOnCompleteListener(this, task -> {
                    progressDialog.dismiss();
                    if (task.isSuccessful()){
                        finish();
                        startActivity(new Intent(getApplicationContext(),OptionSelectionActivity.class));
                    }
                    else {
                        Toast.makeText(Activity_Login.this,"Log In Unsuccessful Please Try Again",Toast.LENGTH_LONG).show();
                    }
                });
    }
}
