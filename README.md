# TP3 - Sistema de Gestión de Inventario

Este trabajo práctico implementa una solución de gestión de inventario que permite realizar operaciones CRUD sobre productos y categorías. La aplicación demuestra el uso de patrones de diseño DAO (Data Access Object) para separar la lógica de acceso a datos de la lógica de negocio, utilizando conexiones directas a MySQL y consultas preparadas.

## ⚠️ Nota Importante

**La estructura de la base de datos (tablas, índices y el procedimiento almacenado `sp_AgregarProducto`) NO fue realizada por el autor de este código porque fue proporcionada junto a la consigna del trabajo practico.**

CREATE DATABASE bdInventario;
USE bdInventario;

CREATE TABLE Categorias (
    IdCategoria int NOT NULL AUTO\_INCREMENT,
    Nombre varchar(45) NOT NULL,
    PRIMARY KEY (IdCategoria)
);

CREATE TABLE Productos (
    Codigo varchar(20) NOT NULL,
    Nombre varchar(45) NOT NULL,
    Precio decimal(10,2) NOT NULL,
    Stock int NOT NULL,
    IdCategoria int NOT NULL,
    PRIMARY KEY (Codigo),
    FOREIGN KEY (IdCategoria) REFERENCES Categorias(IdCategoria)
);

DELIMITER \$\$
CREATE PROCEDURE sp\_AgregarProducto (
    IN pCodigo VARCHAR(20),
    IN pNombre VARCHAR(45),
    IN pPrecio DECIMAL(10,2),
    IN pStock INT,
    IN pIdCategoria INT
)
BEGIN
    INSERT INTO Productos (Codigo, Nombre, Precio, Stock, IdCategoria)
    VALUES (pCodigo, pNombre, pPrecio, pStock, pIdCategoria);
END\$\$
DELIMITER ;

## 🛠️ Tecnologías

- **Java** 8+
- **MySQL** 5.7+
- **JDBC Driver** - MySQL Connector/J
