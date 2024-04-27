package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.constantes.Categoria;
import ar.edu.unju.fi.ejercicio1.constantes.Origen;
import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {

	public static void main(String[] args) {
		List<Producto> listaProducto = new ArrayList<>();
		Producto producto = new Producto();
		Scanner sc = new Scanner(System.in);
		String codigo, descripcion;
		double precioU;
		int opc;
		boolean band;
		do {
			opc=0;
			band=true;
			System.out.println("1- Crear producto");
			System.out.println("2- Mostrar productos");
			System.out.println("3- Modificar producto");
			System.out.println("4- Salir");
			System.out.println("Elija una opcion: ");
			opc=sc.nextInt();
			switch(opc) {
				case 1:
						System.out.println("Ingrese codigo: ");
						codigo= sc.next();
						producto.setCodigo(codigo);
						System.out.println("Ingrese descripcion: ");
						descripcion= sc.next();
						producto.setDescripcion(descripcion);
						System.out.println("Ingrese precio unitario: ");
						precioU=sc.nextDouble();
						producto.setPrecioU(precioU);
						do {
							System.out.println("---Origen de Fabricacion---");
							System.out.println("1- Argentina");
							System.out.println("2- China");
							System.out.println("3- Brasil");
							System.out.println("4- Uruguay");
							System.out.println("Elija una opcion: ");
							opc=sc.nextInt();
							switch(opc) {
								case 1:
										producto.setOrigenFabricacion(Origen.ARGENTINA);
										band=false;
										break;
								case 2:	
										producto.setOrigenFabricacion(Origen.CHINA);
										band=false;
										break;
								case 3:
										producto.setOrigenFabricacion(Origen.BRASIL);
										band=false;
										break;
								case 4:
										producto.setOrigenFabricacion(Origen.URUGUAY);
										band=false;
										break;
								default: System.out.println("Opcion incorrecta, ingrese nuevamente");
							}
						}while(band==true);
						do {
							System.out.println("---Categoria---");
							System.out.println("1- Telefonia");
							System.out.println("2- Informatica");
							System.out.println("3- Electro hogar");
							System.out.println("4- Herramientas");
							System.out.println("Elija una opcion: ");
							opc=sc.nextInt();
							switch(opc) {
								case 1:
										producto.setCategoria(Categoria.TELEFONIA);
										band=true;
										break;
								case 2:	
										producto.setCategoria(Categoria.INFORMATICA);
										band=true;
										break;
								case 3:
										producto.setCategoria(Categoria.ELECTROHOGAR);
										band=true;
										break;
								case 4:
										producto.setCategoria(Categoria.HERRAMIENTAS);
										band=true;
										break;
								default: System.out.println("Opcion incorrecta, ingrese nuevamente");
							}
						}while(band==false);
						listaProducto.add(producto);
						break;
				case 2:
						for(Producto p:listaProducto) {
							System.out.println(p);
						}
						break;
				case 3:
						
						break;
				case 4:	
						System.out.println("El programa ha finalizado");
						break;
				default: System.out.println("Opcion incorrecta, ingrese nuevamente");
			}
		}while(opc!=4);
		sc.close();
	}

}
