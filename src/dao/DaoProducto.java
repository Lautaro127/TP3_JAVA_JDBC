package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import entidad.Producto;

public class DaoProducto {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String baseDeDatoString = "bdinventario";
	String query = "";
	public DaoProducto() {}
	
	public void agregarProducto(Producto producto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(host+baseDeDatoString + "?useSSL=false", user, pass);
			CallableStatement cs =  conexion.prepareCall("CALL sp_AgregarProducto(?,?,?,?,?)");
			cs.setString(1, producto.getCodigo());
			cs.setString(2, producto.getNombre());
			cs.setDouble(3, producto.getPrecio());
			cs.setInt(4, producto.getStock());
			cs.setInt(5, producto.getId());
			cs.execute();
		} catch (Exception e) {
			System.out.println("No se pudo conectar a la base de datos");
		}
		
	}
	
	public ArrayList<Producto> listarProductos() {
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(host+baseDeDatoString+"?useSSL=false", user, pass);
			query = "SELECT Codigo, Nombre, Precio, Stock, IdCategoria FROM productos";
			PreparedStatement ps = conexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Producto producto = new Producto();
				producto.setCodigo(rs.getString(1));
				producto.setNombre(rs.getString(2));
				producto.setPrecio(rs.getDouble(3));
				producto.setStock(rs.getInt(4));
				producto.setId(rs.getInt(5));
				
				listaProductos.add(producto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listaProductos;
	}
}
