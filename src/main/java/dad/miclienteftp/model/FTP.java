package dad.miclienteftp.model;

import java.io.File;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FTP {
	
	private ObjectProperty<File> fichero = new SimpleObjectProperty<>();
	
	private StringProperty nombreFile = new SimpleStringProperty();
	
	private LongProperty sizeFile = new SimpleLongProperty();
	
	private StringProperty tipeFile= new SimpleStringProperty();
	
	public FTP(String a, long b, String c) {
        this.nombreFile = new SimpleStringProperty(a);
        this.sizeFile = new SimpleLongProperty(b);
        this.tipeFile = new SimpleStringProperty(c);
    }

	public final ObjectProperty<File> ficheroProperty() {
		return this.fichero;
	}
	

	public final File getFichero() {
		return this.ficheroProperty().get();
	}
	

	public final void setFichero(final File fichero) {
		this.ficheroProperty().set(fichero);
	}
	

	public final StringProperty nombreFileProperty() {
		return this.nombreFile;
	}
	

	public final String getNombreFile() {
		return this.nombreFileProperty().get();
	}
	

	public final void setNombreFile(final String nombreFile) {
		this.nombreFileProperty().set(nombreFile);
	}
	

	public final LongProperty sizeFileProperty() {
		return this.sizeFile;
	}
	

	public final long getSizeFile() {
		return this.sizeFileProperty().get();
	}
	

	public final void setSizeFile(final long sizeFile) {
		this.sizeFileProperty().set(sizeFile);
	}
	

	public final StringProperty tipeFileProperty() {
		return this.tipeFile;
	}
	

	public final String getTipeFile() {
		return this.tipeFileProperty().get();
	}
	

	public final void setTipeFile(final String tipeFile) {
		this.tipeFileProperty().set(tipeFile);
	}
	

}
