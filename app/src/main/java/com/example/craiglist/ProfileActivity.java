package com.example.craiglist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout rellay1, rellay2;
    private Button PNext,PFnish;
    private EditText PName,PSubject,PTNOL,PNOLIW;
    private DatabaseReference databaseReference;
    private DatabaseReference SubjectInfo;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        rellay1 = findViewById(R.id.rellay1);
        rellay2 = findViewById(R.id.rellay2);
        databaseReference = FirebaseDatabase.getInstance().getReference("Teacher Info");

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,Activity_Login.class));
        }
        PName= findViewById(R.id.pname);
        PTNOL= findViewById(R.id.ptnol);
        PNOLIW= findViewById(R.id.pnoliw);
        PSubject= findViewById(R.id.psubject);
        PFnish= findViewById(R.id.pfnish);
        PFnish.setOnClickListener(this);
        PNext= findViewById(R.id.pnext);
        PNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if ( v == PNext){
            rellay1.setVisibility(View.INVISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
        if (v == PFnish){
            saveUserInfromation();

        }

    }

    private void saveUserInfromation() {
        String Name = PName.getText().toString().trim();
        String Subject = PSubject.getText().toString().trim();
        String TNOL = PTNOL.getText().toString().trim();
        String NOLIW = PNOLIW.getText().toString().trim();
        String sub =PSubject.getText().toString().toUpperCase().trim();
        switch (sub) {
            case "PHYSICS":
                SubjectInfo = FirebaseDatabase.getInstance().getReference(("PhysicsInformation"));
                break;
            case "CHEMISTRY":
                SubjectInfo = FirebaseDatabase.getInstance().getReference(("ChemistryInformation"));
                break;
            case "PETROLEUM":
                SubjectInfo = FirebaseDatabase.getInstance().getReference(("PetroleumInformation"));
                break;
            case "MATHS":
                SubjectInfo = FirebaseDatabase.getInstance().getReference(("MathsInformation"));
                break;
        }

        SubjectInformation subjectInformation = new SubjectInformation(TNOL,NOLIW);

        SubjectInfo.setValue(subjectInformation);

        UserInformation userInformation =new UserInformation(Name,Subject);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        assert user != null;
        databaseReference.child(user.getUid()).setValue(userInformation);

        Toast.makeText(this,"Information Saved",Toast.LENGTH_LONG).show();
        startActivity(new Intent(this,Activity_Login.class));

    }

}
