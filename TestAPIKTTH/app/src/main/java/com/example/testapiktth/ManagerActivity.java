package com.example.testapiktth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class ManagerActivity extends AppCompatActivity {

    private MyAdapter adapter;
    private FirebaseAuth auth;
    private RecyclerView recyclerView;
    private Button btnAdd, btnSignout;
    private FirebaseAuth.AuthStateListener stateListener;
    private String url = "https://60b0906b1f26610017ffe6e8.mockapi.io/student";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.manage_recyclerview);
        btnAdd = findViewById(R.id.manager_add);
        btnSignout = findViewById(R.id.manager_logout);
        adapter = new MyAdapter(ManagerActivity.this);
        recyclerView.setLayoutManager(new GridLayoutManager(ManagerActivity.this, 1));
        recyclerView.setAdapter(adapter);

        auth = FirebaseAuth.getInstance();

        btnAdd.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("student", new student());
            Intent intent = new Intent(ManagerActivity.this, FormStudent.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });

    }
}