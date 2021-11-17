package dad.miclienteftp.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.miclienteftp.model.ConexionProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConectionController implements Initializable {
	
	//MODEL
	private Stage stage;
	
	private ConexionProperty property;

	
	//VIEW	

	@FXML
	private Button cancelarButton;

	@FXML
	private Button conectButton;

	@FXML
	private GridPane conexion;

	@FXML
	private PasswordField passwordText;

	@FXML
	private TextField portText;

	@FXML
	private TextField serverText;

	@FXML
	private TextField userText;

	public ConectionController(){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/conexion.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		property.serverNameProperty().bindBidirectional(serverText.textProperty());
		property.portProperty().bindBidirectional(portText.textProperty());
	}
	


	@FXML
	void onCancelarAction(ActionEvent event) {
		stage.close();
	}

	@FXML
	void onConectAction(ActionEvent event) {
		
	}

	public GridPane getView() {
		return conexion;
	}

	public void showOnStage(Stage primaryStage) {
		stage = new Stage();
		stage.setTitle("Iniciar Sesion");
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(primaryStage);
		stage.setScene(new Scene(conexion, 400, 200));
		stage.showAndWait();
		
	}
}
