package com.example.alumno.productos;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by alumno on 09/05/2019.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView tvNombre;
    TextView tvCantidad;
    TextView tvPrecio;

    public MyViewHolder(View itemView) {
        super(itemView);
        tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
        tvCantidad = (TextView) itemView.findViewById(R.id.tvCantidad);
        tvPrecio = (TextView) itemView.findViewById(R.id.tvPrecio);
    }
}
