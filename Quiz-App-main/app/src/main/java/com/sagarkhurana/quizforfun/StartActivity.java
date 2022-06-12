package com.sagarkhurana.quizforfun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class StartActivity extends AppCompatActivity {
    Button loginStudent, loginAdmin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        loginStudent=findViewById(R.id.buttonLoginStudent);
        loginAdmin=findViewById(R.id.buttonLoginAdmin);

        loginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(StartActivity.this, LoginActivityADMIN.class);
                startActivity(in);
            }
        });

        loginStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(StartActivity.this, LoginActivity.class);
                startActivity(in);
            }
        });

    }
}
