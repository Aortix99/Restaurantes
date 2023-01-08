package com.example.AppRestaurant.dao;

import com.example.AppRestaurant.dto.RestauranteDto;
import com.example.AppRestaurant.exception.DaoEXception;

import java.util.List;

public interface RestauranteDaoInterface {
    public List<RestauranteDto> selectall()throws DaoEXception;
    public RestauranteDto SelectById(RestauranteDto R)throws DaoEXception;
    public void insert(RestauranteDto R)throws DaoEXception;
    public void update(RestauranteDto R)throws DaoEXception;
    public void delete(int i)throws DaoEXception;
}
