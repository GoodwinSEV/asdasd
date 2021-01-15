package com.example.asdasd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class KursActivity extends AppCompatActivity {
    ImageView btn_back_main2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kurs);
        btn_back_main2 = findViewById(R.id.btn_back_main2);
        btn_back_main2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KursActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
