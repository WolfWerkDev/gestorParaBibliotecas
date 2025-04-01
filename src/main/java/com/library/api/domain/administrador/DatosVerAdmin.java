package com.library.api.domain.administrador;

import com.library.api.domain.persona.Persona;

import java.util.List;

public record DatosVerAdmin(List<Persona> admins) {
}
