package com.example.AppRestaurant.manager;

import com.example.AppRestaurant.dao.RestauranteDaoInterface;
import com.example.AppRestaurant.dto.RestauranteDto;
import com.example.AppRestaurant.exception.ManagerEXception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class RestauranteMgr implements RestauranteMgrInterface {

    @Autowired
    private RestauranteDaoInterface Dao;


    @Override
    public void save(RestauranteDto R) throws ManagerEXception {
    try{
        RestauranteDto tp = Dao.SelectById(R);
        if(tp==null){
            Dao.insert(R);
        }else{
            Dao.update(R);
        }
    }catch (Exception E){
        throw new ManagerEXception(E);
    }
    }

    @Override
    public void delete(int R) throws ManagerEXception {
    try{
        Dao.delete(R);
    }catch (Exception E){
        throw new ManagerEXception(E);
    }
    }

    @Override
    public List<RestauranteDto> selectall() throws ManagerEXception {
        try {
            return Dao.selectall();
        }catch (Exception E){
            throw new ManagerEXception(E);
        }
    }
}
