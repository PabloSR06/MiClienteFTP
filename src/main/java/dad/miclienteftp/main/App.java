package dad.miclienteftp.main;

import dad.miclienteftp.conexion.ConectionController;
import dad.miclienteftp.servidor.Controller;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class App extends Application {
	
	private ConectionController controllerConexion;
	private Controller controller;
	private static Stage primaryStage;
	
	//model
	private StringProperty valor = new SimpleStringProperty();

	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new Controller();
		controllerConexion = new ConectionController();
		
		Scene scene = new Scene(controller.getView());
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Mi Cliente FTP");
		primaryStage.show();
		
		

	}
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void error(String header) {
		Alert error = new Alert(AlertType.ERROR);
		error.initOwner(getPrimaryStage());
		error.setTitle("Error");
		error.setHeaderText(header);
		error.showAndWait();
	}

	public static void info(String title, String header) {
		Alert info = new Alert(AlertType.INFORMATION);
		info.initOwner(getPrimaryStage());
		info.setTitle(title);
		info.setHeaderText(header);
		info.showAndWait();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
