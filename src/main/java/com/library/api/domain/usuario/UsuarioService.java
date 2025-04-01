package com.library.api.domain.usuario;

import com.library.api.DataLoader;
import com.library.api.domain.libro.Libro;
import com.library.api.domain.persona.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private DataLoader dataLoader;

    private Stack<Libro> pilaLibros = new Stack<>();

    public List<Persona> mostrarUsuarios(){
        return dataLoader.verUsuarios();
    }

    public Usuario obtenerUnUsuario(Long id){
        Optional<Persona> usuario = dataLoader.verUsuarios().stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
        if (usuario.isPresent() && usuario.get() instanceof Usuario) {
            return (Usuario) usuario.get();
        }
        return null;
    }

    //idLibro para saber que libro es, idUser para identificar al usuario y accion para "leer" o "descartar"
    public Stack<Libro> librosEnUso(Long idLibro, Long idUser, String accion){

        if(accion.contains("agregar")){
            Optional<Libro> libroEncontrado = dataLoader.verLibros().stream()
                    .filter(l -> l.getId().equals(idLibro))
                    .findFirst();
            if (libroEncontrado.isPresent()){
                if (libroEncontrado.get().isEnUso()){
                    throw new RuntimeException("El libro ya está en uso.");
                }else {
                    pilaLibros.push(libroEncontrado.get());
                    libroEncontrado.get().setEnUso(true);

                    Optional<Persona> usuarioEncontrado = dataLoader.verUsuarios().stream()
                            .filter(u -> u.getId().equals(idUser))
                            .findFirst();
                    if (usuarioEncontrado.isPresent()){
                        Persona persona = usuarioEncontrado.get();
                        if (persona instanceof Usuario){
                            Usuario usuario = (Usuario) persona;
                            usuario.getLibrosUsuario().push(libroEncontrado.get());
                        }
                    }
                }
            }else {
                throw new RuntimeException("Libro no encontrado.");
            }
        }else if (accion.contains("borrar")) {
            if (!pilaLibros.isEmpty()) {
                Libro libro = pilaLibros.pop();
                libro.setEnUso(false); // Libera el libro para que pueda ser usado nuevamente

                // Remover el libro de la lista de libros del usuario
                Optional<Persona> usuarioEncontrado = dataLoader.verUsuarios().stream()
                        .filter(u -> u.getId().equals(idUser))
                        .findFirst();

                if (usuarioEncontrado.isPresent() && usuarioEncontrado.get() instanceof Usuario) {
                    Usuario usuario = (Usuario) usuarioEncontrado.get();
                    Stack<Libro> librosUsuario = usuario.getLibrosUsuario();
                    if (!librosUsuario.isEmpty()) {
                        librosUsuario.pop(); // Elimina el último libro de la pila del usuario
                    } else {
                        throw new RuntimeException("El usuario no tiene libros en su lista.");
                    }
                } else {
                    throw new RuntimeException("Usuario no encontrado o no es de tipo Usuario.");
                }
            } else {
                throw new RuntimeException("No hay libros en la pila para borrar.");
            }
        }


        return pilaLibros;
    }
}
