# API con Autenticación JWT

Este proyecto es una API RESTful construida con Spring Boot que implementa autenticación basada en JSON Web Tokens (JWT). La API permite gestionar productos y categorías, proporcionando un sistema de seguridad que protege los endpoints mediante autenticación. La base de datos se llama postgres(para tener en cuenta) y con total sinceridad, me enteré tarde de la prueba pero la realicé al final.

Hay que hacer la petición de login para que se te devuelva el token de autenticación, luego ya se puede realizar las demas peticiones.

La estructura del proyecto es la siguiente:

El puerto por el que se inicia el aplicativo es 2223.

La base de datos es PostgreSQL y está alojada en supabase.

## Estructura del Proyecto

El proyecto está organizado en los siguientes módulos y carpetas:

- **`src/main/java/com/nexsy/config`**: Contiene la configuración de seguridad y otros componentes de configuración.
  - `SecurityConfig.java`: Configuración de seguridad de la API, incluyendo autenticación y autorización.
  
- **`src/main/java/com/nexsy/controller`**: Contiene los controladores que manejan las solicitudes HTTP.
  - `AuthController.java`: Controlador para la autenticación y generación de tokens JWT.
  
- **`src/main/java/com/nexsy/service`**: Contiene la lógica de negocio.
  - `ProductServiceImpl.java`: Implementación de servicios para la gestión de objetos.
  
- **`src/main/java/com/nexsy/repository`**: Contiene las interfaces de repositorio para acceder a la base de datos.
  - `ProductRepository.java`: Repositorio para la gestión de objetos en la base de datos.
  
- **`src/main/java/com/nexsy/model`**: Contiene las clases de modelo que representan las entidades del sistema.
  - `Product.java`: Modelo que representa un producto.
  
- **`src/main/java/com/nexsy/util`**: Contiene utilidades y herramientas auxiliares.
  - `JwtUtil.java`: Utilidad para la generación y validación de tokens JWT.

- **`src/main/resources`**: Contiene archivos de configuración y recursos.
  - `application.properties`: Configuración de la aplicación, incluyendo datos de conexión a la base de datos y propiedades de seguridad.

- **`src/test/java`**: Contiene pruebas unitarias y de integración para la aplicación (No alcancé a desarrollar las pruebas).

## Características

- **Gestión de Productos**: CRUD para productos, incluyendo atributos como nombre, precio, descripción, URL de imagen y categoría.
- **Autenticación JWT**: Proceso de autenticación utilizando tokens JWT para asegurar los endpoints.
- **Seguridad**: Los endpoints están protegidos y requieren un token JWT válido para acceder, excepto el endpoint de inicio de sesión.

## Estructura del Proyecto

- **`SecurityConfig`**: Configuración de seguridad que permite el acceso al endpoint de login y protege los demás endpoints.
- **`JwtRequestFilter`**: Filtro que intercepta las solicitudes para verificar la validez del token JWT.
- **`AuthController`**: Controlador que maneja la autenticación y generación de tokens JWT.
- **`JwtUtil`**: Utilidad que proporciona métodos para generar y validar tokens JWT.

## Cómo Usar

1. **Iniciar el Servidor**: Clona este repositorio y ejecuta la aplicación Spring Boot.
2. **Obtener un Token**:
   - Realiza una solicitud POST al endpoint `/auth/login` con las credenciales del usuario en el cuerpo de la solicitud:
     ```json
     {
       "username": "usuarioEjemplo",
       "password": "contraseñaEjemplo"
     }
     ```
   - Si las credenciales son válidas, recibirás un token JWT.
3. **Acceder a Endpoints Protegidos**:
   - Usa el token obtenido en el encabezado `Authorization` de tus solicitudes a los demás endpoints:
     ```
     Authorization: Bearer <tu_token_jwt>
     ```
   - Por ejemplo, para crear un nuevo producto, realiza una solicitud POST a `/nexsys/v1/products` con el token en los encabezados y el cuerpo correspondiente.

## Ejemplo de Uso

### Login

```bash
POST /auth/login
Content-Type: application/json

{
  "username": "usuarioEjemplo",
  "password": "contraseñaEjemplo"
}
 ```

## Crear Producto

  - Realiza una solicitud POST al endpoint `/nexsys/v1/product`
     ```json
     {
    "name": "Nombre del producto",
    "priceFinal": 39,
    "description": "Descripción del producto.",
    "categoryId": 1,
    "imageUrl": "prueba"
} ```

## Listar Productos

  - Realiza una solicitud GET al endpoint `/nexsys/v1/products`


## Listar Categorias

  - Realiza una solicitud GET al endpoint `/nexsys/v1/categories`
 
```

