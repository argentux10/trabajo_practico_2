package ar.edu.unju.fi.ejercicio1.model;

import ar.edu.unju.fi.ejercicio1.constantes.Categoria;
import ar.edu.unju.fi.ejercicio1.constantes.Origen;

public class Producto {
	private String codigo;
	private String descripcion;
	private double precioU;
	Origen origenFabricacion;
	Categoria categoria;
	private boolean estado;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(String codigo, String descripcion, double precioU, Origen origenFabricacion, Categoria categoria) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioU = precioU;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
	}
	
	public Producto(String codigo, String descripcion, double precioU, Origen origenFabricacion, Categoria categoria, boolean estado) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioU = precioU;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
		this.estado = estado;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioU() {
		return precioU;
	}

	public void setPrecioU(double precioU) {
		this.precioU = precioU;
	}

	public Origen getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(Origen origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Producto \n Codigo: " + codigo + "\n Descripcion: " + descripcion + "\n Precio Unitario: " + precioU
				+ "\n Origen de Fabricacion: " + origenFabricacion + "\n Categoria: " + categoria+"\n Stock: "+disponibilidad(estado);
	}
	
	public String disponibilidad(boolean estado) {
		String disponibilidad="";
		if(estado) {
			disponibilidad = "Disponible";
		}else {
			disponibilidad = "No hay stock";
		}
		return disponibilidad;
	}
	
}
