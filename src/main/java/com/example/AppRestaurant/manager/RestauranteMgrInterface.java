package com.example.AppRestaurant.manager;

import com.example.AppRestaurant.dto.RestauranteDto;
import com.example.AppRestaurant.exception.ManagerEXception;

import java.util.List;

public interface RestauranteMgrInterface {
    public void save(RestauranteDto R) throws ManagerEXception;
    public void delete(int R)throws ManagerEXception;
    public List<RestauranteDto> selectall()throws  ManagerEXception;
}
