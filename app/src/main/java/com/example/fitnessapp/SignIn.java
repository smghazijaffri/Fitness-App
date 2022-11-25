package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    private FirebaseAuth Use;
    EditText Username, Password;
    Button Register, Login;
    private static final int REQ_ONE_TAP = 2;  // Can be any integer unique to the Activity.
    private boolean showOneTapUI = true;
    private SignInClient oneTapClient;
    private BeginSignInRequest signInRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Use = FirebaseAuth.getInstance();
        Username = findViewById(R.id.user);
        Password = findViewById(R.id.pass);
        Login = findViewById(R.id.login);
        Register = findViewById(R.id.register);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
    }

    private void Login() {
        String Name = Username.getText().toString().trim();
        String Pass = Password.getText().toString().trim();
        if (Name.isEmpty()){
            Username.setError("Field Empty");
        }
        else if (Pass.isEmpty()){
            Password.setError("Field Empty");
        }
        else {
            Use.signInWithEmailAndPassword(Name, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(SignIn.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignIn.this,SignIn.class));
                    }
                    else {
                        Toast.makeText(SignIn.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void Register() {
        String Name = Username.getText().toString().trim();
        String Pass = Password.getText().toString().trim();
        if (Name.isEmpty()){
            Username.setError("Field Empty");
        }
        else if (Pass.isEmpty()){
            Password.setError("Field Empty");
        }
        else {
            Use.createUserWithEmailAndPassword(Name, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(SignIn.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignIn.this,MainActivity.class));
                    }
                    else {
                        Toast.makeText(SignIn.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}