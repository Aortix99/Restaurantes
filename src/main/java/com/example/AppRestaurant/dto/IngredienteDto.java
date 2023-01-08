package com.example.AppRestaurant.dto;

public class IngredienteDto {
    private int Id;
    private int id_menu;
    private String Nombre;
    private int Calorias;

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCalorias() {
        return Calorias;
    }

    public void setCalorias(int calorias) {
        Calorias = calorias;
    }
}
