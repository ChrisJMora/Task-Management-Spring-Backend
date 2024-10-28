# Backend para Gestión de Tareas con Spring Boot y PostgreSQL

Este proyecto es una API RESTful creada con **Spring Boot** para gestionar tareas, permitiendo identificar tareas atrasadas en función de un rango de fechas. La base de datos utilizada es **PostgreSQL**, y el frontend está desarrollado en **Vue.js**. El proyecto utiliza **Maven** como gestor de dependencias.

## Descripción

La API permite realizar las siguientes operaciones sobre las tareas:
- Obtener todas las tareas.
- Obtener todas las tareas atrasadas en un rango de fechas especificado.

El frontend, desarrollado en **Vue.js**, interactúa con esta API para visualizar y gestionar la información de las tareas.

## Instalación

1. Clona este repositorio:
    ```bash
    git clone <URL_DEL_REPOSITORIO>
    ```

2. Navega al directorio del proyecto:
    ```bash
    cd <NOMBRE_DEL_PROYECTO>
    ```

3. Configura la conexión a la base de datos PostgreSQL en el archivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/<NOMBRE_DB>
    spring.datasource.username=<TU_USUARIO>
    spring.datasource.password=<TU_CONTRASEÑA>
    ```

4. Construye el proyecto con Maven:
    ```bash
    mvn clean install
    ```

5. Ejecuta la aplicación:
    ```bash
    mvn spring-boot:run
    ```

## Dependencias

- **Spring Boot** (Web, JPA, DevTools)
- **PostgreSQL Driver** para la base de datos
- **Vue.js** para el frontend
- **Maven** como gestor de dependencias

## Enlaces de la API

El backend está desplegado en Render y está disponible en el siguiente enlace:

- **Backend**: [https://task-management-spring-crud-api.onrender.com/api/tasks](https://task-management-spring-crud-api.onrender.com/api/tasks/all)

## Endpoints de la API

| Método HTTP | Endpoint                    | Descripción                                                      |
|-------------|-----------------------------|------------------------------------------------------------------|
| GET         | `/api/tasks/all`           | Obtener todas las tareas                                         |
| POST        | `/api/tasks/delayed`       | Obtener todas las tareas atrasadas dentro de un rango de fechas |
