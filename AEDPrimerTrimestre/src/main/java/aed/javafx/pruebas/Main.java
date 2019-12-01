package aed.javafx.pruebas;

import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		File fichero = new File("D:\\Manzana.txt");
		String nombre = new String("D:\\CarpetaDePruebas\\Prueba.txt");
		File directorio = new File("D:\\CarpetaDePruebas");
		//Utiles.existe(fichero);
		//Utiles.eliminarFichero(segundo);
		//Utiles.crearFichero(fichero);
		Utiles.moverFichero(fichero, nombre);
		//Utiles.listarFichero(directorio);
		//Utiles.visualizarRuta(fichero);
	}
}