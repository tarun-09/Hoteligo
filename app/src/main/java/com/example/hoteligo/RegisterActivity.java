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

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private static final String TAG = "EmailPassword";

    EditText email, password, conPassword;
    Button register, link_to_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        conPassword = findViewById(R.id.confirm_password);

        register = findViewById(R.id.btn_register);
        link_to_login = findViewById(R.id.btn_sign_in);

        link_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }



    private void signup(){
        Log.d(TAG, "signUp"+ email);
        if(!validateForm()){
            return;
        }
        String em = email.getText().toString();
        String pass = password.getText().toString();

        mAuth.createUserWithEmailAndPassword(em, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                            finish();
                        }
                        else{
                            Log.w(TAG, "signUpWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Registration failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private boolean validateForm() {
        String em = email.getText().toString();
        String pass = password.getText().toString();
        String cpass = conPassword.getText().toString();
        boolean valid = true;
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


        if(TextUtils.isEmpty(cpass)){
            conPassword.setError("Required");
            valid = false;
        }
        else{
            conPassword.setError(null);
        }

        if(!cpass.equals(pass)){
            conPassword.setError("Password Doesn't Match");
            valid = false;
        }
        else{
            conPassword.setError(null);
        }

        if(pass.length() < 6){
            password.setError("Minimum 6 characters  required");
            valid = false;
        }
        else{
            password.setError(null);
        }

        return valid;
    }
}