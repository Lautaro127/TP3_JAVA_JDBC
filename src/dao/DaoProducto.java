package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.Callable;

import entidad.Producto;

public class DaoProducto {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String baseDeDatoString = "bdinventario";
	
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
	
}
