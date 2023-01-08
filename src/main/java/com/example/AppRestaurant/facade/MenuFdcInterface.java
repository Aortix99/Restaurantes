package com.example.AppRestaurant.facade;

import com.example.AppRestaurant.dto.MenuDto;
import com.example.AppRestaurant.exception.FacadeEXception;

import java.util.List;

public interface MenuFdcInterface {
    public void save(MenuDto M) throws FacadeEXception;
    public void delete(int I)throws FacadeEXception;
    public List<MenuDto> selectall()throws FacadeEXception;

}
