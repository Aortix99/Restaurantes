package com.example.AppRestaurant.manager;

import com.example.AppRestaurant.dto.IngredienteDto;
import com.example.AppRestaurant.exception.ManagerEXception;

import java.util.List;

public interface IngredientesMgrInterface {
    public void save(IngredienteDto I) throws ManagerEXception;
    public void delete(int I)throws ManagerEXception;
    public List<IngredienteDto> selectall()throws  ManagerEXception;
}
