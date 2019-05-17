package com.example.alumno.productos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by alumno on 04/04/2019.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    List<Producto> productos;
    private IListener main;

    public MyAdapter(List<Producto> productos, IListener main){
        this.productos = productos;
        this.main = main;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = null;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.producto_layout,parent,false);

        MyViewHolder myViewHoleder = new MyViewHolder(v, main);


        return myViewHoleder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Producto p = productos.get(position);
        holder.setPosition(position);

        holder.tvNombre.setText(p.getNombre());
        holder.tvCantidad.setText("Cantidad: " + Integer.valueOf(p.getCantidad()).toString());
        holder.tvPrecio.setText("Precio unidad " + Double.valueOf(p.getPrecio()).toString());
    }

    @Override
    public int getItemCount() {

        return this.productos.size();
    }

 /*   public void setPersonas(List<Persona>p){
        this.personas=p;
    }*/
}
