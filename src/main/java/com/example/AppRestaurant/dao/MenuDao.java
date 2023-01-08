package com.example.AppRestaurant.dao;

import com.example.AppRestaurant.conexion.ManagerConexion;
import com.example.AppRestaurant.dto.MenuDto;
import com.example.AppRestaurant.exception.DaoEXception;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class MenuDao implements MenuDaoInterface{

    @Override
    public List<MenuDto> selectall() throws DaoEXception {
        List<MenuDto> list=new ArrayList<>();
        String Select="SELECT id, id_restaurante, tipo_menu, nombre, precio FROM menu";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        MenuDto almacena=null;

        Connection connection= ManagerConexion.getInstance().getConnection();
        try{
        statement=connection.prepareStatement(Select);
        resultSet=statement.executeQuery();
        while (resultSet.next()){
            almacena=new MenuDto();
            almacena.setId(resultSet.getInt("id"));
            almacena.setIdRestaurante(resultSet.getInt("id_restaurante"));
            almacena.setTipoDeMenu(resultSet.getInt("tipo_menu"));
            almacena.setNombreM(resultSet.getString("nombre"));
            almacena.setPrecio(resultSet.getFloat("precio"));
            list.add(almacena);
        }
        return list;
        }catch (Exception e){
            throw new DaoEXception(e);
        }

    }

    @Override
    public MenuDto SelectById(MenuDto M) throws DaoEXception {
        String SQL="SELECT id, razon_social, nombre_comercial, tipo_restaurante, ciudad, hora_apertura, hora_cierre FROM restaurante WHERE id=?";
        PreparedStatement statement =null;
        ResultSet resultSet= null;
        MenuDto almacena=null;

        Connection connection=ManagerConexion.getInstance().getConnection();

        try {

            statement=connection.prepareStatement(SQL);
            statement.setInt(1,M.getId());
            resultSet= statement.executeQuery();
            while (resultSet.next()){
                almacena =new MenuDto();
                almacena.setId(resultSet.getInt("id"));
                almacena.setTipoDeMenu(resultSet.getInt("tipo_menu"));
                almacena.setNombreM(resultSet.getString("nombre"));
                almacena.setPrecio(resultSet.getFloat("precio"));

            }

            return almacena;

        }catch (Exception Ex){
            throw  new DaoEXception(Ex);
        }finally {
            try {
                statement.close();
                resultSet.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void insert(MenuDto M) throws DaoEXception {
        String insert = "INSERT INTO menu(id, id_restaurante, tipo_menu, nombre, precio) VALUES (?,?,?,?,?)";
        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(insert);
            statement.setInt(1, M.getId());
            statement.setInt(2, M.getIdRestaurante());
            statement.setInt(3, M.getTipoDeMenu());
            statement.setString(4, M.getNombreM());
            statement.setFloat(5, M.getPrecio());
            statement.executeUpdate();

        } catch (Exception Ex) {
            throw new DaoEXception(Ex);
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(MenuDto M) throws DaoEXception {
        String Update = "UPDATE menu SET id_restaurante=?, tipo_menu=?, nombre=?, precio=? WHERE id=?";
        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(Update);

            statement.setInt(1, M.getIdRestaurante());
            statement.setInt(2, M.getTipoDeMenu());
            statement.setString(3, M.getNombreM());
            statement.setFloat(4, M.getPrecio());
            statement.setInt(5, M.getId());
            statement.executeUpdate();

        } catch (Exception Ex) {
            throw new DaoEXception(Ex);
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int i) throws DaoEXception {
        String Delete="DELETE FROM menu WHERE id=?";
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
