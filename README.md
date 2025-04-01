![Spring Boot](https://user-images.githubusercontent.com/84719774/129191080-723b3b46-4e0b-4aa5-8eb9-654c2c025b18.png)
# Sistema de Gestión de Libros para Bibliotecas

## Descripción
Este es un sistema de gestión de libros para bibliotecas desarrollado como una **API RESTful** utilizando **Spring Boot**. El frontend está integrado dentro del mismo proyecto backend, utilizando **HTML, CSS y JavaScript**.

El sistema permite administrar usuarios, administradores y libros en una biblioteca, ofreciendo funcionalidades como consulta de libros, asignación de libros a usuarios y gestión de administradores.

## Características
✅ **API RESTful** construida con **Spring Boot**.
✅ **Frontend integrado** dentro del mismo backend usando **HTML, CSS y JavaScript**.
✅ **Gestión de usuarios** y **administradores**.
✅ **Gestión de libros** (consulta, asignación y eliminación).
✅ **Interfaz intuitiva** con listas de usuarios, administradores y libros.

## Tecnologías Utilizadas
- **Backend:** Spring Boot, Java
- **Frontend:** HTML, CSS, JavaScript (sin frameworks adicionales)

## Instalación y Configuración
1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/SammAPH/gestorParaBibliotecas.git
   cd gestorParaBibliotecas
   ```

2. **Compilar y ejecutar el backend**
   ```bash
   mvn spring-boot:run
   ```

3. **Acceder a la interfaz web**
   - Abre tu navegador y entra en `http://localhost:8080`

## Endpoints Principales
### 📌 Usuarios
- `GET /users/ver-usuarios` → Obtener la lista de usuarios
- `GET /users/{id}` → Obtener datos de un usuario por ID
- `POST /users/manage-books` → Agregar o quitar libros de un usuario

### 📌 Administradores
- `GET /users/admin` → Obtener la lista de administradores

### 📌 Libros
- `GET /inicio/lista-libros` → Obtener la lista de libros

## Funcionalidades del Frontend
- Mostrar lista de **usuarios** con enlaces a sus detalles.
- Mostrar lista de **administradores**.
- Mostrar lista de **libros disponibles** y permitir la asignación a usuarios.
- Interfaz interactiva para **agregar y eliminar libros**.

## Contribuciones
Si deseas contribuir al proyecto, puedes hacer un fork y enviar un pull request con mejoras o nuevas funcionalidades.

**Autor:** Samm& | [LinkedIn](www.linkedin.com/in/sammy-alejandro-pulido-huertas-554167260) | [GitHub](https://github.com/SammAPH)
¡Gracias por usar el sistema de gestión de libros para bibliotecas! 📚