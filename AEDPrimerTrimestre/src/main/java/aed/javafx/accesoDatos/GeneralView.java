package aed.javafx.accesoDatos;

import javafx.scene.control.TabPane;

public class GeneralView extends TabPane {
	
	private AccesoDatosController controller1 = new AccesoDatosController();
	private AccesoAleatorioController controller2= new AccesoAleatorioController();
	
	public GeneralView() {
		super();
		setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		this.getTabs().addAll(controller1.getView());
		this.getTabs().addAll(controller2.getView());
		
	}
}
