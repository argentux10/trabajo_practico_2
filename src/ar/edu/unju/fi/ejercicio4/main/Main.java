package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	public static void main(String[] args) {
		List<Jugador> listaJugador = new ArrayList<>();
		Jugador jugador = new Jugador();
		Scanner sc= new Scanner(System.in);
		String nombre, apellido, nacionalidad;
		float estatura;
		byte peso;
		int opc;
		boolean band;
		do {
			band=false;
			System.out.println("1- Alta de jugador");
			System.out.println("2- Mostrar todos los jugadores");
			System.out.println("3- Modificar la posicion de un jugador");
			System.out.println("4- Eliminar un jugador");
			System.out.println("5- Salir");
			System.out.println("Elija una opcion: ");
			opc=sc.nextInt();
			switch(opc) {
				case 1:
						System.out.println("Ingrese nombre: ");
						nombre=sc.next();
						System.out.println("Ingrese apellido: ");
						apellido=sc.next();
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						String fechaStr;
						LocalDate fechaNac=null;
						do {
							System.out.println("Ingrese fecha de nacimiento (dd/mm/yyyy): ");
							fechaStr = sc.next();
							try {
								fechaNac = LocalDate.parse(fechaStr, dtf);
							}catch(DateTimeParseException e){
								System.out.println("ERROR, Ingrese nuevamente con el formato adecuado");
								band=true;
							}
							if(band==true) {
								band=false;
							}else {
								band=true;
							}
						}while(band==false);
						
						System.out.println("Ingrese nacionalidad: ");
						nacionalidad = sc.next();
						
						System.out.println("Ingrese estatura: ");
						estatura = sc.nextFloat();
						
						System.out.println("Ingrese peso: ");
						peso = sc.nextByte();
						
						do {
							opc=0;
							System.out.println("1- Delantero");
							System.out.println("2- Mediocampista");
							System.out.println("3- Defensor");
							System.out.println("4- Arquero");
							System.out.println("Seleccione posicion: ");
							opc=sc.nextInt();
							switch(opc) {
								case 1:
										jugador.setPosicion(Posicion.DELANTERO);
										band=false;
										break;
								case 2:
										jugador.setPosicion(Posicion.MEDIO);
										band=false;
										break;
								case 3:
										jugador.setPosicion(Posicion.DEFENSA);
										band=false;
										break;
								case 4:
										jugador.setPosicion(Posicion.ARQUERO);
										band=false;
										break;
								default: 
							}
						}while(band==true);
						listaJugador.add(new Jugador(nombre, apellido, fechaNac, nacionalidad, estatura, peso, jugador.getPosicion()));  
						break;
				case 2:
						if(listaJugador.size()>0) {
							for(Jugador j:listaJugador) {
								System.out.println(j);
							}
						}else {
							System.out.println("No se han registrado jugadores");
						}
						break;
				case 3:	
						if(listaJugador.size()>0) {
							System.out.println("Ingrese nombre: ");
							nombre=sc.next();
							System.out.println("Ingrese apellido: ");
							apellido=sc.next();
							for(int i=0;i<listaJugador.size();i++) {
								if(listaJugador.get(i).getNombre().equals(nombre) && listaJugador.get(i).getApellido().equals(apellido)) {
									System.out.println("Modificar posicion");
									do {
										opc=0;
										System.out.println("1- Delantero");
										System.out.println("2- Mediocampista");
										System.out.println("3- Defensor");
										System.out.println("4- Arquero");
										System.out.println("Seleccione posicion: ");
										opc=sc.nextInt();
										switch(opc) {
											case 1:
													listaJugador.get(i).setPosicion(Posicion.DELANTERO);
													band=false;
													break;
											case 2:
													listaJugador.get(i).setPosicion(Posicion.MEDIO);
													band=false;
													break;
											case 3:
													listaJugador.get(i).setPosicion(Posicion.DEFENSA);
													band=false;
													break;
											case 4:
													listaJugador.get(i).setPosicion(Posicion.ARQUERO);
													band=false;
													break;
											default: 
										}
									}while(band==true);
									System.out.println("Posicion modificada con exito!");
									band=true;
								}
							}
							if(band==false) {
								System.out.println(nombre+" "+apellido+" no se encuentra registrado");
							}
						}else {
							System.out.println("No se han registrado jugadores");
						}
						break;
				case 4:
						if(listaJugador.size()>0) {
							System.out.println("Ingrese nombre: ");
							nombre=sc.next();
							System.out.println("Ingrese apellido: ");
							apellido=sc.next();
							Iterator<Jugador> iterator = listaJugador.iterator();
							while(iterator.hasNext()) {
								jugador = (Jugador)iterator.next();
								if(jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
									iterator.remove();
									band=true;
									System.out.println("Jugador eliminado con exito!");
								}
							}
							if(band==false) {
								System.out.println("El jugador no se encuentra registrado");
							}
						}else {
							System.out.println("No se han registrado jugadores");
						}
						break;
				case 5:
						System.out.println("El programa ha finalizado");
						break;
				default:
						System.out.println("Opcion incorrecta, ingrese nuevamente");
			}
		}while(opc!=5);
		sc.close();
	}

}
