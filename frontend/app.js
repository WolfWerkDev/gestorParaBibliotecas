const apiUrl = 'http://localhost:8080'; // Cambia esto con la URL de tu API

// Función para obtener la lista de usuarios
async function fetchUsers() {
    try {
        // Hacer la petición al backend para obtener los usuarios
        const response = await fetch(`${apiUrl}/users/ver-usuarios`);
        
        if (!response.ok) {
            throw new Error('Error al obtener la lista de usuarios');
        }

        const data = await response.json();

        // Asegúrate de que los datos tengan la propiedad 'usuarios'
        if (data.usuarios) {
            const userList = document.getElementById('userList');
            userList.innerHTML = ''; // Limpia la lista antes de agregar nuevos elementos

            // Itera sobre los usuarios y genera los enlaces
            data.usuarios.forEach(function(user) {
                const li = document.createElement('li');
                const enlace = document.createElement('a'); // Crear un elemento de enlace

                enlace.textContent = `${user.nombres} ${user.apellidos} - ${user.profesion}`; // Establecer el texto del enlace
                enlace.href = `user.html?id=${user.id}`; // Redirigir a usuario.html con el ID del usuario

                li.appendChild(enlace); // Agregar el enlace al elemento de lista
                userList.appendChild(li);
            });
        } else {
            console.error('No se encontraron usuarios');
        }
    } catch (error) {
        console.error('Hubo un problema con la solicitud:', error);
    }
}

// Llamar la función cuando se cargue la página
document.addEventListener('DOMContentLoaded', fetchUsers);



// Llamamos a la función para obtener y mostrar los usuarios
document.addEventListener('DOMContentLoaded', fetchUsers);


// Función para obtener la lista de administradores
async function fetchAdmins() {
    const response = await fetch(`${apiUrl}/users/admin`);
    const data = await response.json();
    const adminList = document.getElementById('adminList');
    adminList.innerHTML = '';
    data.forEach(function(admin) {
        const li = document.createElement('li');
        li.textContent = admin;
        adminList.appendChild(li);
    });
}

// Función para obtener la lista de administradores
async function fetchAdmins() {
    const response = await fetch(`${apiUrl}/users/admin`);
    const data = await response.json();
    const adminList = document.getElementById('adminList');
    adminList.innerHTML = ''; // Limpiar la lista antes de agregar nuevos elementos
    // Acceder a la propiedad 'admins' y mostrar la información relevante
    data.admins.forEach(function(admin) {
        const li = document.createElement('li');
        li.textContent = `${admin.nombres} ${admin.apellidos} - ${admin.rol}, ${admin.dependencia}`;
        adminList.appendChild(li);
    });
}

// Llamamos a la función para obtener y mostrar los administradores
document.addEventListener('DOMContentLoaded', fetchAdmins);


// Función para obtener la lista de libros
async function fetchBooks() {
    const response = await fetch(`${apiUrl}/inicio/lista-libros`);
    const data = await response.json();
    const bookList = document.getElementById('bookList');
    bookList.innerHTML = ''; // Limpiar la lista antes de agregar nuevos elementos

    data.listaLibros.forEach(function(book) {
        const li = document.createElement('li');
    
        // Crear imagen de portada
        const img = document.createElement('img');
        img.src = book.url;
        img.alt = `Portada de ${book.titulo}`;
        img.style.width = "100px"; // Ajusta el tamaño de la imagen según necesites
        img.style.marginRight = "10px";
    
        // Crear el texto del libro
        const text = document.createElement('span');
        text.textContent = `${book.titulo} - Autor: ${book.autor} - Género: ${book.genero} - ${book.enUso ? 'En uso' : 'Disponible'}`;
    
        // Agregar elementos al 'li'
        li.appendChild(img);
        li.appendChild(text);
    
        // Agregar 'li' a la lista
        bookList.appendChild(li);
    });
    
}

// Llamamos a la función para obtener y mostrar los libros
document.addEventListener('DOMContentLoaded', fetchBooks);


// Función para eliminar todos los libros
async function clearBooks() {
    const response = await fetch(`${apiUrl}/books`, {
        method: 'DELETE'
    });
    if (response.ok) {
        fetchBooks(); // Actualizar la lista después de eliminar los libros
    }
}

// Manejo del formulario para agregar libro
const addBookForm = document.getElementById('addBookForm');
addBookForm.addEventListener('submit', function(e) {
    e.preventDefault();
    const bookName = document.getElementById('bookName').value;
    addBook(bookName);
});

// Manejo del botón para eliminar libros
const clearBooksBtn = document.getElementById('clearBooks');
clearBooksBtn.addEventListener('click', clearBooks);

// Inicialización
document.addEventListener('DOMContentLoaded', function() {
    fetchAdmins();
    fetchBooks();
});

function toggleList(id) {
    const list = document.getElementById(id);
    list.classList.toggle("hidden");
}
