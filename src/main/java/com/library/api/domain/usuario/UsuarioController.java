package com.library.api.domain.usuario;

import com.library.api.domain.persona.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = { "http://127.0.0.1:5500", "http://127.0.0.1:5500/frontend/usuario.js" })
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/ver-usuarios")
    public ResponseEntity<?> verUsuarios(){
        List<Persona> datos = usuarioService.mostrarUsuarios();
        DatosUsuarios usuarios = new DatosUsuarios(datos);

        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable Long id){
        Usuario usuario = usuarioService.obtenerUnUsuario(id);
        DatosDeUnUsuario datosDeUnUsuario = new DatosDeUnUsuario(usuario.getId(), usuario.getNombres(), usuario.getApellidos(), usuario.getLibrosUsuario());
        return ResponseEntity.ok(datosDeUnUsuario);
    }

    @PostMapping("/manage-books")
    public ResponseEntity<?> manejarLibros(@RequestBody DatosManejarLibros datosManejarLibros, UriComponentsBuilder uriComponentsBuilder){
        try {
            var accion = usuarioService.librosEnUso(datosManejarLibros.idLibro(), datosManejarLibros.idUser(), datosManejarLibros.accion());
            DatosPila datosPila = new DatosPila(accion);

            URI url = uriComponentsBuilder.path("/manage-books").buildAndExpand(datosPila).toUri();
            return ResponseEntity.created(url).body(datosPila);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e);
        }
    }
}
