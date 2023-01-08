package com.example.AppRestaurant.dao;

import com.example.AppRestaurant.dto.IngredienteDto;
import com.example.AppRestaurant.exception.DaoEXception;

import java.util.List;

public interface IngredienteDaoInterface {
    public List<IngredienteDto> selectall()throws DaoEXception;
    public IngredienteDto SelectById(IngredienteDto I)throws DaoEXception;
    public void insert(IngredienteDto I)throws DaoEXception;
    public void update(IngredienteDto I)throws DaoEXception;
    public void delete(int i)throws DaoEXception;
}
