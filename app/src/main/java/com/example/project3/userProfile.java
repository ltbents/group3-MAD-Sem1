package com.example.project3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class userProfile extends AppCompatActivity {
    private Button btnchangepassword;
    private Button btnLogout;
    private FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_profile);
        // Initialize views and Firebase authentication instance
        btnchangepassword = findViewById(R.id.btnChangePassword);
        btnLogout = findViewById(R.id.btnLogout);
        mauth = FirebaseAuth.getInstance();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            // Button click listener for logout
            @Override
            public void onClick(View view) {
                mauth.signOut();// Sign out the current user
                Intent intent = new Intent(userProfile.this, Login.class);// Redirect to the login activity
                startActivity(intent);
                finish();
            }
        });
        btnchangepassword.setOnClickListener(new View.OnClickListener() {
            // Button click listener for changing password
            @Override
            public void onClick(View view) {
                change_password.newInstance().show(getSupportFragmentManager(), change_password.TAG);// Show the change password dialog
            }
        });
    }
}