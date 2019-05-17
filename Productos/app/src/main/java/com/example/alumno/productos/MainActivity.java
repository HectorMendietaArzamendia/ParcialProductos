package com.example.alumno.productos;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback, IListener {

    private Handler handler;
    List<Producto> productos;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(this);
        MyTrhread thread = new MyTrhread(handler);
        thread.start();

    }

    public void controlStock(int position, int btnId){
        Producto p = productos.get(position);
        if(btnId == R.id.btnMas) {
            p.setCantidad(p.getCantidad() + 1);
        }
        if(btnId == R.id.btnMenos) {
            if(p.getCantidad() != 0) p.setCantidad(p.getCantidad() - 1);
        }
        adapter.notifyItemChanged(position);
    }

    @Override
    public boolean handleMessage(Message msg) {
        String xml = (String) msg.obj;
        XmlParser parser = new XmlParser();
        productos = parser.obtenerProductos(xml);
        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        adapter = new MyAdapter(productos, this);
        list.setAdapter(adapter);

        return false;
    }
}
