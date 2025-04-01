package com.library.api.domain.administrador;

import com.library.api.domain.persona.Persona;

public class Administrador extends Persona {

    private String rol;
    private String dependencia;
    private int experienciaEnMeses;

    //Constructor
    public Administrador(Long id, String nombres, String apellidos, int documento, boolean isAdmin, String rol, String dependencia, int experienciaEnMeses){
        super(id, nombres, apellidos, documento, isAdmin);
        this.rol = rol;
        this.dependencia = dependencia;
        this.experienciaEnMeses = experienciaEnMeses;
    }

    //Getters y setters

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public int getExperienciaEnMeses() {
        return experienciaEnMeses;
    }

    public void setExperienciaEnMeses(int experienciaEnMeses) {
        this.experienciaEnMeses = experienciaEnMeses;
    }
}
