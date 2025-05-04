package com.library.api.domain.libro;

import com.library.api.DataLoader;
import com.library.api.domain.trie.Trie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    private DataLoader dataLoader;
    @Autowired
    private Trie trie;

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

    public LibroService(Trie trie, DataLoader dataLoader) {
        this.trie = trie;
        this.listaLibros = dataLoader.verLibros();  // Obtiene los libros desde el DataLoader
    }

    public List<Libro> buscarPorPrefijo(String prefijo) {
        // Filtra los libros por título, autor o cualquier campo que necesites
        return listaLibros.stream()
                .filter(libro -> libro.getTitulo().toLowerCase().startsWith(prefijo.toLowerCase()))
                .collect(Collectors.toList());
    }

}
