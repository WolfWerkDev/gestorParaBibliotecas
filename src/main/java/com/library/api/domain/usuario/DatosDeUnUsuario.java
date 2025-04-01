package com.library.api.domain.usuario;

import com.library.api.domain.libro.Libro;

import java.util.List;

public record DatosDeUnUsuario(Long id,
                               String nombres,
                               String apellidos,
                               List<Libro> librosUsuario) {
}
