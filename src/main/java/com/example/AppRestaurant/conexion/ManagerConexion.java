package com.example.AppRestaurant.conexion;

import java.sql.Connection;
import java.sql.SQLException;

public class ManagerConexion {

    private static ManagerConexion instance;
    private Conexion conexion;

    private ManagerConexion (){
        conexion=new Conexion();
    }
    public static ManagerConexion getInstance(){
        if(instance==null){
            instance=new ManagerConexion();
             }
          return instance;
    }
    public void open(){
     conexion.conect();
    }
    public void commit(){
        try {
            conexion.getconexion().commit();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public void rollback(){
        try {
            conexion.getconexion().rollback();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void close(){
        try {
            conexion.getconexion().close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public Connection getConnection(){
        return conexion.getCon();
    }
}
