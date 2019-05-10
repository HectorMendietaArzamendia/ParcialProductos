package com.example.alumno.productos;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(this);
        MyTrhread thread = new MyTrhread(handler);
        thread.start();

    }

    @Override
    public boolean handleMessage(Message msg) {
        String xml = (String) msg.obj;
        XmlParser parser = new XmlParser();
        List<Producto> productos = parser.obtenerProductos(xml);
        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        MyAdapter adapter = new MyAdapter(productos);
        list.setAdapter(adapter);

        return false;
    }
}
