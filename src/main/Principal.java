package main;

import java.util.ArrayList;

import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Principal {

	public static void main(String[] args) {
	
		DaoCategoria daoCategoria = new DaoCategoria();
		DaoProducto daoProducto = new DaoProducto();
		
		// ABML DE CATEGORIAS
		System.out.println("--- ABML DE CATEGORIAS ---");
		
		// ALTA de categorías
		System.out.println("Agregando categorías:");
		daoCategoria.agregarCategoria(new Categoria("Electrónica"));
		daoCategoria.agregarCategoria(new Categoria("Ropa"));
		daoCategoria.agregarCategoria(new Categoria("Libros"));
		daoCategoria.agregarCategoria(new Categoria("Deportes"));
		daoCategoria.agregarCategoria(new Categoria("Hogar"));
		
		// LECTURA de categorías
		ArrayList<Categoria> categorias = daoCategoria.listarCategorias();
		System.out.println("Listado de categorías:");
		for(Categoria c : categorias) {
			System.out.println(c);
		}
		
		// MODIFICACION de categoría
		daoCategoria.modificarNombre("Electrónica y Tecnología", 16);
		System.out.println("Categoría 16 modificada a: Electrónica y Tecnología");
		
		// BAJA de categoría
		daoCategoria.eliminarCategoria(20);
		System.out.println("Categoría 20 eliminada");
		
		System.out.println();
		
		// ABML DE PRODUCTOS
		System.out.println("--- ABML DE PRODUCTOS ---");
		
		// ALTA de productos usando procedimiento almacenado
		System.out.println("Agregando 10 productos:");
		Producto p1 = new Producto("PROD001", "Laptop", 1300.00, 5);
		p1.setId(16);
		daoProducto.agregarProducto(p1);
		
		Producto p2 = new Producto("PROD002", "Mouse", 50.00, 20);
		p2.setId(16);
		daoProducto.agregarProducto(p2);
		
		Producto p3 = new Producto("PROD003", "Teclado", 100.00, 15);
		p3.setId(16);
		daoProducto.agregarProducto(p3);
		
		Producto p4 = new Producto("PROD004", "Monitor", 300.00, 8);
		p4.setId(16);
		daoProducto.agregarProducto(p4);
		
		Producto p5 = new Producto("PROD005", "Webcam", 150.00, 12);
		p5.setId(16);
		daoProducto.agregarProducto(p5);
		
		Producto p6 = new Producto("PROD006", "Camiseta", 25.00, 50);
		p6.setId(17);
		daoProducto.agregarProducto(p6);
		
		Producto p7 = new Producto("PROD007", "Pantalón", 60.00, 30);
		p7.setId(17);
		daoProducto.agregarProducto(p7);
		
		Producto p8 = new Producto("PROD008", "Libro Java", 45.00, 25);
		p8.setId(18);
		daoProducto.agregarProducto(p8);
		
		Producto p9 = new Producto("PROD009", "Balón", 35.00, 40);
		p9.setId(19);
		daoProducto.agregarProducto(p9);
		
		Producto p10 = new Producto("PROD010", "Auriculares", 80.00, 18);
		p10.setId(16);
		daoProducto.agregarProducto(p10);
		
		// LECTURA de productos
		ArrayList<Producto> productos = daoProducto.listarProductos();
		System.out.println("Listado de productos:");
		for(Producto p : productos) {
			System.out.println(p);
		}
		
		// MODIFICACION de productos
		daoProducto.modificarNombre("Laptop Gamer", "PROD001");
		daoProducto.modificarPrecio(1400.00, "PROD001");
		daoProducto.modificarStock(10, "PROD002");
		System.out.println("Productos modificados: PROD001 y PROD002");
		
		// BAJA de producto
		daoProducto.eliminarProducto("PROD010");
		System.out.println("Producto PROD010 eliminado");
		

	}
}
