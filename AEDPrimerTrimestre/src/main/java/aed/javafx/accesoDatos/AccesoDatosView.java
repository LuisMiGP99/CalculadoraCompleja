package aed.javafx.accesoDatos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class AccesoDatosView extends Tab{
	
	private BorderPane border;
	private GridPane grid;
	
	private Label nombre;
	private Label ruta;
	
	private TextField rutaTexto;
	private TextField carpetasTexto;
	
	private Button crear;
	private Button eliminar;
	private Button mover;
	private Button verFC;
	private Button verContF;
	private Button modFich;
	
	private RadioButton esCarpeta;
	private RadioButton esFichero;
	
	private ListView<String> listadoFicheroCarpeta;
	
	private TextArea contenido;
	
	private ToggleGroup grupo;
	
	private HBox botones;

	public AccesoDatosView() {
		super("Acceso a datos");
		border= new BorderPane();
		grid = new GridPane();
		
		nombre= new Label("Nombre del Alumno");
		ruta= new Label("Ruta Actual");
		
		rutaTexto = new TextField("");
		carpetasTexto = new TextField("");
		
		crear = new Button("Crear");
		eliminar = new Button("Eliminar");
		mover = new Button("Mover");
		verFC = new Button("Ver fichero y carpeta");
		verContF = new Button("Ver Contenido Fichero");
		modFich = new Button("Modificar Fichero");
		
		esCarpeta = new RadioButton("Es carpeta ");
		esFichero = new RadioButton("Es fichero ");
		
		listadoFicheroCarpeta= new ListView<String>();
		
		contenido = new TextArea();
		
		border.setTop(nombre);
		border.setCenter(grid);
		BorderPane.setAlignment(nombre, Pos.CENTER);
		BorderPane.setAlignment(grid, Pos.CENTER);
		
		grupo = new ToggleGroup();
		grupo.getToggles().addAll(esCarpeta,esFichero);
		
		botones=new HBox(crear,eliminar,mover,esCarpeta,esFichero);
		botones.setSpacing(65);
		
		grid.setPadding(new Insets(5));
		grid.addRow(0,ruta,rutaTexto);
		grid.addRow(1,botones);
		grid.addRow(2,carpetasTexto);
		grid.addRow(3,verFC);
		grid.addRow(4,listadoFicheroCarpeta);
		grid.addRow(5,verContF,contenido);
		grid.addRow(6, modFich);
		
		GridPane.setColumnSpan(rutaTexto, 4);
		GridPane.setColumnSpan(botones, 5);
		GridPane.setColumnSpan(carpetasTexto, 5);
		GridPane.setColumnSpan(listadoFicheroCarpeta, 5);
		GridPane.setColumnSpan(contenido, 3);
		GridPane.setRowSpan(contenido, 2);
		GridPane.setColumnSpan(verContF, 2);
		GridPane.setColumnSpan(modFich, 2);
		
		grid.setHgap(5);
		grid.setVgap(5);
		GridPane.setMargin(listadoFicheroCarpeta, new Insets(5));
		GridPane.setMargin(contenido, new Insets(5));
		
		carpetasTexto.setPromptText("Carpetas o fichero a crear,eliminar o destino a mover");
		contenido.setPromptText("Contenido del fichero");
		
		ColumnConstraints[] cols = {
				new ColumnConstraints()
		};
		cols[0].setHgrow(Priority.ALWAYS);
		cols[0].setFillWidth(true);
		
		
		this.setContent(border);
	}
	

	public Label getNombre() {
		return nombre;
	}


	public void setNombre(Label nombre) {
		this.nombre = nombre;
	}


	public Label getRuta() {
		return ruta;
	}


	public void setRuta(Label ruta) {
		this.ruta = ruta;
	}


	public TextField getRutaTexto() {
		return rutaTexto;
	}


	public void setRutaTexto(TextField rutaTexto) {
		this.rutaTexto = rutaTexto;
	}


	public TextField getCarpetasTexto() {
		return carpetasTexto;
	}


	public void setCarpetasTexto(TextField carpetasTexto) {
		this.carpetasTexto = carpetasTexto;
	}


	public Button getCrear() {
		return crear;
	}


	public void setCrear(Button crear) {
		this.crear = crear;
	}


	public Button getEliminar() {
		return eliminar;
	}


	public void setEliminar(Button eliminar) {
		this.eliminar = eliminar;
	}


	public Button getMover() {
		return mover;
	}


	public void setMover(Button mover) {
		this.mover = mover;
	}


	public Button getVerFC() {
		return verFC;
	}


	public void setVerFC(Button verFC) {
		this.verFC = verFC;
	}


	public Button getVerContF() {
		return verContF;
	}


	public void setVerContF(Button verContF) {
		this.verContF = verContF;
	}


	public Button getModFich() {
		return modFich;
	}


	public void setModFich(Button modFich) {
		this.modFich = modFich;
	}


	public RadioButton getEsCarpeta() {
		return esCarpeta;
	}


	public void setEsCarpeta(RadioButton esCarpeta) {
		this.esCarpeta = esCarpeta;
	}


	public RadioButton getEsFichero() {
		return esFichero;
	}


	public void setEsFichero(RadioButton esFichero) {
		this.esFichero = esFichero;
	}


	public ListView<String> getListadoFicheroCarpeta() {
		return listadoFicheroCarpeta;
	}


	public void setListadoFicheroCarpeta(ListView<String> listadoFicheroCarpeta) {
		this.listadoFicheroCarpeta = listadoFicheroCarpeta;
	}


	public TextArea getContenido() {
		return contenido;
	}


	public void setContenido(TextArea contenido) {
		this.contenido = contenido;
	}

}
