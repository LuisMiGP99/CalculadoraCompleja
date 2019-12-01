package aed.javafx.accesoDatos;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AccesoAleatorioModel {
	
	private StringProperty contenido;
	
	public AccesoAleatorioModel() {
		contenido = new SimpleStringProperty();
	}	

	public final StringProperty contenidoProperty() {
		return this.contenido;
	}
	

	public final String getContenido() {
		return this.contenidoProperty().get();
	}
	

	public final void setContenido(final String contenido) {
		this.contenidoProperty().set(contenido);
	}
}
