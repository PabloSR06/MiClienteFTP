package dad.miclienteftp.conexion;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ConexionProperty {

	private StringProperty server = new SimpleStringProperty();
	private IntegerProperty port = new SimpleIntegerProperty();
	private StringProperty user = new SimpleStringProperty();
	private StringProperty password = new SimpleStringProperty();
	public final StringProperty serverProperty() {
		return this.server;
	}
	
	public final String getServer() {
		return this.serverProperty().get();
	}
	
	public final void setServer(final String server) {
		this.serverProperty().set(server);
	}
	
	public final IntegerProperty portProperty() {
		return this.port;
	}
	
	public final int getPort() {
		return this.portProperty().get();
	}
	
	public final void setPort(final int port) {
		this.portProperty().set(port);
	}
	
	public final StringProperty userProperty() {
		return this.user;
	}
	
	public final String getUser() {
		return this.userProperty().get();
	}
	
	public final void setUser(final String user) {
		this.userProperty().set(user);
	}
	
	public final StringProperty passwordProperty() {
		return this.password;
	}
	
	public final String getPassword() {
		return this.passwordProperty().get();
	}
	
	public final void setPassword(final String password) {
		this.passwordProperty().set(password);
	}
	
	
	


}
