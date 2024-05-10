package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.IPago;

public class PagoTarjeta implements IPago{
	
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;
	
	public PagoTarjeta() {
		// TODO Auto-generated constructor stub
	}

	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double montoPagado) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	@Override
	public double realizarPago(double monto) {
		this.montoPagado = monto*1.15;
		return this.montoPagado;
	}

	@Override
	public void imprimirRecibo(LocalDate fechaPago) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
		System.out.println("*** RECIBO ***");
		System.out.println("Numero de tarjeta: "+this.numeroTarjeta);
		System.out.println("Fecha de pago: "+formato.format(fechaPago));
		System.out.println("Monto pagado: "+this.montoPagado);
	}
}
