package com.SERVER_CONTROLLER.CONTROLLER.model;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.socket.WebSocketSession;

public class Medico {
    String nombre;
    String consultorio;
    String especialidad;
    String estado="libre";
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getConsultorio() {
        return consultorio;
    }
    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    } 
    
    
}
