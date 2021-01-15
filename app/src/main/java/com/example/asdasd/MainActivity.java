package com.example.asdasd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout btn_auth, btn_otd, btn_kurs;
    Button btn_add,btn_back;
    EditText edUsername, edPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_auth = findViewById(R.id.btn_auth);
        btn_auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        btn_otd = findViewById(R.id.btn_otd);
        btn_otd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, OtdActivity.class);
                startActivity(intent1);
            }
        });

        btn_kurs = findViewById(R.id.btn_kurs);
        btn_kurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, KursActivity.class);
                startActivity(intent2);
            }
        });
    }
    public void showDialog(){
        AlertDialog.Builder alert;
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            alert = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        }else{
            alert = new AlertDialog.Builder(this);
        }


        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.alert_dialog,null);

        edUsername = view.findViewById(R.id.edUsername);
        edPassword = view.findViewById(R.id.edPassword);
        btn_add = view.findViewById(R.id.btn_add);
        btn_back = view.findViewById(R.id.btn_back);

        alert.setView(view);
        alert.setCancelable(false);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = edUsername.getText().toString();
                Toast.makeText(getApplicationContext(),"Добро пожаловать "+user_name ,Toast.LENGTH_LONG).show();
            }
        });

        final AlertDialog dialog = alert.create();
        dialog.show();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}