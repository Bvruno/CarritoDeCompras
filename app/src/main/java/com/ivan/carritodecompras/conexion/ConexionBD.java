package com.ivan.carritodecompras.conexion;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

// PATRON SINGLETON PARA CONEXION A LA BASE DE DATOS
public class ConexionBD {

    private static ConexionBD instance=null;
    private static final  String url="jdbc:jtds:sqlserver://172.17.35.10:1433;databaseName=tienda;user=sa;password=123456";
    private static final String driver="net.sourceforge.jtds.jdbc.Driver";
    private static Connection con =null;

    private ConexionBD(){
        try {
            StrictMode.setThreadPolicy(politica());
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url);

        }catch (Exception ex) {
            System.out.println("Error de conexion :" + ex.getMessage());
            ex.printStackTrace();

        }
    }
    private StrictMode.ThreadPolicy politica(){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        return policy;
    }
    public static ConexionBD getInstance() {
        if(instance == null){
            instance = new ConexionBD();
        }
        return instance;
    }
    public Connection getCon() {
        return con;
    }
    public void cerraConexion(){
        instance = null;
    }
}
