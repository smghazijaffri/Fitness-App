package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignIn extends AppCompatActivity {
    private static final String TAG = "FirebaseInitProvider";
    private FirebaseAuth Use;
    EditText Username, Password;
    Button Register, Login;
    TextView Regi;
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
        Regi = findViewById(R.id.reg);

        onBackPressed();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            Intent i = new Intent(SignIn.this, home.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            String cancel = "Go";
            i.putExtra("Logged In", cancel);
            startActivity(i);
        } else {
            // User is signed out
            Log.d(TAG, "onAuthStateChanged:signed_out");
        }

        Intent intent = getIntent();
        intent.getExtras();


        if(intent.hasExtra("Signed Out"))
        {
            Toast.makeText(this, "Signed Out", Toast.LENGTH_SHORT).show();
        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                Login();
            }
        });
        Regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this, Register.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        /* super.onBackPressed(); */
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
                        startActivity(new Intent(SignIn.this,home.class));
                    }
                    else {
                        Toast.makeText(SignIn.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    /*private void Register() {
        String Name = Username.getText().toString().trim();
        String Pass = Password.getText().toString().trim();
        if (Name.isEmpty()){
            Username.setError("Field Empty");
        }
        else if (Pass.isEmpty()){
            Password.setError("Field Empty");
        }
        else if(isValidPassword(Password.getText().toString().trim())) {
            Use.createUserWithEmailAndPassword(Name, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(SignIn.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignIn.this, home.class));
                    }
                    else {
                        Toast.makeText(SignIn.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else{
            Toast.makeText(SignIn.this, "Password must contain at least 1 upper case, numeric, and special character", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }*/
}