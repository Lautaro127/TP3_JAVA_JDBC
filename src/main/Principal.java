package main;

import java.util.ArrayList;

import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Principal {

	public static void main(String[] args) {
	
		
		DaoCategoria dp = new DaoCategoria();
		
		dp.modificarNombre("Dio Brando", 1);
		

	}
}
