package aed.javafx.pruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Utiles {
	public static void existe(File fichero) {
		
		if(fichero.exists()) {
			System.out.println("El fichero "+fichero+" existe");
			if(fichero.isDirectory()) {
				System.out.println("Es un directorio");
			}else if(fichero.isFile()){
				System.out.println("Es una fichero");
			}
		}else {
			System.out.println("El fichero "+fichero+" no existe");
		}
	}
	public static void eliminarFichero(File fichero) {
		if(fichero.exists()) {
			if (fichero.delete()) {
				System.out.println("El fichero " + fichero + " ha sido borrado correctamente");
			}else {
				System.out.println("El fichero " + fichero + " no se ha podido borrar");
			}
		}else {
			System.out.println("El fichero a eliminar no existe");
		}
	}
	public static void crearFichero(File fichero) throws IOException {
		if(!fichero.exists()) {
			if (fichero.createNewFile()) {
				System.out.println("El fichero " + fichero + " ha sido creado correctamente");
			}else {
				System.out.println("El fichero " + fichero + " no se ha podido crear");
			}
		}else {
			System.out.println("El fichero ya se ha creado");
		}
	}
	public static void moverFichero(File fichero, String nombre) throws IOException {
		File nuevo = new File(nombre);
		if(fichero.exists()) {
			fichero.renameTo(nuevo);
			System.out.println("Se ha cambiado el nombre del fichero");
		}else { 
			System.out.println("El fichero ya se ha creado");
		}
	}
	public static void verFichero(File fichero) throws IOException {
		if(fichero.exists()) {
			FileReader fic = new FileReader(fichero);
			BufferedReader fich = new BufferedReader(fic);
			while((fich.readLine())!=null) {
				System.out.println(fich);
			}
			fich.close();
			fic.close();
		}else {
			System.out.println("El fichero no existe");
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void modificarFichero(File fichero) throws IOException {
		if(fichero.exists()) {
			FileReader fic = new FileReader(fichero);
			BufferedReader fich = new BufferedReader(fic);
			String texto = new String();
			while((fich.readLine())!=null) {
				texto= texto+fich;
			}
			fich.close();
			fic.close();
		}else {
			System.out.println("El fichero no existe");
		}
	}
	public static void listarFichero(File fichero) throws IOException {
		if(fichero.isDirectory()) {
			String[] lista;
			lista=fichero.list();
			for(int i=0;i<lista.length;i++) {
				System.out.println(lista[i]);
			}
		}else {
			System.out.println("La ruta no existe");
		}
	}
	public static void visualizarRuta(File fichero) throws IOException {
		if(fichero.exists()) {
			System.out.println("Nombre del fichero: "+new String(fichero.getName()));
			System.out.println("Ruta del fichero: "+new String(fichero.getPath()));
			
		}else {
			System.out.println("La ruta no existe");
		}
	}
}