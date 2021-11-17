package dad.miclienteftp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

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

	// MODEL
	private Stage stage;

	public ConexionProperty property = new ConexionProperty();

	// VIEW

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

	private static  FTPClient cliente = new FTPClient();

	public static FTPClient getClient() {
		return cliente;
	}


	public ConectionController() {
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

		
	}

	@FXML
	void onCancelarAction(ActionEvent event) {
		stage.close();
	}

	@FXML
	void onConectAction(ActionEvent event) {

		try {
			cliente.connect("ftp.rediris.es", 21);
			cliente.login("", "");
			cliente.changeWorkingDirectory("/debian/dists");
			property.setDirectorio(cliente.printWorkingDirectory());

			//FTPFile[] ficheros = cliente.listFiles();

			cliente.changeWorkingDirectory("..");

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		stage.close();
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
