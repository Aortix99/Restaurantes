package com.example.AppRestaurant.facade;

import com.example.AppRestaurant.dto.RestauranteDto;
import com.example.AppRestaurant.exception.FacadeEXception;

import java.util.List;

public interface RestauranteFcdInterface {

    public void save(RestauranteDto R) throws FacadeEXception;
    public void delete(int I)throws FacadeEXception;
    public List<RestauranteDto> selectall()throws FacadeEXception;

}
