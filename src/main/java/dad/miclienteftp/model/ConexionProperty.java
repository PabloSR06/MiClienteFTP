package dad.miclienteftp.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ConexionProperty {

	private StringProperty serverName = new SimpleStringProperty();
	private StringProperty port = new SimpleStringProperty();
	private StringProperty user = new SimpleStringProperty();
	private StringProperty password = new SimpleStringProperty();
	
	

	public final StringProperty serverNameProperty() {
		return this.serverName;
	}
	

	public final String getServerName() {
		return this.serverNameProperty().get();
	}
	

	public final void setServerName(final String serverName) {
		this.serverNameProperty().set(serverName);
	}
	

	public final StringProperty portProperty() {
		return this.port;
	}
	

	public final String getPort() {
		return this.portProperty().get();
	}
	

	public final void setPort(final String port) {
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
