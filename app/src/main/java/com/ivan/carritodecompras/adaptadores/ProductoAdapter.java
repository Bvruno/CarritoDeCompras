package com.ivan.carritodecompras.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ivan.carritodecompras.R;
import com.ivan.carritodecompras.dtos.Producto;

import java.util.ArrayList;

public class ProductoAdapter extends BaseAdapter {

    private ArrayList<Producto> productos;
    private Context context;

    public ProductoAdapter(ArrayList<Producto> productos, Context context) {
        this.productos = productos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return productos.size();
    }

    @Override
    public Object getItem(int position) {
        return productos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Producto producto = productos.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.producto_item,null);
        TextView id= convertView.findViewById(R.id.txtIdP);
        TextView nombre= convertView.findViewById(R.id.txtnombreP);

        id.setText(producto.getId());
        nombre.setText(producto.getNombre());

        return convertView;
    }
}
