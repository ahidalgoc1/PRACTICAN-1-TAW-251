# PRACTICAN-1-TAW-251
# Proyecto de Gestión de Estudiantes con Spring Boot

## Descripción

Este es un proyecto de **gestión de estudiantes** desarrollado con **Spring Boot**. La API permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre estudiantes en una universidad. Los datos de los estudiantes son almacenados en memoria utilizando un repositorio en memoria (usando `ConcurrentHashMap`). El proyecto está diseñado para proporcionar un ejemplo simple de un CRUD utilizando Spring Boot.

### Características principales:
- **Crear** un nuevo estudiante.
- **Leer** todos los estudiantes o un estudiante específico por ID.
- **Actualizar** la información de un estudiante existente.
- **Eliminar** un estudiante por su ID.

## Tecnologías Utilizadas

- **Spring Boot** - Framework para crear aplicaciones Java con configuración automática.
- **Java 11+** - Lenguaje de programación utilizado para el desarrollo.
- **Spring Web** - Para manejar las solicitudes HTTP.
- **Spring Data** - Para acceder a los datos (aunque en este caso usamos un repositorio en memoria).
- **Postman** - Herramienta para probar los endpoints de la API.

## Endpoints de la API

### 1. **Obtener todos los estudiantes**
- **URL:** `/api/estudiantes`
- **Método:** `GET`
- **Descripción:** Obtiene una lista de todos los estudiantes.
- **Respuesta:**
  - **Código 200 OK**

### 2. **Obtener un estudiante por ID**
- **URL:** `/api/estudiantes/{id}`
- **Método:** `GET`
- **Descripción:** Obtiene un estudiante específico mediante su ID.
- **Respuesta:**
  - **Código 200 OK** si el estudiante es encontrado.
  - **Código 404 Not Found** si el estudiante no existe.

### 3. **Crear un nuevo estudiante**
- **URL:** `/api/estudiantes`
- **Método:** `POST`
- **Descripción:** Crea un nuevo estudiante con los datos proporcionados.
- **Respuesta:**
  - **Código 201 Created**

### 4. **Actualizar un estudiante**
- **URL:** `/api/estudiantes/{id}`
- **Método:** `PUT`
- **Descripción:** Actualiza los datos de un estudiante existente con los datos proporcionados.
- **Respuesta:**
  - **Código 200 OK** si el estudiante es actualizado exitosamente.
  - **Código 404 Not Found** si el estudiante no existe.

### 5. **Eliminar un estudiante**
- **URL:** `/api/estudiantes/{id}`
- **Método:** `DELETE`
- **Descripción:** Elimina un estudiante mediante su ID.
- **Respuesta:**
  - **Código 204 No Content** si el estudiante es eliminado exitosamente.
  - **Código 404 Not Found** si el estudiante no existe.
