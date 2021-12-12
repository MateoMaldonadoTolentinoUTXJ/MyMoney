package com.matt.mymoney;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class Dis extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton Dis, Cancel;
    private Button fch;
    private TextView fecha;
    private int dia, mes, year;
    EditText concepto, precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dis);

        Dis= findViewById(R.id.fabdis);
        Cancel= findViewById(R.id.fabcdis);

        fch= findViewById(R.id.btnfech1);
        fecha= findViewById(R.id.txvD2);

        fch.setOnClickListener(this);

        concepto = findViewById(R.id.txvD1);
        precio = findViewById(R.id.txvD3);

        Dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancel= new Intent(getApplicationContext(), Adm.class);
                if (TextUtils.isEmpty( concepto.getText() )){
                    Toast.makeText(getApplicationContext(), "Ingrese su concepto", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(precio.getText())){
                    Toast.makeText(getApplicationContext(), "Ingrese el monto", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(fecha.getText())){
                    Toast.makeText(getApplicationContext(), "Ingrese la fecha", Toast.LENGTH_SHORT).show();
                    return;
                }
                cancel.putExtra("concepto", concepto.getText().toString());
                cancel.putExtra("precio", Double.parseDouble(precio.getText().toString()));
                cancel.putExtra("fecha", fecha.getText().toString());
                cancel.putExtra("tipo", false);
                startActivity(cancel);
                Toast.makeText(getApplicationContext(),"¡Registro Guardado!",Toast.LENGTH_SHORT).show();
            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancel= new Intent(getApplicationContext(), Adm.class);
                startActivity(cancel);
                Toast.makeText(getApplicationContext(), "¡Registro Cancelado!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == fch){
            final Calendar c= Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            year=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
                    ,year, mes, dia);
            datePickerDialog.show();
        }

    }
}