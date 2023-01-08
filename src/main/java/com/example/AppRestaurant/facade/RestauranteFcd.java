package com.example.AppRestaurant.facade;

import com.example.AppRestaurant.conexion.ManagerConexion;
import com.example.AppRestaurant.dto.RestauranteDto;
import com.example.AppRestaurant.exception.FacadeEXception;
import com.example.AppRestaurant.manager.RestauranteMgrInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestauranteFcd implements  RestauranteFcdInterface{

@Autowired
private RestauranteMgrInterface Mgr;

    @Override
    public void save(RestauranteDto R) throws FacadeEXception {
        try {
            ManagerConexion.getInstance().open();
            Mgr.save(R);
            ManagerConexion.getInstance().commit();

        }catch (Exception E){

            ManagerConexion.getInstance().rollback();
            throw new FacadeEXception(E);

        }finally {
            ManagerConexion.getInstance().close();
        }
    }

    @Override
    public void delete(int I) throws FacadeEXception {
        try {
            ManagerConexion.getInstance().open();
            Mgr.delete(I);
            ManagerConexion.getInstance().commit();

        }catch (Exception E){

            throw new FacadeEXception(E);
        }finally {
            ManagerConexion.getInstance().close();
        }
    }


    @Override
    public List<RestauranteDto> selectall() throws FacadeEXception {
        try {
            ManagerConexion.getInstance().open();
            return Mgr.selectall();

        }catch (Exception E){
            throw new FacadeEXception(E);
        }finally {
            ManagerConexion.getInstance().close();
        }
    }
}

