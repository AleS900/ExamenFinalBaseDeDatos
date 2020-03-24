package Examen;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Conector instancia = Conector.getInstancia();
		// Ejercicio 1
		// Mostrar las canciones de los albumes que terminen con "s"
		System.out.println("EJERCICIO 1");
		System.out.println("MOSTRAR LAS CANCIONES DE LOS ALBUMES QUE TERMINEN CON S");
		System.out.println("CANCIÓN         ÁLBUM");
		try {
			ArrayList<String> listCanciones = instancia.getCanciones();
			for (String Ejercicio1 : listCanciones) {
				System.out.println(Ejercicio1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		// Ejecercio 2
		// Mostrar los nombres de los artistas por orden de popularidad
		System.out.println("EJERCICIO 2");
		System.out.println("MOSTRAR LOS NOMBRES DE LOS ARTISTAS POR ORDEN DE POPULARIDAD");
		System.out.println("ARTISTA  NRO_REPRODUCCIONES");
		try {
			ArrayList<String> listPopularidad = instancia.getPopularidad();
			for (String Ejercicio2 : listPopularidad) {
				System.out.println(Ejercicio2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		// Ejecercio 3
		// Obtener el promedio de duracion de las canciones de Mickey Mouse
		System.out.println("EJERCICIO 3");
		System.out.println("OBTENER EL PROMEDIO DE DURACION DE LAS CANCIONES DE MICKEY MOUSE");
		System.out.println("PROMEDIO_CANCIONES_MICKEY_MOUSE");
		try {
			ArrayList<String> listDuracion = instancia.getDuracion();
			for (String Ejercicio3 : listDuracion) {
				System.out.println(Ejercicio3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
