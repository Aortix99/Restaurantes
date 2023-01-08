package com.example.AppRestaurant.facade;

import com.example.AppRestaurant.conexion.ManagerConexion;
import com.example.AppRestaurant.dto.IngredienteDto;
import com.example.AppRestaurant.exception.FacadeEXception;
import com.example.AppRestaurant.manager.IngredientesMgrInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class IngredienteFcd implements IngredienteFcdInterface{
    @Autowired
    private IngredientesMgrInterface Mgr;

    @Override
    public void save(IngredienteDto I) throws FacadeEXception {
    try{
        ManagerConexion.getInstance().open();
        Mgr.save(I);
        ManagerConexion.getInstance().commit();
    }catch (Exception e){
        ManagerConexion.getInstance().rollback();
        throw new FacadeEXception(e);
    }finally {
        ManagerConexion.getInstance().close();
    }
    }

    @Override
    public void delete(int I) throws FacadeEXception {
        try{
            ManagerConexion.getInstance().open();
            Mgr.delete(I);
            ManagerConexion.getInstance().commit();
        }catch (Exception e){
            throw new FacadeEXception(e);
        }finally {
            ManagerConexion.getInstance().close();
        }
    }

    @Override
    public List<IngredienteDto> selectall() throws FacadeEXception {
        try{
            ManagerConexion.getInstance().open();
            return Mgr.selectall();
        }catch (Exception e){
            throw new FacadeEXception(e);
        }finally {
            ManagerConexion.getInstance().close();
        }
    }
}
