package com.matt.mymoney;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;

public class Adm extends AppCompatActivity {
    private FloatingActionButton fabp, fabm;
    private TextView txvadd, txvmin, txvtot;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm);

        fabp= findViewById(R.id.fabplus);
        fabm= findViewById(R.id.fabminus);
        rv= findViewById(R.id.rv1);

        txvadd= findViewById(R.id.txv1);
        txvmin= findViewById(R.id.txv2);
        txvtot= findViewById(R.id.txv3);

        fabp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oppadd= new Intent(getApplicationContext(), Add.class);
                startActivity(oppadd);
                Toast.makeText(getApplicationContext(), "¡Registre su ingreso economico!", Toast.LENGTH_SHORT).show();
            }
        });

        fabm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oppdis= new Intent(getApplicationContext(), Dis.class);
                startActivity(oppdis);
                Toast.makeText(getApplicationContext(), "¡Registre su egreso economico!", Toast.LENGTH_SHORT).show();
            }
        });

        Bundle extras= getIntent().getExtras();
        String concepto, fecha;
        Double precio;
        Boolean tipo;

        if (extras != null) {
            concepto= extras.getString("concepto");
            fecha= extras.getString("fecha");
            precio= extras.getDouble("precio");
            tipo= extras.getBoolean("tipo");

            Control control= new Control();
            control.fecha= fecha;
            control.concepto= concepto;
            control.precio= precio;
            control.tipo= tipo;
            MainActivity.lista.add( control );
            // and get whatever type user account id is
        }

        Double total = 0.0, adds = 0.0, dis = 0.0;
        for (Control c:
                MainActivity.lista) {
            if ( c.tipo ) {
                adds += c.precio;
                total += c.precio;
            }else{
                dis -= c.precio;
                total -= c.precio;
            }
        }
        txvtot.setText(String.valueOf(total));
        txvadd.setText(String.valueOf(adds));
        txvmin.setText(String.valueOf(dis));

        rv.setLayoutManager( new LinearLayoutManager( getApplicationContext() ));
        ControlAdaptador adaptador = new ControlAdaptador();
        rv.setAdapter( adaptador );
    }

}

