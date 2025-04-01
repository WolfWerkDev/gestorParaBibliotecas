package com.library.api.domain.libro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/inicio")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class LibroController {

    @Autowired
    private LibroService libroService;
/*
    @PostMapping("/registrar-libro")
    public ResponseEntity<?> registrarLibro(@RequestBody DatosRegistrarLibro datosRegistrarLibro, UriComponentsBuilder uriComponentsBuilder){
        try {
            Libro libro = libroService.registrarLibro(datosRegistrarLibro);

            DatosLibroRegistrado datosLibroRegistrado = new DatosLibroRegistrado(libro.getTitulo(), libro.isEnUso());
            URI url = uriComponentsBuilder.path("/registrar-libro/{id}").buildAndExpand(libro.getId()).toUri();
            System.out.println("Datos recibidos para registrar producto: " + datosRegistrarLibro);

            return ResponseEntity.created(url).body(datosLibroRegistrado);
        }catch (RuntimeException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
*/
    @GetMapping("lista-libros")
    public ResponseEntity<?> obtenerListaLibros(){
        List<Libro> listaLibros = libroService.obtenerListaLibros();
        ObtenerListaLibros lista = new ObtenerListaLibros(listaLibros);

        System.out.println("Lista libros: " + lista);
        return ResponseEntity.ok(lista);
    }
}
