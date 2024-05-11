package ar.edu.unju.fi.ejercicio7.main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio1.constantes.Categoria;
import ar.edu.unju.fi.ejercicio1.constantes.Origen;
import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {

	public static void main(String[] args) {
		List<Producto> listaProducto = new ArrayList<>();
		List<Producto> listaSinStock = new ArrayList<>();
		List<Producto> productosIncrementados = new ArrayList<>();
		List<Producto> categoriaStock = new ArrayList<>();
		List<Producto> listaAux = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int opc;
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
		listaAux=listaProducto;
		
		do{
			System.out.println("1- Mostrar productos disponibles");
			System.out.println("2- Mostrar los productos faltantes");
			System.out.println("3- Incrementar los precios de los productos en un 20%");
			System.out.println("4- Mostrar los productos que corresponden a la categoria Electrohogar y esten disponibles para la venta");
			System.out.println("5- Ordenar los productos por precio de forma descendente");
			System.out.println("6- Mostrar los productos con los nombres en mayuscula.");
			System.out.println("Ingrese una opcion: ");
			opc=sc.nextInt();
			switch(opc) {
			case 1:
				Consumer<Producto> disponible = c -> {
					if(c.isEstado()) {
						System.out.println(c);
					}
				};
				listaProducto.forEach(disponible);
				break;
			case 2:
				Predicate<Producto> filterNoStock = p -> p.isEstado()==false;
				Consumer<Producto> sinStock = c -> System.out.println(c);
				listaSinStock = listaProducto.stream().filter(filterNoStock).collect(Collectors.toList());
				listaSinStock.forEach(sinStock);
				break;
			case 3:
				Consumer<Producto> printLista = c -> System.out.println(c);
				Function<Producto, Producto> incremento = (num) -> {
					num.setPrecioU(num.getPrecioU()*1.20);
					return num;
				};
				productosIncrementados = listaProducto.stream().map(incremento).collect(Collectors.toList());
				productosIncrementados.forEach(printLista);
				break;
			case 4:
				printLista = c -> System.out.println(c);
				Predicate<Producto> filterCategoriaDisponible = p -> p.isEstado()==true && p.getCategoria()==Categoria.ELECTROHOGAR;
				categoriaStock = listaProducto.stream().filter(filterCategoriaDisponible).collect(Collectors.toList());
				categoriaStock.forEach(printLista);
				break;
			case 5:
				printLista = c -> System.out.println(c);
				Comparator<Producto> comparadorPorPrecio = Comparator.comparing(Producto::getPrecioU);
				Collections.sort(listaProducto, comparadorPorPrecio);
				listaProducto.forEach(printLista);
				break;
			case 6:
				printLista = c -> System.out.println(c);
				Function<Producto, Producto> nombreMayus = (f) -> {
					f.setDescripcion(f.getDescripcion().toUpperCase());
					return f;
				};
				listaAux= listaAux.stream().map(nombreMayus).collect(Collectors.toList());
				listaAux.forEach(printLista);
				break;
			default:
				System.out.println("Opcion incorrecta, ingrese nuevamente");
			}
		}while(opc!=6);
		sc.close();
	}

}
