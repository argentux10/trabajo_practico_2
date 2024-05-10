package ar.edu.unju.fi.ejercicio5.interfaces;

import java.time.LocalDate;

public interface IPago {
	
	public double realizarPago(double monto);
	
	public void imprimirRecibo(LocalDate fechaPago);

}
