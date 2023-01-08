package com.example.AppRestaurant.dao;

import com.example.AppRestaurant.conexion.ManagerConexion;
import com.example.AppRestaurant.dto.IngredienteDto;
import com.example.AppRestaurant.dto.MenuDto;
import com.example.AppRestaurant.exception.DaoEXception;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Component

public class IngredienteDao implements IngredienteDaoInterface{
    @Override
    public List<IngredienteDto> selectall() throws DaoEXception {
        List<IngredienteDto> list=new ArrayList<>();
        String Select="SELECT id, id_menu, nombre, calorias FROM ingrediente";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        IngredienteDto almacena=null;

        Connection connection= ManagerConexion.getInstance().getConnection();
        try{
            statement=connection.prepareStatement(Select);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                almacena =new IngredienteDto();
                almacena.setId(resultSet.getInt("id"));
                almacena.setId_menu(resultSet.getInt("id_menu"));
                almacena.setNombre(resultSet.getString("nombre"));
                almacena.setCalorias(resultSet.getInt("calorias"));
                list.add(almacena);
            }
            return list;
        }catch (Exception e){
            throw new DaoEXception(e);
        }

    }
    @Override
    public IngredienteDto SelectById(IngredienteDto I) throws DaoEXception {
        String SQL="SELECT * FROM ingrediente WHERE id=?";
        ResultSet resultSet=null;
        PreparedStatement statement=null;
        IngredienteDto almacena=null;
        Connection connection=ManagerConexion.getInstance().getConnection();
        try {
            statement=connection.prepareStatement(SQL);
            statement.setInt(1,I.getId());
            resultSet= statement.executeQuery();
            while (resultSet.next()){
                almacena=new IngredienteDto();
                almacena.setId(resultSet.getInt("id"));
                almacena.setNombre(resultSet.getString("nombre"));
                almacena.setCalorias(resultSet.getInt("calorias"));

            }
            return almacena;
        }catch (Exception e){
            throw new DaoEXception(e);
        }finally {
            try {
                resultSet.close();
                statement.close();
            }catch (Exception E){
                E.printStackTrace();
            }
        }
    }

    @Override
    public void insert(IngredienteDto I) throws DaoEXception {

        String Insert="INSERT INTO ingrediente(id, id_menu, nombre, calorias) VALUES (?,?,?,?)";
        PreparedStatement statement=null;
        Connection connection=ManagerConexion.getInstance().getConnection();
        try{
            statement=connection.prepareStatement(Insert);
            statement.setInt(1,I.getId());
            statement.setInt(2, I.getId_menu());
            statement.setString(3,I.getNombre());
            statement.setInt(4, I.getCalorias());
            statement.executeUpdate();
        }catch (Exception e){
            throw new DaoEXception(e);
        }finally {
            try{
                statement.close();
            }catch (Exception Ex){
                Ex.printStackTrace();
            }

        }
    }

    @Override
    public void update(IngredienteDto I) throws DaoEXception {
    String UPdate="UPDATE ingrediente SET id_menu=?,nombre=?,calorias=? WHERE id=?";
    PreparedStatement statement=null;

    Connection connection=ManagerConexion.getInstance().getConnection();
    try{
        statement=connection.prepareStatement(UPdate);
        statement.setInt(1,I.getId_menu());
        statement.setString(2,I.getNombre());
        statement.setInt(3, I.getCalorias());
        statement.setInt(4,I.getId());
        statement.executeUpdate();

    }catch (Exception E){
        throw new DaoEXception(E);
    }finally {
        try{
            statement.close();
        }catch (Exception Ex){
            Ex.printStackTrace();
        }

    }

    }

    @Override
    public void delete(int i) throws DaoEXception {
        String Delete="DELETE FROM ingrediente WHERE id=?";
        PreparedStatement statement=null;
        Connection connection= ManagerConexion.getInstance().getConnection();
        try{
            statement=connection.prepareStatement(Delete);
            statement.setInt(1, i);
            statement.executeUpdate();
        }catch (Exception ex){
            throw new DaoEXception(ex);
        }finally {
            try{
                statement.close();

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }
}
