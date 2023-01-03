package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    private static final String TAG = "FirebaseInItProvider";
    private FirebaseAuth Use;
    EditText Name, Email, Password, ConfirmPass;
    Button Register;
    TextView Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        onBackPressed();
        Use = FirebaseAuth.getInstance();
        Name =findViewById(R.id.regname);
        Email =findViewById(R.id.regemail);
        Password =findViewById(R.id.regpass);
        ConfirmPass =findViewById(R.id.cpass);
        Register = findViewById(R.id.register);
        Login = findViewById(R.id.log);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = Password.getText().toString().trim();
                String cpass = ConfirmPass.getText().toString().trim();
                if (pass.equals(cpass)){
                    Register();
                }
                else{
                    Password.setError("Passwords don't match");
                    ConfirmPass.setError("Passwords don't match");
                    Toast.makeText(Register.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, SignIn.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        /* super.onBackPressed(); */
    }

    private void Register() {
        String Nm = Name.getText().toString().trim();
        String Em = Email.getText().toString().trim();
        String Pass = Password.getText().toString().trim();
        String CPass = ConfirmPass.getText().toString().trim();
        if (Em.isEmpty()) {
            Email.setError("Field Empty");
        } else if (Nm.isEmpty()) {
            Name.setError("Field Empty");
        } else if (Pass.isEmpty()) {
            Password.setError("Field Empty");
        } else if (CPass.isEmpty()) {
            ConfirmPass.setError("Field Empty");
        } else if (isValidPassword(Password.getText().toString().trim())) {
            Use.createUserWithEmailAndPassword(Em, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this, home.class));
                    } else {
                        Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(Register.this, "Password must contain at least 1 upper case, numeric, and special character", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
}