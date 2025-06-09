package com.library.api.domain.grafo;

import com.library.api.DataLoader;
import com.library.api.domain.libro.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GrafoRecomendaciones {

    @Autowired
    private DataLoader dataLoader;

    private Map<String, Map<String, Integer>> grafo = new HashMap<>();

    public void agregarLibro(String libro) {
        Libro libro1 = dataLoader.libroPorTitulo(libro);
        if (libro1 == null) {
            System.out.println("El libro no fue encontrado: " + libro);
            return; // o puedes lanzar una excepción, dependiendo de tu lógica
        }
        System.out.println("Libro encontrado: " + libro1.getTitulo());
        grafo.putIfAbsent(libro1.getTitulo(), new HashMap<>());
    }


    public void agregarRelacion(String libro1, String libro2, int peso) {
        agregarLibro(libro1);
        agregarLibro(libro2);

        // Obtener los títulos normalizados que usa el grafo
        Libro l1 = dataLoader.libroPorTitulo(libro1);
        Libro l2 = dataLoader.libroPorTitulo(libro2);
        if (l1 == null || l2 == null) {
            System.out.println("No se pudo crear la relación, uno de los libros no existe.");
            return;
        }

        String titulo1 = l1.getTitulo();
        String titulo2 = l2.getTitulo();

        grafo.get(titulo1).put(titulo2, peso);
        grafo.get(titulo2).put(titulo1, peso);
    }


    public List<String> obtenerRecomendaciones(String libro, int topN){
        if (!grafo.containsKey(libro)) return Collections.emptyList();

        return grafo.get(libro).entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();

    }
}
