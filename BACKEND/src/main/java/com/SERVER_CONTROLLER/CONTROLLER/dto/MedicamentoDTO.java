package com.SERVER_CONTROLLER.CONTROLLER.dto;

public class MedicamentoDTO {
    private String id;
    
    private String nombre;
    private String fecha_caducidad;
    private String codigo;
    private String caducidad;
    private String descripcion;
    private String dosis;
    private float precio;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFecha_caducidad() {
        return fecha_caducidad;
    }
    public void setFecha_caducidad(String fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCaducidad() {
        return caducidad;
    }
    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDosis() {
        return dosis;
    }
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }
    
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    


    
    
}
