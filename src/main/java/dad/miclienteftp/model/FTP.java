package dad.miclienteftp.model;

import java.io.File;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FTP {
	
	private ObjectProperty<File> fichero = new SimpleObjectProperty<>();
	
	private StringProperty nombreFile = new SimpleStringProperty();
	
	private LongProperty sizeFile = new SimpleLongProperty();
	
	private ObjectProperty<TipoFTP> tipeFile= new SimpleObjectProperty<>();
	
	

}
