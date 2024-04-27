package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY("Jujuy",811611,19), SALTA("Salta",1333000,120), TUCUMAN("Tucuman",1593000,91), CATAMARCA("Catamarca",396895,399), LA_RIOJA("La Rioja",362605,89), SANTIAGO_DEL_ESTERO("Santiago del Estero",1060906,2116);
	
	private String provincia;
	private int cantPoblacion;
	private int superficie;
	
	private Provincia(String provincia, int cantPoblacion, int superficie) {
		this.provincia = provincia;
		this.cantPoblacion = cantPoblacion;
		this.superficie = superficie;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getCantPoblacion() {
		return cantPoblacion;
	}

	public void setCantPoblacion(int cantPoblacion) {
		this.cantPoblacion = cantPoblacion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	public double calcularDesidad() {
		return this.cantPoblacion/this.superficie;
	}
}
