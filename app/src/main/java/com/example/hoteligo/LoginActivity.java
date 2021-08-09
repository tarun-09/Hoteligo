package com.example.hoteligo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static final String TAG = "EmailPassword";

    EditText email, password;
    Button login, link_to_registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        login = findViewById(R.id.btn_login);
        link_to_registration = findViewById(R.id.btn_sign_up);

        link_to_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin();
            }
        });
    }



    private void signin() {
        Log.d(TAG, "signIn" +email);
        if(!validateForm()){
            return;
        }
        String em = email.getText().toString();
        String pass = password.getText().toString();

        mAuth.signInWithEmailAndPassword(em, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Signed In Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                            finish();
                        }
                        else{
                            Log.w(TAG,"SignInFailure", task.getException());
                            Toast.makeText(LoginActivity.this,"Sign In Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private boolean validateForm() {
        boolean valid = true;
        String em = email.getText().toString();
        String pass = password.getText().toString();

        if(TextUtils.isEmpty(em)){
            email.setError("Required");
            valid = false;
        }
        else{
            email.setError(null);
        }


        if(TextUtils.isEmpty(pass)){
            password.setError("Required");
            valid = false;
        }
        else{
            password.setError(null);
        }

        return valid;
    }
}