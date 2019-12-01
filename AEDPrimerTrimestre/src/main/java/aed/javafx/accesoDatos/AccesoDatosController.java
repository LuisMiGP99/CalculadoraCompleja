package aed.javafx.accesoDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.scene.control.Tab;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

public class AccesoDatosController {
	
	private AccesoDatosView view = new AccesoDatosView();
	private AccesoDatosModel modelo = new AccesoDatosModel();
	
	public AccesoDatosController() {

		//bindeos
		view.getCarpetasTexto().textProperty().bindBidirectional(modelo.carpetasProperty());
		view.getRutaTexto().textProperty().bindBidirectional(modelo.rutaProperty());
		view.getContenido().textProperty().bindBidirectional(modelo.contenidoProperty());
		view.getListadoFicheroCarpeta().itemsProperty().bind(modelo.listadoProperty());
		view.getEsFichero().selectedProperty().bindBidirectional(modelo.esFicheroProperty());
		
		
		
		view.getCrear().setOnAction(e -> {
			try {
				onCrearAction(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		//actionEvents
		view.getEliminar().setOnAction(e -> onEliminarAction(e));
		view.getMover().setOnAction(e -> onMoverAction(e));
		view.getVerFC().setOnAction(e -> onVerFCAction(e));
		view.getVerContF().setOnAction(e -> onVerContFAction(e));
		view.getModFich().setOnAction(e -> onModFichAction(e));
		view.getListadoFicheroCarpeta().setOnMouseClicked(e -> onMouseClickedAction(e));
		
	}
	
	
	private void onMouseClickedAction(MouseEvent e) {
		String seleccionado = view.getListadoFicheroCarpeta().getSelectionModel().getSelectedItem();
		modelo.setCarpetas(seleccionado);		
	}


	private void onModFichAction(ActionEvent e) {
		File fichero= new File(modelo.getRuta()+File.separator+modelo.getCarpetas());
		try {
			FileWriter fich = new FileWriter(fichero);
			BufferedWriter fi = new BufferedWriter(fich);
			
			fi.write(modelo.getContenido());
			fi.flush();
			
			fi.close();
			fich.close();
			
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void onVerFCAction(ActionEvent e) {
		modelo.getListado().clear();
		System.out.println(modelo.getRuta());
			if(modelo.getCarpetas()==null) {
				File directorio = new File(modelo.getRuta());
				modelo.getListado().addAll(directorio.list());
			}else {
				modelo.setRuta(modelo.getRuta()+File.separator+modelo.getCarpetas());
				File directorio = new File(modelo.getRuta());
				modelo.getListado().addAll(directorio.list());
				modelo.setCarpetas("");
			}
		
	}

	private void onVerContFAction(ActionEvent e) {
		modelo.getListado().clear();
		try {
			FileReader fichero = new FileReader(new File(modelo.getRuta()+File.separator+modelo.getCarpetas()));
			BufferedReader lector = new BufferedReader(fichero);
			
			String dato,contenido="";
			while((dato=lector.readLine())!=null) {
				contenido+=dato;
				contenido+="\n";
			}
			modelo.setContenido(contenido);
			lector.close();
			fichero.close();
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		}
	}

	private void onMoverAction(ActionEvent e) {
		TextInputDialog dialogo = new TextInputDialog();
		dialogo.setTitle("Mover fichero");
		dialogo.setHeaderText("Mover");
		dialogo.setContentText("¿Dónde quieres mover el fichero?");
		Optional<String> ope = dialogo.showAndWait();
		new File(modelo.getRuta()+File.separator+modelo.getCarpetas()).renameTo(new File(ope.get()));
	}
	
	private void eliminar(File fichero) {
		File[] ficheros = fichero.listFiles();
		int i;
		for(i=0;i<ficheros.length;i++) {
			if(ficheros[i].isDirectory()) {
				eliminar(ficheros[i]);
			}
		ficheros[i].delete();
		}
		fichero.delete();
	}

	private void onEliminarAction(ActionEvent e) {
		File fichero = new File(modelo.getRuta()+File.separator+modelo.getCarpetas());
		if(fichero.isDirectory()) {
		eliminar(fichero);
		}else {
			fichero.delete();
		}
		modelo.setCarpetas("");
	}


	private void onCrearAction(ActionEvent e) throws IOException {
		File fichero = new File(modelo.getRuta()+modelo.getCarpetas());
		if(view.getEsFichero().isSelected()) {
			fichero.createNewFile();
		}else {
			fichero.mkdir();
		}
	}


	public Tab getView() {
		return view;
	}
	

}
