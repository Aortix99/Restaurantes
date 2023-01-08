package com.example.AppRestaurant.facade;

import com.example.AppRestaurant.dto.IngredienteDto;
import com.example.AppRestaurant.exception.FacadeEXception;

import java.util.List;

public interface IngredienteFcdInterface {
    public void save(IngredienteDto I) throws FacadeEXception;
    public void delete(int I)throws FacadeEXception;
    public List<IngredienteDto> selectall()throws FacadeEXception;

}
