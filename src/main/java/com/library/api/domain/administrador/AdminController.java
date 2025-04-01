package com.library.api.domain.administrador;

import com.library.api.domain.persona.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public ResponseEntity<?> usuariosAdmin(){
        List<Persona> datos = adminService.mostrarAdmin();
        DatosVerAdmin admins = new DatosVerAdmin(datos);

        return ResponseEntity.ok(admins);
    }
}
