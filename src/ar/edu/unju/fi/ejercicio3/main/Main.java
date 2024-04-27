package ar.edu.unju.fi.ejercicio3.main;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		List<Provincia> listaProvincia = new ArrayList<>();
		Provincia jujuy = Provincia.JUJUY;
		Provincia salta = Provincia.SALTA;
		Provincia tucuman = Provincia.TUCUMAN;
		Provincia santiagodEstero= Provincia.SANTIAGO_DEL_ESTERO;
		Provincia laRioja = Provincia.LA_RIOJA;
		Provincia catamarca = Provincia.CATAMARCA;
		listaProvincia.add(jujuy);
		listaProvincia.add(salta);
		listaProvincia.add(tucuman);
		listaProvincia.add(santiagodEstero);
		listaProvincia.add(laRioja);
		listaProvincia.add(catamarca);
		for(Provincia p:listaProvincia) {
			System.out.println("Provincia: "+p.getProvincia());
			System.out.println("Cantidad Poblacion: "+p.getCantPoblacion());
			System.out.println("Superficie: "+p.getSuperficie()+"km²");
			System.out.println("Densidad: "+p.calcularDesidad()+" hab./km²");
			System.out.println();
		}

	}

}
