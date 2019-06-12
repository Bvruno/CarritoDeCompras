package com.ivan.carritodecompras;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.ivan.carritodecompras.adaptadores.ProductoAdapter;
import com.ivan.carritodecompras.daos.ProductoDAO;
import com.ivan.carritodecompras.dtos.Producto;

import java.util.ArrayList;

public class ProductoActivity extends AppCompatActivity {
    public static ListView lstProductos;
    public static ArrayList<Producto> productos;
    private ProductoDAO productoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        lstProductos = findViewById(R.id.lstProductos);
        productoDAO = new ProductoDAO();
        productos = productoDAO.selectAll();
        ProductoAdapter productoAdapter = new ProductoAdapter(productos,this);

        lstProductos.setAdapter(productoAdapter);
    }
}
