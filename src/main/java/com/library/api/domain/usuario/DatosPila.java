package com.library.api.domain.usuario;

import com.library.api.domain.libro.Libro;

import java.util.Stack;

public record DatosPila(Stack<Libro> pilaLibros) {
}
