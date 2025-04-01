package com.library.api.domain.administrador;

import com.library.api.DataLoader;
import com.library.api.domain.persona.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private DataLoader dataLoader;

    public List<Persona> mostrarAdmin(){
        return dataLoader.verAdmins();
    }
}
