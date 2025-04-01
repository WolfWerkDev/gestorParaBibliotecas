const apiUrl = "http://localhost:8080"; // URL base del backend

// Obtener el ID del usuario desde la URL
const urlParams = new URLSearchParams(window.location.search);
const userId = urlParams.get("id");

// Función para obtener los datos del usuario y su lista de libros
async function fetchUserData() {
    try {
        if (!userId) {
            console.error("ID de usuario no encontrado en la URL");
            return;
        }

        const response = await fetch(`${apiUrl}/users/${userId}`);
        if (!response.ok) throw new Error("Error en la respuesta del servidor");

        const data = await response.json();
        document.getElementById("nombreUsuario").textContent = `${data.nombres} ${data.apellidos}`;
        //document.getElementById("profesionUsuario").textContent = data.profesion;

        // Mostrar la lista de libros del usuario
        const listaLibrosUsuario = document.getElementById("listaLibrosUsuario");
        listaLibrosUsuario.innerHTML = ""; // Limpiar antes de agregar elementos

        if (data.librosUsuario && data.librosUsuario.length > 0) {
            data.librosUsuario.forEach(libro => {
                const li = document.createElement("li");
                li.textContent = `${libro.titulo} - ${libro.autor} (${libro.genero})`;

                // Botón "Quitar"
                const btnQuitar = document.createElement("button");
                btnQuitar.textContent = "Quitar";
                btnQuitar.onclick = async () => {
                    await manejarLibro(libro.id, userId, "borrar");
                    location.reload(); // Recargar la página después de la acción
                };

                li.appendChild(btnQuitar);
                listaLibrosUsuario.appendChild(li);
            });
        } else {
            listaLibrosUsuario.textContent = "Este usuario no tiene libros en su lista.";
        }

    } catch (error) {
        console.error("Hubo un problema con la solicitud:", error);
    }
}

// Función para obtener la lista de libros disponibles
async function fetchBooks() {
    try {
        const response = await fetch(`${apiUrl}/inicio/lista-libros`);
        const data = await response.json();
        const bookList = document.getElementById('bookList');
        bookList.innerHTML = ''; // Limpiar la lista antes de agregar nuevos elementos

        data.listaLibros.forEach(book => {
            if (book.enUso) return; // Omitir libros que ya están en uso

            const li = document.createElement('li');
            li.textContent = `${book.titulo} - Autor: ${book.autor} - Género: ${book.genero}`;

            // Botón "Agregar"
            const btnAgregar = document.createElement("button");
            btnAgregar.textContent = "Agregar";
            btnAgregar.onclick = async () => {
                await manejarLibro(book.id, userId, "agregar");
                location.reload(); // Recargar la página después de la acción
            };

            li.appendChild(btnAgregar);
            bookList.appendChild(li);
        });
    } catch (error) {
        console.error("Error al obtener la lista de libros:", error);
    }
}

// Función para manejar la adición o eliminación de libros
async function manejarLibro(idLibro, idUser, accion) {
    try {
        const response = await fetch(`${apiUrl}/users/manage-books`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ idLibro, idUser, accion })
        });

        if (!response.ok) throw new Error("Error en la respuesta del servidor");

        console.log(`Libro ${accion} correctamente`);
    } catch (error) {
        console.error(`Error al ${accion} el libro:`, error);
    }
}

// Llamar a las funciones cuando se cargue la página
document.addEventListener('DOMContentLoaded', () => {
    fetchUserData();
    fetchBooks();
});
