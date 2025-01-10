package com.example.studyanalayzer;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            //v.setPadding(systemBars.left,0, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button join ;
        join = findViewById(R.id.login_join);

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home  = new Intent(LoginActivity.this , Home.class);
                startActivity(home);
            }
        });



    }
}