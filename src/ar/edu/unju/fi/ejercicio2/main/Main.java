package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		List<Efemeride> listaEfemeride = new ArrayList<>();
		Efemeride efemeride = new Efemeride();
		Scanner sc = new Scanner(System.in);
		int opc,mes,dia;
		String codigo,detalle;
		boolean band;
		do {
			band=true;
			System.out.println("1- Crear efemeride");
			System.out.println("2- Mostrar efemerides");
			System.out.println("3- Eliminar efemweride ");
			System.out.println("4- Modificar efemeride");
			System.out.println("5- Salir");
			System.out.println("Elija una opcion: ");
			opc=sc.nextInt();
			switch(opc) {
				case 1:
						System.out.println("Ingrese codigo: ");
						codigo=sc.next();
						do {
							System.out.println("Ingrese mes: ");
							mes=sc.nextInt();
							switch(mes) {
							case 1:
									efemeride.setMes(Mes.ENERO);
									band=false;
									break;
							case 2:
									efemeride.setMes(Mes.FEBRERO);
									band=false;
									break;
							case 3:
									efemeride.setMes(Mes.MARZO);
									band=false;
									break;
							case 4:
									efemeride.setMes(Mes.ABRIL);
									band=false;
									break;
							case 5:
									efemeride.setMes(Mes.MAYO);
									band=false;
									break;
							case 6:
									efemeride.setMes(Mes.JUNIO);
									band=false;
									break;
							case 7:
									efemeride.setMes(Mes.JULIO);
									band=false;
									break;
							case 8: 
									efemeride.setMes(Mes.AGOSTO);
									band=false;
									break;
							case 9:
									efemeride.setMes(Mes.SEPTIEMBRE);
									band=false;
									break;
							case 10:
									efemeride.setMes(Mes.OCTUBRE);
									band=false;
									break;
							case 11:
									efemeride.setMes(Mes.NOVIEMBRE);
									band=false;
									break;
							case 12:
									efemeride.setMes(Mes.DICIEMBRE);
									band=false;
									break;
							default:
									System.out.println("Opcion incorrecta, ingrese nuevamente");
								
							}
						}while(band==true);
						do {
							System.out.println("Ingrese dia: ");
							dia=sc.nextInt();
							if(dia>=1 && dia<=31) {
								band=true;
							}
						}while(band==false);
						sc.nextLine();
						System.out.println("Ingrese detalle: ");
						detalle=sc.nextLine();
						listaEfemeride.add(new Efemeride(codigo, efemeride.getMes(), dia, detalle));
						break;
				case 2:
						if(listaEfemeride.size()>0) {
							for(Efemeride e:listaEfemeride) {
								System.out.println(e);
							}
						}else {
							System.out.println("No se han cargado efemerides");
						}
						break;
				case 3:
						if(listaEfemeride.size()>0) {
							System.out.println("Ingrese codigo efemeride: ");
							codigo=sc.next();
							Iterator<Efemeride> iterator = listaEfemeride.iterator();
							while(iterator.hasNext()) {
								efemeride = (Efemeride)iterator.next();
								if(efemeride.getCodigo().equals(codigo)) {
									iterator.remove();
									band=false;
									System.out.println("Efemeride eliminada con exito!");
								}
							}
							if(band==true) {
								System.out.println("La efemeride no se encuentra registrada");
							}
						}else {
							
						}
						break;
				case 4:
						if(listaEfemeride.size()>0) {
							System.out.println("Ingrese codigo: ");
							codigo=sc.next();
							for(int i=0;i<listaEfemeride.size() && band==true;i++) {
								if(listaEfemeride.get(i).getCodigo().equals(codigo)) {
									do {
										System.out.println("Ingrese mes: ");
										mes=sc.nextInt();
										switch(mes) {
										case 1:
												efemeride.setMes(Mes.ENERO);
												band=false;
												break;
										case 2:
												efemeride.setMes(Mes.FEBRERO);
												band=false;
												break;
										case 3:
												efemeride.setMes(Mes.MARZO);
												band=false;
												break;
										case 4:
												efemeride.setMes(Mes.ABRIL);
												band=false;
												break;
										case 5:
												efemeride.setMes(Mes.MAYO);
												band=false;
												break;
										case 6:
												efemeride.setMes(Mes.JUNIO);
												band=false;
												break;
										case 7:
												efemeride.setMes(Mes.JULIO);
												band=false;
												break;
										case 8: 
												efemeride.setMes(Mes.AGOSTO);
												band=false;
												break;
										case 9:
												efemeride.setMes(Mes.SEPTIEMBRE);
												band=false;
												break;
										case 10:
												efemeride.setMes(Mes.OCTUBRE);
												band=false;
												break;
										case 11:
												efemeride.setMes(Mes.NOVIEMBRE);
												band=false;
												break;
										case 12:
												efemeride.setMes(Mes.DICIEMBRE);
												band=false;
												break;
										default:
												System.out.println("Opcion incorrecta, ingrese nuevamente");
											
										}
									}while(band==true);
									listaEfemeride.get(i).setMes(efemeride.getMes());
									do {
										System.out.println("Ingrese dia: ");
										dia=sc.nextInt();
										if(dia>=1 && dia<=31) {
											listaEfemeride.get(i).setDia(dia);
											band=true;
										}
									}while(band==false);
									sc.nextLine();
									System.out.println("Ingrese detalle: ");
									detalle=sc.nextLine();
									listaEfemeride.get(i).setDetalle(detalle);
									System.out.println("Los datos se modificaron con exito!");
									band=false;
								}
							}
							if(band==true) {
								System.out.println("No se ha encontrado la efemeride");
							}
						}else {
							System.out.println("No se han cargado efemerides");
						}
						break;
				case 5:	System.out.println("El programa ha finalizado");
						break;
				default:
						System.out.println("Opcion incorrecta, ingrese nuevamente");
			}
		}while(opc!=5);
		sc.close();
	}

}
