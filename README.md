# TP3 - Sistema de Gestión de Inventario

Aplicación de consola en **Java** con **MySQL** que implementa ABML (Alta, Baja, Modificación y Listado) de categorías y productos.

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

## 📦 Estructura

src/
├── dao/
│   ├── DaoCategoria.java
│   └── DaoProducto.java
├── entidad/
│   ├── Categoria.java
│   └── Producto.java
└── main/
└── Principal.java

