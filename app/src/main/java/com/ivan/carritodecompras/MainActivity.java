package com.ivan.carritodecompras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ivan.carritodecompras.daos.UsuarioDAO;
import com.ivan.carritodecompras.dtos.Usuario;

public class MainActivity extends AppCompatActivity {

    private EditText correo;
    private EditText clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        correo = findViewById(R.id.txtCorreo);
        clave = findViewById(R.id.txtClave);

    }

    public void login(View view){

        Usuario usuario = new Usuario(correo.getText().toString(),clave.getText().toString());

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        if (usuarioDAO.login(usuario)){
            Toast.makeText(this,"Login Correcto",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this,"Login Incorrecto",Toast.LENGTH_SHORT).show();
        }
    }
    public void insertar(View view){

        Usuario usuario = new Usuario(correo.getText().toString(),clave.getText().toString());

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        if (usuarioDAO.login(usuario)){
            Toast.makeText(this,"Login Correcto",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this,"Login Incorrecto",Toast.LENGTH_SHORT).show();
        }
    }
    public void olvidoclave(View view){
        Usuario usuario = new Usuario(correo.getText().toString());
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        String clave = usuarioDAO.verClave(usuario);
        if (clave!=null){
            Toast.makeText(this,"Su clave es: "+clave,Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Usuario Incorrecto",Toast.LENGTH_SHORT).show();
        }
    }

}
