package entidad;

public class Producto {
	private int id;
	private String codigo;
	private String nombre;
	private double precio;
	private int stock;
	
	public Producto() {
		id = -1;
		codigo = "Sin codigo";
		nombre = "Sin nombre";
		precio = -1;
		stock = -1;
	}
	
	public Producto(int id, String codigo, String nombre, double precio, int stock) {
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	
	public Producto(String codigo, String nombre, double precio, int stock) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public int getStock() {
		return stock;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", codigo: " + codigo + ", nombre: " + nombre + ", precio: " + precio + ", stock: "
				+ stock + " ";
	}
	
	
	
}
