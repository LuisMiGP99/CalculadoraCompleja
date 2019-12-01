package aed.javafx.accesoDatos;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class AccesoAleatorioView extends Tab{
	
	private GridPane grid;
	private Button añadir,verFich,verDatosRes,modifPrecio;
	private TextArea contenidoTexto;
	private HBox botones;
	
	public AccesoAleatorioView() {
		super("Acceso aleatorio");
		grid=new GridPane();
		
		añadir= new Button("Añadir");
		verFich=new Button("Ver fichero");
		verDatosRes= new Button("Ver datos residencia");
		modifPrecio= new Button("Modificar precio");
		
		contenidoTexto= new TextArea();
		
		botones= new HBox(añadir,verFich,verDatosRes,modifPrecio);
		
		grid.setPadding(new Insets(5));
		grid.addRow(0,botones);
		grid.addRow(1,contenidoTexto);
		

		GridPane.setColumnSpan(botones, 5);
		GridPane.setColumnSpan(contenidoTexto, 5);
		GridPane.setRowSpan(contenidoTexto, 4);
		grid.setHgap(5);
		grid.setVgap(5);
		
		this.setContent(grid);
	}

	public Button getAñadir() {
		return añadir;
	}

	public void setAñadir(Button añadir) {
		this.añadir = añadir;
	}

	public Button getVerFich() {
		return verFich;
	}

	public void setVerFich(Button verFich) {
		this.verFich = verFich;
	}

	public Button getVerDatosRes() {
		return verDatosRes;
	}

	public void setVerDatosRes(Button verDatosRes) {
		this.verDatosRes = verDatosRes;
	}

	public Button getModifPrecio() {
		return modifPrecio;
	}

	public void setModifPrecio(Button modifPrecio) {
		this.modifPrecio = modifPrecio;
	}

	public TextArea getContenidoTexto() {
		return contenidoTexto;
	}

	public void setContenidoTexto(TextArea contenidoTexto) {
		this.contenidoTexto = contenidoTexto;
	}
	
}
