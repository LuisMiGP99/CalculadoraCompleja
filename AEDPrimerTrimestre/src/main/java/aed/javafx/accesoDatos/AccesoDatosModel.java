package aed.javafx.accesoDatos;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AccesoDatosModel {
	
	private StringProperty ruta;
	private StringProperty carpetas;
	private StringProperty contenido;
	private BooleanProperty esFichero;
	private ListProperty<String> listado;
	
	public AccesoDatosModel() {
		ruta= new SimpleStringProperty();
		carpetas= new SimpleStringProperty();
		contenido= new SimpleStringProperty();
		esFichero= new SimpleBooleanProperty();
		listado = new SimpleListProperty<String>(FXCollections.observableArrayList());
	}
	
	public final StringProperty rutaProperty() {
		return this.ruta;
	}
	
	public final String getRuta() {
		return this.rutaProperty().get();
	}
	
	public final void setRuta(final String ruta) {
		this.rutaProperty().set(ruta);
	}
	
	public final StringProperty carpetasProperty() {
		return this.carpetas;
	}
	
	public final String getCarpetas() {
		return this.carpetasProperty().get();
	}
	
	public final void setCarpetas(final String carpetas) {
		this.carpetasProperty().set(carpetas);
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
	
	public final BooleanProperty esFicheroProperty() {
		return this.esFichero;
	}
	
	public final boolean isEsFichero() {
		return this.esFicheroProperty().get();
	}
	
	public final void setEsFichero(final boolean esFichero) {
		this.esFicheroProperty().set(esFichero);
	}
	
	public final ListProperty<String> listadoProperty() {
		return this.listado;
	}
	
	public final ObservableList<String> getListado() {
		return this.listadoProperty().get();
	}
	
	public final void setListado(final ObservableList<String> listado) {
		this.listadoProperty().set(listado);
	}
	
	
	
}
