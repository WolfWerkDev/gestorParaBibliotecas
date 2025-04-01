package com.library.api.domain.usuario;

public record DatosManejarLibros(Long idLibro,
                                 Long idUser,
                                 String accion) {
}
