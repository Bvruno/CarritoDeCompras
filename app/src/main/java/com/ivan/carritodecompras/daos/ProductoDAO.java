package com.ivan.carritodecompras.daos;

import com.ivan.carritodecompras.conexion.ConexionBD;
import com.ivan.carritodecompras.dtos.Producto;
import com.ivan.carritodecompras.interfaces.OperacionesBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoDAO implements OperacionesBD<Producto> {
    private static PreparedStatement pstm;
    private static ResultSet res;
    private static ConexionBD con=ConexionBD.getInstance();
    @Override
    public boolean insert(Producto producto) {
        return false;
    }

    @Override
    public boolean delee(Object id) {
        boolean result = false;
        String sql_delete = "delete from producto where id=?";
        try{
            pstm = con.getCon().prepareStatement(sql_delete);
            pstm.setInt(1,Integer.parseInt(id.toString()));
            if(pstm.executeUpdate()>0){
                return true;
            }
        }catch (Exception ex){
            System.out.print("Error al eliminar"+ex.getMessage());
            ex.printStackTrace();
        }finally {
            try {
                if(res!=null)res.close();
                if(pstm!=null)pstm.close();
                if(con!=null)con.cerraConexion();
            }catch (Exception ex){
            }
        }return result;
    }

    @Override
    public boolean update(Producto producto) {
        boolean result = false;
        String sql_update = "update producto set nombre=?,categoria=?,precio=?,stock=?";
        try{
            pstm = con.getCon().prepareStatement(sql_update);
            pstm.setString(1,producto.getNombre());
            pstm.setInt(2,producto.getCategoria());
            pstm.setDouble(3,producto.getPrecio());
            pstm.setInt(4,producto.getStock());
        }catch (Exception ex){
            System.out.print("Error al actualizar"+ex.getMessage());
            ex.printStackTrace();

        }finally {
            try {
                if(res!=null)res.close();
                if(pstm!=null)pstm.close();
                if(con!=null)con.cerraConexion();
            }catch (Exception ex){
            }
        }return result;
    }

    @Override
    public Producto selectById(Object id) {
        Producto producto = null;
        String sql_selectById = "select * from usuario where id=?";
        try{
            pstm = con.getCon().prepareStatement(sql_selectById);
            pstm.setInt(1,Integer.parseInt(id.toString()));
            pstm.executeQuery();
        }catch(Exception ex){
            System.out.println("error al seleccionar: "+ex.getMessage());
        }finally {
            try {
                if(res!=null)res.close();
                if(pstm!=null)pstm.close();
                if(con!=null)con.cerraConexion();
            }catch (Exception ex){
            }

        }return producto;
    }

    @Override
    public ArrayList<Producto> selectAll() {
        ArrayList<Producto> productos = new ArrayList<>();
        String sql_selectAll  ="select * from producto";
        try{
            pstm = con.getCon().prepareStatement(sql_selectAll);
            res = pstm.executeQuery();
            while (res.next()){
                productos.add(new Producto(
                        res.getInt(1),res.getString(2),res.getInt(3),res.getInt(4),res.getDouble(5)
                ));
            }
        }catch (Exception ex){
            System.out.print("Error al seleccionar"+ex.getMessage());
            ex.printStackTrace();
        }finally {
            try {
                if(res!=null)res.close();
                if(pstm!=null)pstm.close();
                if(con!=null)con.cerraConexion();
            }catch (Exception ex){
            }
        }
        return productos;
    }

}
