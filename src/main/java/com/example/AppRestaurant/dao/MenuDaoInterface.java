package com.example.AppRestaurant.dao;

import com.example.AppRestaurant.dto.MenuDto;
import com.example.AppRestaurant.exception.DaoEXception;

import java.util.List;

public interface MenuDaoInterface {
    public List<MenuDto> selectall()throws DaoEXception;
    public MenuDto SelectById(MenuDto M)throws DaoEXception;
    public void insert(MenuDto M)throws DaoEXception;
    public void update(MenuDto M)throws DaoEXception;
    public void delete(int i)throws DaoEXception;
}
