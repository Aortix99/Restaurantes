package com.example.AppRestaurant.manager;

import com.example.AppRestaurant.dao.IngredienteDaoInterface;
import com.example.AppRestaurant.dto.IngredienteDto;
import com.example.AppRestaurant.exception.ManagerEXception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class IngredientesMgr implements IngredientesMgrInterface{
    @Autowired
    private IngredienteDaoInterface Dao;

    @Override
    public void save(IngredienteDto I) throws ManagerEXception {
    try{
        IngredienteDto tp=Dao.SelectById(I);
        if(tp==null){
            Dao.insert(I);
        }else{
            Dao.update(I);
        }
    }catch (Exception E){
        throw new ManagerEXception(E);
    }
    }

    @Override
    public void delete(int I) throws ManagerEXception {
        try{
            Dao.delete(I);
        }catch (Exception E){
            throw new ManagerEXception(E);
        }
    }

    @Override
    public List<IngredienteDto> selectall() throws ManagerEXception {
        try{
        return Dao.selectall();
        }catch (Exception E){
            throw new ManagerEXception(E);
        }
    }
}
