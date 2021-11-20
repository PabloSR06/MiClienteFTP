package dad.miclienteftp.model;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.net.ftp.FTPFile;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FTP {
	
	@SuppressWarnings("serial")
	public static final Map<Integer, String> FILE_TYPE = new HashMap<Integer, String>() {
		{
			put(FTPFile.DIRECTORY_TYPE, "Directorio");
			put(FTPFile.FILE_TYPE, "Fichero");
			put(FTPFile.SYMBOLIC_LINK_TYPE, "Enlace");
		}
	};
	
	private ObjectProperty<FTPFile> fichero = new SimpleObjectProperty<>();
	
	private StringProperty nombreFile = new SimpleStringProperty();
	
	private LongProperty sizeFile = new SimpleLongProperty();
	
	private StringProperty tipeFile= new SimpleStringProperty();
	
	public FTP(FTPFile file) {
		setNombreFile(file.getName());
		setSizeFile(file.getSize());
		setTipeFile(FILE_TYPE.get(file.getType()));
        
    }

	public final ObjectProperty<FTPFile> ficheroProperty() {
		return this.fichero;
	}
	

	public final FTPFile getFichero() {
		return this.ficheroProperty().get();
	}
	

	public final void setFichero(final FTPFile fichero) {
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
