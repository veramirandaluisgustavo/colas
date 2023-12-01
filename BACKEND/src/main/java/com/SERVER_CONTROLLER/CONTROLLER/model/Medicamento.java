package com.SERVER_CONTROLLER.CONTROLLER.model;

public class Medicamento {
    
    private String codigo;
    private String fecha_caducidad;
    private String nombre;
    private float precio;



    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getFecha_caducidad() {
        return fecha_caducidad;
    }
    public void setFecha_caducidad(String fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public Medicamento(String codigo, String fecha_caducidad, String nombre, float precio) {
        this.codigo = codigo;
        this.fecha_caducidad = fecha_caducidad;
        this.nombre = nombre;
        this.precio = precio;
    }
    

}
