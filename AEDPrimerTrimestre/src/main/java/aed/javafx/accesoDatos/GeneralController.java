package aed.javafx.accesoDatos;

import javafx.scene.control.TabPane;

public class GeneralController {
	
	private GeneralView view = new GeneralView();
	
	public GeneralController() {
		
	}
	public TabPane getView() {
		return view;
	}
}
