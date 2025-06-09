package com.library.api.domain.grafo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrafoService {

    private final GrafoRecomendaciones grafo;

    public GrafoService(GrafoRecomendaciones grafo) {
        this.grafo = grafo;
    }

    @PostConstruct
    public void recomendacionService() {
        // Agregar relaciones usando los títulos directamente
        grafo.agregarRelacion("La Ilíada", "La Odisea", 5);
        grafo.agregarRelacion("Cien años de soledad", "Crónica de una muerte anunciada", 3);
    }

    public List<String> obtenerRecomendaciones(String libro, int topN) {
        return grafo.obtenerRecomendaciones(libro, topN);
    }
}
