package main;

import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Principal {

	public static void main(String[] args) {
		Producto p1 = new Producto(1, "ABC123", "Camiseta", 19.99, 50);
		DaoProducto DP = new DaoProducto();
		
		DP.agregarProducto(p1);
	}

}
