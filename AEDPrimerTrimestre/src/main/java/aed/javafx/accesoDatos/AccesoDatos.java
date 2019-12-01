package aed.javafx.accesoDatos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AccesoDatos extends Application{
	
	GeneralController controller= new GeneralController();
	
	public void start(Stage primaryStage) throws Exception {
		
		Scene scene = new Scene(controller.getView(),640,480);
		
		primaryStage.setTitle("Acceso");
		primaryStage.setScene(scene);
		primaryStage.show();
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
}

