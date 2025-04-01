package com.library.api.domain.usuario;

import com.library.api.domain.libro.Libro;
import com.library.api.domain.persona.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Usuario extends Persona {

    private Stack<Libro> librosUsuario = new Stack<>();
    private String profesion;
    private boolean isEstudiante;

    //Constructor
    public Usuario(Long id, String nombres, String apellidos, int documento, boolean isAdmin, Long librosUsuario, String profesion, boolean isEstudiante){
        super(id, nombres, apellidos, documento, isAdmin);
        this.librosUsuario = new Stack<>();
        this.profesion = profesion;
        this.isEstudiante = isEstudiante;
    }

    //Getters y setters
    public Stack<Libro> getLibrosUsuario(){
        return librosUsuario;
    }
    public void setLibrosUsuario(Stack<Libro> librosUsuario){
        this.librosUsuario = librosUsuario;
    }
    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public boolean isEstudiante() {
        return isEstudiante;
    }

    public void setEstudiante(boolean estudiante) {
        isEstudiante = estudiante;
    }
}
