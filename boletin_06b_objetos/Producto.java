package boletin_06b_objetos;

import java.util.Random;

public class Producto {
	private static double iva;
	private static int ultimoId = 0;
	
	private static final double IVA_INICIAL = 21;
	
	private String codigo;
	private String descripcion;
	private double precio;
	
	public Producto(String descripcion, double precio) throws ParametroInvalidoException {
		iva = Producto.IVA_INICIAL;
		this.descripcion = descripcion;
		
		if (precio <= 0) {
			throw new ParametroInvalidoException("El precio debe ser mayor que 0");
		}
		this.precio = precio;
		
		this.codigo = generaCodigo();
		
	}
	
	
	private String generaCodigo() {
		return "Prod" + ultimoId++;
	}
	
	public double getPrecioVenta() {
		return this.precio + this.precio * iva / 100;
	}


	public static double getIva() {
		return iva;
	}


	public static int getUltimoId() {
		return ultimoId;
	}


	public String getCodigo() {
		return codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public double getPrecio() {
		return precio;
	}


	public static void setIva(double iva) {
		Producto.iva = iva;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + 
				", descripcion=" + descripcion + 
				", precio=" + precio + 
				", PVP=" + this.getPrecioVenta() + "]";
	}
	
	
}
