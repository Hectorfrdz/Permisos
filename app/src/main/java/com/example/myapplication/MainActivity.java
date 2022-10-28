package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;

import com.example.myapplication.adaptadores.permisoAdapter;

import java.util.ArrayList;
import java.util.List;

import modelos.Permisos;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Permisos> permisos =new ArrayList<>();
        permisos.add(new Permisos("llamada", Manifest.permission.CALL_PHONE));
        permisos.add(new Permisos("camara", Manifest.permission.CAMERA));
        permisos.add(new Permisos("leer contactos", Manifest.permission.READ_CONTACTS));
        permisos.add(new Permisos("enviar SMS", Manifest.permission.SEND_SMS));
        permisos.add(new Permisos("localizacion", Manifest.permission.ACCESS_BACKGROUND_LOCATION));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        permisoAdapter adapter = new permisoAdapter(permisos);
        recyclerView.setAdapter(adapter);
    }
}