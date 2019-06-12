package com.ivan.carritodecompras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SistemaActivity extends AppCompatActivity {

    private Button btnSistema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema);

        btnSistema = findViewById(R.id.btnMAntenimientoProducto);

    }

    public void mantenimientoProducto(View view){
        Intent i = new Intent(this,ProductoActivity.class);
        startActivity(i);
    }
}
