package dad.miclienteftp.main;

import dad.miclienteftp.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	private Controller controller;
	private static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new Controller();
		
		Scene scene = new Scene(controller.getView());
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Mi Cliente FTP");
		primaryStage.show();

	}
	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
