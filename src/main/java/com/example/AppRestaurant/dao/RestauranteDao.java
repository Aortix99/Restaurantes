package com.example.AppRestaurant.dao;

import com.example.AppRestaurant.conexion.ManagerConexion;
import com.example.AppRestaurant.dto.IngredienteDto;
import com.example.AppRestaurant.dto.RestauranteDto;
import com.example.AppRestaurant.exception.DaoEXception;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class RestauranteDao implements RestauranteDaoInterface{

    @Override
    public List<RestauranteDto> selectall() throws DaoEXception {
        List<RestauranteDto> list=new ArrayList<>();
        String Select="SELECT * FROM restaurante";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        RestauranteDto almacena=null;

        Connection connection= ManagerConexion.getInstance().getConnection();
        try{
            statement=connection.prepareStatement(Select);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                almacena=new RestauranteDto();
                almacena.setId(resultSet.getInt("id"));
                almacena.setRazonSocial(resultSet.getString("razon_social"));
                almacena.setNombreComercial(resultSet.getString("nombre_comercial"));
                almacena.setTipoRestaurante(resultSet.getInt("tipo_restaurante"));
                almacena.setCiudadU(resultSet.getString("ciudad"));
                almacena.setHoraA(resultSet.getString("hora_apertura"));
                almacena.setHoraC(resultSet.getString("hora_cierre"));
                list.add(almacena);
            }
            return list;
        }catch (Exception e){
            throw new DaoEXception(e);
        }

    }
    @Override
    public RestauranteDto SelectById(RestauranteDto R) throws DaoEXception {
        String SQL="SELECT * FROM restaurante WHERE id=?";
        PreparedStatement statement =null;
        ResultSet resultSet= null;
        RestauranteDto almacena=null;

        Connection connection=ManagerConexion.getInstance().getConnection();

      try {

            statement=connection.prepareStatement(SQL);
            statement.setInt(1,R.getId());
            resultSet= statement.executeQuery();
            while (resultSet.next()){
                almacena = new RestauranteDto();
                almacena.setRazonSocial(resultSet.getString("razon_social"));
                almacena.setNombreComercial(resultSet.getString("nombre_comercial"));
                almacena.setTipoRestaurante(resultSet.getInt(" tipo_restaurante"));
                almacena.setCiudadU(resultSet.getString("ciudad"));
                almacena.setHoraA(resultSet.getString("hora_apertura"));
                almacena.setHoraC(resultSet.getString("hora_cierre"));
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
    public void insert(RestauranteDto R) throws DaoEXception {
        String Insert = "INSERT INTO restaurante(id, razon_social, nombre_comercial, tipo_restaurante, ciudad, hora_apertura, hora_cierre) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(Insert);
            statement.setInt(1, R.getId());
            statement.setString(2, R.getRazonSocial());
            statement.setString(3, R.getNombreComercial());
            statement.setInt(4, R.getTipoRestaurante());
            statement.setString(5, R.getCiudadU());
            statement.setString(6, R.getHoraA());
            statement.setString(7, R.getHoraC());

            statement.executeUpdate();
        } catch (Exception e) {
            throw new DaoEXception(e);
        } finally {
            try {
                statement.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void update(RestauranteDto R) throws DaoEXception {
        String Update="UPDATE restaurante SET razon_social=?,nombre_comercial=?,tipo_restaurante=?,ciudad=?,hora_apertura=?,hora_cierre=? WHERE id=?";
        PreparedStatement statement=null;

        Connection connection= ManagerConexion.getInstance().getConnection();

        try {

            statement.setString(1, R.getRazonSocial());
            statement.setString(2, R.getNombreComercial());
            statement.setInt(3, R.getTipoRestaurante());
            statement.setString(4, R.getCiudadU());
            statement.setString(5, R.getHoraA());
            statement.setString(6, R.getHoraC());
            statement.setInt(7,R.getId());

        }catch (Exception Ex){
            throw new DaoEXception(Ex);
        }finally {
            try {
                statement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }

    @Override
    public void delete(int   i) throws DaoEXception {
        String Delete="DELETE FROM `restaurante` WHERE id=?";
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
