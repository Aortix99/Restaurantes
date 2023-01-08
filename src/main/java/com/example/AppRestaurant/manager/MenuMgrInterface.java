package com.example.AppRestaurant.manager;

import com.example.AppRestaurant.dto.MenuDto;
import com.example.AppRestaurant.exception.ManagerEXception;

import java.util.List;

public interface MenuMgrInterface {
    public void save(MenuDto M) throws ManagerEXception;
    public void delete(int M)throws ManagerEXception;
    public List<MenuDto> selectall()throws  ManagerEXception;
}
