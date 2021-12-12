package com.matt.mymoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Control> lista = new ArrayList<>();
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= findViewById(R.id.btnstart);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent start= new Intent(getApplicationContext(), Adm.class);
                startActivity(start);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                Toast.makeText(getApplicationContext(), "¡Bienvenido!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
