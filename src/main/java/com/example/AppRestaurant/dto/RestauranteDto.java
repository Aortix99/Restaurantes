package com.example.AppRestaurant.dto;

public class RestauranteDto {
   private int id;
   private String RazonSocial;
   private String NombreComercial;
   private int TipoRestaurante;
   private String CiudadU;
   private String HoraC;
   private String HoraA;


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getRazonSocial() {
      return RazonSocial;
   }

   public void setRazonSocial(String razonSocial) {
      RazonSocial = razonSocial;
   }

   public String getNombreComercial() {
      return NombreComercial;
   }

   public void setNombreComercial(String nombreComercial) {
      NombreComercial = nombreComercial;
   }

   public int getTipoRestaurante() {
      return TipoRestaurante;
   }

   public void setTipoRestaurante(int tipoRestaurante) {
      TipoRestaurante = tipoRestaurante;
   }

   public String getCiudadU() {
      return CiudadU;
   }

   public void setCiudadU(String ciudadU) {
      CiudadU = ciudadU;
   }

   public String getHoraC() {
      return HoraC;
   }

   public void setHoraC(String horaC) {
      HoraC = horaC;
   }

   public String getHoraA() {
      return HoraA;
   }

   public void setHoraA(String horaA) {
      HoraA = horaA;
   }

}
