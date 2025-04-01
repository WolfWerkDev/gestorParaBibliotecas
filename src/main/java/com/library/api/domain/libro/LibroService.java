package com.library.api.domain.libro;

import com.library.api.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    private DataLoader dataLoader;

    private List<Libro> listaLibros = new ArrayList<>();
/*
    public Libro registrarLibro(DatosRegistrarLibro datosRegistrarLibro){
        Libro libro = new Libro(datosRegistrarLibro.id(), datosRegistrarLibro.titulo(), datosRegistrarLibro.autor(), datosRegistrarLibro.genero(), datosRegistrarLibro.isEnUso(), datosRegistrarLibro.u);

        listaLibros.add(libro);
        System.out.println("Lista libros: " + listaLibros);

        return libro;
    }*/

    public List<Libro> obtenerListaLibros(){
        return dataLoader.verLibros();
    }
}
