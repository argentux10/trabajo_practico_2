package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.constantes.Categoria;
import ar.edu.unju.fi.ejercicio1.constantes.Origen;
import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio5.interfaces.IPago;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;

public class Main {
	public static void main(String[] args) {
		List<Producto> listaProducto = new ArrayList<>();
		List<Producto> listaCompra = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int opc;
		String codigo;
		listaProducto.add(new Producto("AMR", "Memoria ram 4gb DDR4" , 30500.0, Origen.ARGENTINA, Categoria.INFORMATICA, false));
		listaProducto.add(new Producto("BMR", "Memoria ram 8gb DDR4" , 54500.0, Origen.ARGENTINA, Categoria.INFORMATICA, true));
		listaProducto.add(new Producto("CMR", "Memoria ram 16gb DDR4" , 79500.0, Origen.ARGENTINA, Categoria.INFORMATICA, true));
		listaProducto.add(new Producto("DMR", "Memoria ram 32gb DDR4" , 110500.0, Origen.ARGENTINA, Categoria.INFORMATICA, true));
		listaProducto.add(new Producto("EMR", "Memoria ram 64gb DDR5" , 200000.0, Origen.ARGENTINA, Categoria.INFORMATICA, false));
		listaProducto.add(new Producto("API", "Intel Core 3 12va Gen." , 60500.49, Origen.CHINA, Categoria.INFORMATICA, false));
		listaProducto.add(new Producto("BPI", "Intel Core 5 11va Gen." , 90500.49, Origen.CHINA, Categoria.INFORMATICA, true));
		listaProducto.add(new Producto("CPI", "Intel Core 5 12va Gen." , 110500.49, Origen.CHINA, Categoria.INFORMATICA, true));
		listaProducto.add(new Producto("DPI", "Intel Core 7 12va Gen." , 200500.49, Origen.CHINA, Categoria.INFORMATICA, true));
		listaProducto.add(new Producto("EPI", "Intel Core 9 12va Gen." , 400000.49, Origen.CHINA, Categoria.INFORMATICA, false));
		listaProducto.add(new Producto("API", "Pava electrica Philips" , 40700.49, Origen.BRASIL, Categoria.ELECTROHOGAR, false));
		listaProducto.add(new Producto("BPI", "Licuadora Philips" , 62300.49, Origen.BRASIL, Categoria.ELECTROHOGAR, true));
		listaProducto.add(new Producto("CPI", "Cafetera Philips" , 54899.49, Origen.BRASIL, Categoria.ELECTROHOGAR, true));
		listaProducto.add(new Producto("DPI", "Afeitadora electrica Philips" , 64499.49, Origen.BRASIL, Categoria.ELECTROHOGAR, true));
		listaProducto.add(new Producto("EPI", "Secador de pelo Philips" , 49999.99, Origen.BRASIL, Categoria.ELECTROHOGAR, false));
		
		do {
			System.out.println("\n   **** MENU ****");
			System.out.println("1- Mostrar productos");
			System.out.println("2- Realizar compra");
			System.out.println("3- Salir");
			System.out.println("Elija una opcion: ");
			opc = sc.nextInt();
			switch(opc) {
				case 1:
					for(Producto p: listaProducto) {
						System.out.println(p);
					}
					break;
				case 2:
					boolean band = true,controlResp=true;
					boolean estado=true;
					do {
						System.out.println("Ingrese codigo del producto a comprar: ");
						codigo = sc.next();
						for(Producto p: listaProducto) {
							if(p.getCodigo().equals(codigo)) {
								if(p.isEstado()) {
									System.out.println("Se agrego al carrito el: ");
									System.out.println(p);
									listaCompra.add(p);
								}
								estado=p.isEstado();
								band=false;
							}
						}
						if(band==true) {
							System.out.println("El codigo ingresado no corresponde a ningun producto");
						}
						if(estado==false) {
							System.out.println("No hay stock de este producto");
						}
						do {
							System.out.println("Desea comprar otro producto?: Si/No");
							String respuesta=sc.next();
							respuesta=respuesta.toLowerCase();
							System.out.println("Respuesta: "+respuesta);
							if(respuesta.equals("si")) {
								band=true; 
								controlResp=false;
							}
							if(respuesta.equals("no")) {
								band=false; 
								controlResp=false;
							}
							if(respuesta.compareTo("no")!=0 && respuesta.compareTo("si")!=0) {
								System.out.println("Error, respuesta incorrecta, debe ingresar \"Si\" o \"No\"");
								band=true;
							}
						}while(controlResp==true);
					}while(band==true);
					double sumatoria=0.0;
					for(Producto p: listaCompra) {
						sumatoria+=p.getPrecioU();
					}
					System.out.println("El precio total de los productos es: "+sumatoria);
					do {
						System.out.println("1- Pago efectivo");
						System.out.println("2- Pago con tarjeta");
						System.out.println("Elija una opcion: ");
						opc=sc.nextInt();
						switch(opc) {
							case 1:
								System.out.println("Pago con efectivo se aplica un descuento del 10% del monto total");
								LocalDate fecha = LocalDate.now();
								IPago pagoEfectivo = new PagoEfectivo(sumatoria, fecha);
								pagoEfectivo.realizarPago(sumatoria);
								pagoEfectivo.imprimirRecibo(fecha);
								band=true;
								break;
							case 2:
								System.out.println("Pago con tarjeta se aplica un recargo del 15% del monto toal");
								System.out.println("Ingrese numero de tarjeta: ");
								String numeroTarjeta = sc.next();
								fecha = LocalDate.now();
								IPago pagoTarjeta = new PagoTarjeta(numeroTarjeta, fecha, sumatoria);
								pagoTarjeta.realizarPago(sumatoria);
								pagoTarjeta.imprimirRecibo(fecha);
								band=true;
								break;
							default:
								System.out.println("Opcion incorrecta, ingrese nuevamente");
						}
					}while(band==false);
					break;
				case 3:
					System.out.println("El programa ha finalizado");
					break;
				default:
					System.out.println("Opcion incorrecta, ingrese nuevamente");
						
			}
		}while(opc!=3);
		sc.close();
	}
}
