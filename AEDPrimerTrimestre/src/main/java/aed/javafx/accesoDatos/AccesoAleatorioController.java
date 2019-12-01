package aed.javafx.accesoDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.scene.control.Tab;
import javafx.scene.control.TextInputDialog;

public class AccesoAleatorioController {

	private AccesoAleatorioView view = new AccesoAleatorioView();
	private AccesoAleatorioModel modelo = new AccesoAleatorioModel();
	private File f;
	
	public AccesoAleatorioController() {
		f= new File("Datos.dat");
		try {
			f.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		view.getAñadir().setOnAction(e -> onAñadirAction(e));
		view.getModifPrecio().setOnAction(e -> onModifPrecioAction(e));
		view.getVerFich().setOnAction(e -> onVerFichAction(e));
		view.getVerDatosRes().setOnAction(e -> onVerDatosResAction(e));
		
	}
	
	private void onVerDatosResAction(ActionEvent e) {
		
	}

	private void onVerFichAction(ActionEvent e) {
		
	}

	private void onModifPrecioAction(ActionEvent e) {
		
	}

	private void onAñadirAction(ActionEvent e) {
		TextInputDialog dialogo = new TextInputDialog();
		dialogo.setTitle("Crear residencia");
		dialogo.setHeaderText("Nombre de la residencia");
		Optional<String> ope = dialogo.showAndWait();
		StringBuilder nombreRes= new StringBuilder(ope.get());
		
		TextInputDialog dialogo2 = new TextInputDialog();
		dialogo.setTitle("Crear residencia");
		dialogo.setHeaderText("Código de la universidad");
		Optional<String> ope2 = dialogo2.showAndWait();
		StringBuilder codUni= new StringBuilder(ope2.get());
		
		TextInputDialog dialogo3 = new TextInputDialog();
		dialogo.setTitle("Crear residencia");
		dialogo.setHeaderText("Precio Mensual");
		Optional<String> ope3 = dialogo3.showAndWait();
		StringBuilder precio = new StringBuilder(ope3.get());
		
		TextInputDialog dialogo4 = new TextInputDialog();
		dialogo.setTitle("Crear residencia");
		dialogo.setHeaderText("Comedor");
		Optional<String> ope4 = dialogo4.showAndWait();
		StringBuilder comedor = new StringBuilder(ope4.get());
		
		try {
			RandomAccessFile random = new RandomAccessFile(f, "rw");
			long puntero = random.length();
			int id= (int)(puntero/51+1);
			
			if(nombreRes.length()>10) {
				nombreRes=nombreRes.delete(10, nombreRes.length());
			}
			if(nombreRes.length()<10) {
				int espacios = 10-nombreRes.length();
				for(int i=0;i<espacios;i++) {
					nombreRes.append(" ");
				}
			}
			
			if(codUni.length()>6) {
				codUni=codUni.delete(6,codUni.length());
			}
			if(codUni.length()<6) {
				int espacios = 6-codUni.length();
				for(int i=0;i<espacios;i++) {
					codUni.append(" ");
				}
			}
			
			random.seek(random.length());
			random.writeInt(id);
			random.writeChar(',');
			random.writeChars(nombreRes.toString());
			random.writeChar(',');
			random.writeChars(codUni.toString());
			random.writeChar(',');
			random.writeInt(Integer.parseInt(precio.toString()));
			random.writeChar(',');
			random.writeBoolean(Boolean.parseBoolean(comedor.toString()));
			random.writeChar(',');
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public Tab getView() {
		return view;
	}
}

