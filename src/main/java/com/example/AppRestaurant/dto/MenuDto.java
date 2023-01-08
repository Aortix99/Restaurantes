package com.example.AppRestaurant.dto;

public class MenuDto {
    private int id;
    private int TipoDeMenu;
    private int IdRestaurante;
    private String NombreM;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRestaurante() {
        return IdRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        IdRestaurante = idRestaurante;
    }

    private IngredienteDto ingredienteDto;
    private float precio;

    public int getTipoDeMenu() {
        return TipoDeMenu;
    }

    public void setTipoDeMenu(int tipoDeMenu) {
        TipoDeMenu = tipoDeMenu;
    }

    public String getNombreM() {
        return NombreM;
    }

    public void setNombreM(String nombreM) {
        NombreM = nombreM;
    }

    public IngredienteDto getIngredienteDto() {
        return ingredienteDto;
    }

    public void setIngredienteDto(IngredienteDto ingredienteDto) {
        this.ingredienteDto = ingredienteDto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
