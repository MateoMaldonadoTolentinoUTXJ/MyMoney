package com.matt.mymoney;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ControlAdaptador extends RecyclerView.Adapter<ControlAdaptador.viewHolder> {
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.control, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Control c = MainActivity.lista.get( position );
        if ( c.tipo ){
            holder.tipo.setText("Ingreso por:");
            holder.tipo.setBackgroundColor(Color.rgb(65,165,255));
            holder.tipo.setTextColor(Color.rgb(255,255,255));
        }else{
            holder.tipo.setText("Egreso por:");
            holder.tipo.setBackgroundColor(Color.rgb(255,60,165));
            holder.tipo.setTextColor(Color.rgb(255,255,255));
        }
        holder.precio.setText(String.valueOf(c.precio));
        holder.fecha.setText(c.fecha);
        holder.concepto.setText(c.concepto);
    }

    @Override
    public int getItemCount() {
        return MainActivity.lista.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView precio, tipo, fecha, concepto;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            precio = itemView.findViewById(R.id.txvC1);
            tipo = itemView.findViewById(R.id.txvC2);
            fecha = itemView.findViewById(R.id.txvC3);
            concepto = itemView.findViewById(R.id.txvC4);
        }
    }
}
