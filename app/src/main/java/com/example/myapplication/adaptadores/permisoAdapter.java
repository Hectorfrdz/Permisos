package com.example.myapplication.adaptadores;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

import modelos.Permisos;

public class permisoAdapter extends RecyclerView.Adapter<permisoAdapter.viewHolder> {
    List<Permisos> I;

    public permisoAdapter(List<Permisos>I){this.I = I;}
    int request_code = 200;

    @NonNull
    @Override
    public permisoAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.setData(I.get(position));
    }

    @Override
    public int getItemCount() {
        return I.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView txtintent;
        Permisos permisoHolder;
        private int request_code = 200;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            txtintent = (TextView)itemView.findViewById(R.id.permiso);
            itemView.setOnClickListener(this::onClick);
        }

        private void onClick(View view) {
            ActivityCompat.requestPermissions((Activity) view.getContext(),
                    new String[]{permisoHolder.getPermiso()},request_code);
        }

        public void setData(Permisos intents) {
            permisoHolder = intents;
            txtintent.setText(intents.getName());
        }
    }
}
