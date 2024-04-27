package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;
import java.time.Period;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	LocalDate fechaNac;
	String nacionalidad;
	float estatura;
	byte peso;
	Posicion posicion;
	
	public Jugador() {
		// TODO Auto-generated constructor stub
	}

	public Jugador(String nombre, String apellido, LocalDate fechaNac, String nacionalidad, float estatura, byte peso,
			Posicion posicion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public byte getPeso() {
		return peso;
	}

	public void setPeso(byte peso) {
		this.peso = peso;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	@Override
	public String toString() {
		return "Jugador \n Nombre: " + nombre + "\n Apellido: " + apellido + "\n Fecha de nacimiento: " + fechaNac + "\n Nacionalidad: "
				+ nacionalidad + "\n Estatura: " + estatura + "\n Peso: " + peso + "\n Posicion: " + posicion;
	}

	int calcularEdad() {
		Period period = Period.between(this.fechaNac, LocalDate.now());
		return period.getYears();
	}
	
	
}
