package dad.miclienteftp.servidor;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RootModel {
	
	private StringProperty directorio = new SimpleStringProperty();

	public final StringProperty directorioProperty() {
		return this.directorio;
	}
	

	public final String getDirectorio() {
		return this.directorioProperty().get();
	}
	

	public final void setDirectorio(final String directorio) {
		this.directorioProperty().set(directorio);
	}
	
	
	

}
