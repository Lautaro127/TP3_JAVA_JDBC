package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidad.Categoria;
import entidad.Producto;

public class DaoCategoria {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String baseDeDatoString = "bdinventario";
	private String query = "";
	
	public DaoCategoria() {}
	
	public void agregarCategoria(Categoria categoria) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(host+baseDeDatoString + "?useSSL=false", user, pass);
			query = "INSERT INTO categorias(nombre) VALUES (?)";
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, categoria.getNombre());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("No se pudo conectar a la base de datos");
		}
		
	}
	
	public ArrayList<Categoria> listarCategorias() {
		ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(host+baseDeDatoString+"?useSSL=false", user, pass);
			query = "SELECT IdCategoria, Nombre FROM categorias";
			PreparedStatement ps = conexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt(1));
				categoria.setNombre(rs.getString(2));
				
				listaCategorias.add(categoria);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listaCategorias;
	}
}
