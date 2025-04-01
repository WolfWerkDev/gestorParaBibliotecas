package com.library.api.domain.libro;

public record DatosRegistrarLibro(
        Long id,
        String titulo,
        String autor,
        String genero,
        boolean isEnUso) {
}
