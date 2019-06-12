package com.ivan.carritodecompras.daos;

import com.ivan.carritodecompras.conexion.ConexionBD;
import com.ivan.carritodecompras.dtos.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    private static final String sql_insert="insert into usuario values(?,?,?,?)";
    private static final String sql_login="select * from usuario where correo=? and clave=?";
    private static final String sql_clave="select clave from usuario where correo=?";
    private static PreparedStatement pstm;
    private static ResultSet res;
    private static ConexionBD con=ConexionBD.getInstance();

    public boolean login(Usuario usuario){
        boolean result=false;
        try {
            pstm = con.getCon().prepareStatement(sql_login);
            pstm.setString(1,usuario.getCorreo());
            pstm.setString(2,usuario.getClave());
            res=pstm.executeQuery();
            if (res.next()){
                result=true;
            }
        }catch (Exception ex){
            System.out.println("Error login"+ex.getMessage());
            ex.printStackTrace();
        }
        finally {
            try {
                if(res!=null)res.close();
                if(pstm!=null)pstm.close();
                if(con!=null)con.cerraConexion();
            }catch (Exception ex){
            }
        }
        return  result;

    }
    public boolean insertUser(Usuario usuario){
        boolean result=false;
        try{
            pstm=con.getCon().prepareStatement(sql_insert);
            pstm.setString(1,usuario.getCorreo());
            pstm.setString(2,usuario.getClave());
            pstm.setString(3,usuario.getPregunta());
            pstm.setString(4,usuario.getRespuesta());

            if(pstm.executeUpdate()>0){
                result = true;
            }
        }catch (Exception e){
            System.out.println("Error al insertar "+e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                if(pstm!=null)pstm.close();
                if(con!=null)con.cerraConexion();
            }catch (Exception ex){

            }finally {
                return result;
            }
        }
    }
    public String verClave(Usuario usuario){
        String result=null;
        try {
            pstm = con.getCon().prepareStatement(sql_clave);
            pstm.setString(1,usuario.getCorreo());
            res=pstm.executeQuery();
            if (res.next()){
                result=res.getString(1);
            }
        }catch (Exception ex){
            System.out.println("Error usuario"+ex.getMessage());
            ex.printStackTrace();
        }
        finally {
            try {
                if(res!=null)res.close();
                if(pstm!=null)pstm.close();
                if(con!=null)con.cerraConexion();
            }catch (Exception ex){
            }
        }
        return  result;

    }


}
