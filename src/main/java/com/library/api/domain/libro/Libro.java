package com.library.api.domain.libro;

public class Libro {

    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private boolean isEnUso;
    private String url;

    //Constructor
    public Libro(Long id, String titulo, String autor, String genero, boolean isEnUso, String url) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.isEnUso = isEnUso;
        this.url = url;
    }


    //Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isEnUso() {
        return isEnUso;
    }

    public void setEnUso(boolean enUso) {
        isEnUso = enUso;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
