package dad.miclienteftp.conexion;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class ConectadoProperty {
	
	private BooleanProperty conectado = new SimpleBooleanProperty();

	public final BooleanProperty conectadoProperty() {
		return this.conectado;
	}
	

	public final boolean isConectado() {
		return this.conectadoProperty().get();
	}
	

	public final void setConectado(final boolean conectado) {
		this.conectadoProperty().set(conectado);
	}

}
