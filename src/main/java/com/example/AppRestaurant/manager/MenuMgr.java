package com.example.AppRestaurant.manager;

import com.example.AppRestaurant.dao.MenuDaoInterface;
import com.example.AppRestaurant.dto.MenuDto;
import com.example.AppRestaurant.exception.ManagerEXception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MenuMgr implements MenuMgrInterface{
    @Autowired
    private MenuDaoInterface Dao;

    @Override
    public void save(MenuDto M) throws ManagerEXception {
    try{
        MenuDto tp=Dao.SelectById(M);
        if(tp==null){
            Dao.insert(M);
        }else {
            Dao.update(M);
        }
    }catch (Exception E){
        throw new ManagerEXception(E);
    }
    }

    @Override
    public void delete(int M) throws ManagerEXception {
        try{
            Dao.delete(M);
        }catch (Exception E){
            throw new ManagerEXception(E);
        }
    }

    @Override
    public List<MenuDto> selectall() throws ManagerEXception {
        try{
            return Dao.selectall();
        }catch (Exception E){
            throw new ManagerEXception(E);
        }
    }
}
