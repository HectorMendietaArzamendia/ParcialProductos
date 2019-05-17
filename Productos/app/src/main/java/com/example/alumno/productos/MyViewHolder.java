package com.example.alumno.productos;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alumno on 09/05/2019.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements OnClickListener{
    TextView tvNombre;
    TextView tvCantidad;
    TextView tvPrecio;
    ImageView btnMenos;
    ImageView btnMas;
    private IListener lisener;
    private int position;

    public void setPosition(int position) {
        this.position = position;
    }

    public MyViewHolder(View itemView, IListener listener) {
        super(itemView);
        tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
        tvCantidad = (TextView) itemView.findViewById(R.id.tvCantidad);
        tvPrecio = (TextView) itemView.findViewById(R.id.tvPrecio);
        btnMas = (ImageView) itemView.findViewById(R.id.btnMas);
        btnMenos = (ImageView) itemView.findViewById(R.id.btnMenos);
        btnMas.setOnClickListener(this);
        btnMenos.setOnClickListener(this);
        this.lisener = listener;
    }

    @Override
    public void onClick(View v) {
        lisener.controlStock(position, v.getId());
    }
}
