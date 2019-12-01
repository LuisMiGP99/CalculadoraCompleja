package dad.java.calculadora;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Application {
	 private Label mas,ima;
	 private TextField a,b,c,d,real,imagin;
	 private ComboBox<String> operadores;
	 private Separator separador;
	 
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		mas= new Label("+");
		ima= new Label("i");
		
		a = new TextField();
		a.setPromptText("0");
		a.setMaxWidth(80);
		
		b = new TextField();
		b.setPromptText("0");
		b.setMaxWidth(80);
		
		c = new TextField();
		c.setPromptText("0");
		c.setMaxWidth(80);
		
		d = new TextField();
		d.setPromptText("0");
		d.setMaxWidth(80);
		
		real = new TextField();
		real.setPromptText("0");
		real.setMaxWidth(80);
		
		imagin = new TextField();
		imagin.setPromptText("0");
		imagin.setMaxWidth(80);
		
		operadores = new ComboBox<String>();
		operadores.getItems().addAll("+","-","*","/");
		operadores.setPromptText("+");
		operadores.setOnAction(e-> onSelect(e));
		
		separador = new Separator();
		separador.setOrientation(Orientation.HORIZONTAL);
		
		VBox opBox = new VBox(5,operadores);
		opBox.setAlignment(Pos.CENTER);
		opBox.setStyle("-fx-background-color: white");
		
		HBox primero= new HBox(5,a,mas,b,ima);
		primero.setAlignment(Pos.CENTER);
		primero.setStyle("-fx-background-color: white");
		
		HBox segundo= new HBox(5,c,mas,d,ima);
		segundo.setAlignment(Pos.CENTER);
		segundo.setStyle("-fx-background-color: white");
		
		HBox total= new HBox(5,real,mas,imagin,ima);
		total.setAlignment(Pos.CENTER);
		total.setStyle("-fx-background-color: white");
		
		VBox calBox = new VBox(10,primero,segundo,separador,total);
		calBox.setAlignment(Pos.CENTER);
		calBox.setStyle("-fx-background-color: white");
		
		HBox root= new HBox(10,opBox,calBox);
		root.setAlignment(Pos.CENTER);
		root.setStyle("-fx-background-color: white");
		
		Scene scene= new Scene(root,320,200);
		
		primaryStage.setTitle("Calculadora");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private void onSelect(ActionEvent e) {
		Double cantidadA,cantidadB,cantidadC,cantidadD;
		
		Alert alertError = new Alert(AlertType.ERROR);
		alertError.setTitle("AdivinApp");
		alertError.setHeaderText("Error");
		alertError.setContentText("El numero introducido no es valido");
		
		String numero1 =a.getText();
		String numero2 =b.getText();
		String numero3 =c.getText();
		String numero4 =d.getText();
		try {
			cantidadA=(double)Integer.parseInt(numero1);
			cantidadB=(double)Integer.parseInt(numero2);
			cantidadC=(double)Integer.parseInt(numero3);
			cantidadD=(double)Integer.parseInt(numero4);
		} catch (NumberFormatException excp) {
			alertError.showAndWait();
		}
		
		if(operadores.getValue() == "+") {
			
		}else if(operadores.getValue() == "-") {
			
		}else if(operadores.getValue() == "*") {
			
		}else {
			
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
