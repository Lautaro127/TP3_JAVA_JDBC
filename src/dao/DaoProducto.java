package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaProductos;
	}

	public void eliminarProducto(String CodigoProducto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No funco maestro");
			e.printStackTrace();
		}
		Connection conexion = null;

		try {
			conexion = DriverManager.getConnection(host+baseDeDatoString+"?useSSL=false", user, pass);
			query = "DELETE FROM productos WHERE Codigo = ?";
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, CodigoProducto);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("No funco maestro 2");
		}
		
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modificarNombre(String nombreNuevo, String Codigo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(host+baseDeDatoString+"?useSSL=false", user, pass);
			query = "UPDATE productos SET Nombre = ? WHERE Codigo = ?;";
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, nombreNuevo);
			ps.setString(2, Codigo);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modificarCodigo(String codigoNuevo, String Codigo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(host+baseDeDatoString+"?useSSL=false", user, pass);
			query = "UPDATE productos SET Codigo = ? WHERE Codigo = ?;";
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, codigoNuevo);
			ps.setString(2, Codigo);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modificarPrecio(double PrecioNuevo, String Codigo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(host+baseDeDatoString+"?useSSL=false", user, pass);
			query = "UPDATE productos SET Precio = ? WHERE Codigo = ?;";
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setDouble(1, PrecioNuevo);
			ps.setString(2, Codigo);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modificarStock(int stockNuevo, String Codigo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(host+baseDeDatoString+"?useSSL=false", user, pass);
			query = "UPDATE productos SET Stock = ? WHERE Codigo = ?;";
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1,stockNuevo);
			ps.setString(2, Codigo);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void modificarIdCateogria(int stockId, String Codigo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(host+baseDeDatoString+"?useSSL=false", user, pass);
			query = "UPDATE productos SET IdCategoria = ? WHERE Codigo = ?;";
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1,stockId);
			ps.setString(2, Codigo);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
