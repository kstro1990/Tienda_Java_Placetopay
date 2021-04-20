#  Integración Prueba Placetopay Java

### **Autor:** Luis Castro 
versión: 1.0 

### Backend
- Este proyecto esta realizado con Java JDK 11 con el ** framework spring boot**  <version>2.4.4</version>
- Mave 4.0.0
- base de datos mySQL

### Froend 
-El froend esta realizado en con el **framework vue.js** 3.0
-Libreria **Primevue** 3.3.5


# Instalación

- Crear la base de datos : `deploy_tienda_java`

```sql
    CREATE DATABASE IF NOT EXISTS `deploy_tienda_java` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
    USE `deploy_tienda_java`;
```

------------

- Ejecutar el proyecto Java que se encuentra en la carpeta `pruebas` se recomienda utilizar el IDE **Eclipse** con la herramienta **spring tools suite 4**.

------------
**Ingresar a la Carpeta:** ` \pruebas\src\main\resources`

Configurar el archivo `application.properties` este contine la configuracion para el proyecto de Java. 

    spring.jpa.database=MYSQL
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://127.0.0.1:3306/deploy_tienda_java
    spring.datasource.username= USUARIO BASE DE DATO
    spring.datasource.password= CONTRASEÑA  BASE DE DATO

Agregar la el Archivo .env que fue compartido.

------------

* Una vez creadas las entidasdes en la base de datos agregar el producto con el siguiente Script

```sql
INSERT INTO `products` (`id`, `category`, `description`, `imagen`, `price`, `quantity`, `rating`, `reference`, `status`) VALUES
(2, 'Zapatos', 'cualquiera', 'https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80', 12.3, 0, 0, 'numero 1', 'ACTIVE'),
(3, 'Zapatos', 'cualquiera', 'https://images.unsplash.com/photo-1551107696-a4b0c5a0d9a2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80', 25, 0, 0, 'numero 2', 'ACTIVE'),
(4, 'Zapatos', 'cualquiera', 'https://images.unsplash.com/photo-1583979365152-173a8f14181b?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80', 60.2, 0, 0, 'numero 3', 'ACTIVE');

```

------------

###  Para ejecuatar el el Backend
Ejecutar el proyecto --> Run As --> Spring Boot App

------------

### Para instalar el Froend 

**Ingresar a la carpeta `/froned`**
Ejecutar el siguiente comando por terminal: 

`npm install `

Despuest de la instalación ejecutar 

`npm run serve`
