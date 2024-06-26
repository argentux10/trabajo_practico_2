package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.IPago;

public class PagoEfectivo implements IPago{
	
	private double montoPagado;
	private LocalDate fechaPago;
	
	public PagoEfectivo() {
		// TODO Auto-generated constructor stub
	}

	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		super();
		this.montoPagado = montoPagado;
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	@Override
	public double realizarPago(double monto) {
		this.montoPagado= monto*0.90;
		return this.montoPagado;
	}

	@Override
	public void imprimirRecibo(LocalDate fechaPago) {
		System.out.println("*** RECIBO ***");
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
		System.out.println("Fecha de pago: "+formato.format(fechaPago));
		System.out.println("Monto pagado: "+this.montoPagado);
	}
}
