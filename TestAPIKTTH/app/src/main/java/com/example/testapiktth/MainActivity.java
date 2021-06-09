package com.example.testapiktth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText login_Email, login_Password;
    Button login_login;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();

        login_login = findViewById(R.id.login_login);
        login_Email = findViewById(R.id.login_Email);
        login_Password = findViewById(R.id.login_Password);
        login_Email.setText("luutkha@gmail.com");
        login_Password.setText("123456");

        login_login.setOnClickListener(v -> {
            if (valid()) {
                String strEmail = login_Email.getText().toString().trim();
                String strPass = login_Password.getText().toString().trim();

                auth.signInWithEmailAndPassword(strEmail, strPass)
                        .addOnCompleteListener(MainActivity.this, task -> {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(MainActivity.this, ManagerActivity.class));
                                finish();
                            } else {
                                Toast.makeText(this, "Đăng nhập không thành công. "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
    private boolean valid() {
        String strEmail = login_Email.getText().toString().trim();
        String strPass = login_Password.getText().toString().trim();

        if (strEmail.isEmpty()) {
            login_Email.setError("Email không được để trống");
            return false;
        }
        if (strPass.isEmpty()) {
            login_Password.setError("Vui lòng nhập mật khẩu");
            return false;
        }
        return true;
    }



}