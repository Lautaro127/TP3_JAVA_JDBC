package main;

import java.util.ArrayList;

import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Principal {

	public static void main(String[] args) {
	
		
		DaoProducto dp = new DaoProducto();
		
		dp.modificarCodigo("PROD001", "PROD031");
		

	}
}
