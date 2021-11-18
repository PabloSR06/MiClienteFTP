package dad.miclienteftp.servidor;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import dad.miclienteftp.conexion.ConectadoProperty;
import dad.miclienteftp.conexion.ConectionController;
import dad.miclienteftp.conexion.ConexionProperty;
import dad.miclienteftp.main.App;
import dad.miclienteftp.model.FTP;
import dad.miclienteftp.model.TipoFTP;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
//import javafx.stage.DirectoryChooser;
//import javafx.stage.FileChooser;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {

//	private FileChooser fileChooser;
//	private DirectoryChooser directoryChooser;

	// MODEL
	private ConexionProperty ConexionProperty = new ConexionProperty();
	private static ConectadoProperty conectado = ConectionController.getConectedModel();

	private RootModel model = new RootModel();

	private static ListProperty<FTP> tabla = new SimpleListProperty<>(FXCollections.observableArrayList());
	private ObjectProperty<FTP> seleccionado = new SimpleObjectProperty<>();

	// VIEW

	@FXML
	private MenuItem conectMenu;

	@FXML
	private MenuItem disconectMenu;

	@FXML
	private Label directorioLabel;

	@FXML
	private Button downloadButton;

	@FXML
	private TableView<FTP> fileTable;

	@FXML
	private TableColumn<FTP, String> nameColumn;

	@FXML
	private TableColumn<FTP, Long> sizeColumn;

	@FXML
	private Menu stateMenu;

	@FXML
	private TableColumn<FTP, String> tipeColumn;

	@FXML
	private VBox view;

	private static FTPClient cliente = ConectionController.getClient();

	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/servidor.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// model.valorProperty().bindBidirectional(ConectionController.getModel().valorProperty());
		seleccionado.bind(fileTable.getSelectionModel().selectedItemProperty());

		fileTable.itemsProperty().bind(tabla);

		nameColumn.setCellValueFactory(v -> v.getValue().nombreFileProperty());

		sizeColumn.setCellValueFactory(v -> v.getValue().sizeFileProperty());

		tipeColumn.setCellValueFactory(v -> v.getValue().tipeFileProperty());
	
		
		//bloquear botones
		//disconectMenu.setDisable(true);
		
		conectado.conectadoProperty().addListener((o, ov, nv) -> {
			System.out.println("o" + o.getValue());
			//disconectMenu.setDisable(!ov);
			//conectMenu.setDisable(ov);
			if (ov == true ) {
				try {
					directorioLabel.textProperty().set(cliente.printWorkingDirectory());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

	}

	@SuppressWarnings("serial")
	public static final Map<Integer, String> FILE_TYPE = new HashMap<Integer, String>() {
		{
			put(FTPFile.DIRECTORY_TYPE, "Directorio");
			put(FTPFile.FILE_TYPE, "Fichero");
			put(FTPFile.SYMBOLIC_LINK_TYPE, "Enlace");
		}
	};

	@FXML
	void onDownloadAction(ActionEvent event) throws IOException {
//    	File fichero = fileChooser.showSaveDialog(App.getPrimaryStage());
//		if (fichero != null) {
//			try {
//				getFxModel().save(fichero);
//			} catch (Exception e1) {
//				CodeGenApp.error("Error al guardar el modelo FX en el fichero '" + fichero.getName() + "'.",
//						e1.getMessage());
//			}
//		}
		// directorioLabel.setText(ConectionController.getCliente().printWorkingDirectory());

	}

	public static void listar() {
		tabla.clear();

		FTPFile[] ficheros;
		try {
			ficheros = cliente.listFiles();

			Arrays.stream(ficheros).forEach(fichero -> {
				tabla.addAll(new FTP(fichero.getName(), fichero.getSize(), FILE_TYPE.get(fichero.getType())));	
			});

			System.out.println(cliente.printWorkingDirectory());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void onConectAction(ActionEvent event) {
		ConectionController controller = new ConectionController();
		controller.showOnStage(App.getPrimaryStage());
	}

	@FXML
	void onDisconectAction(ActionEvent event){
		
		try {
			cliente.disconnect();
			conectado.conectadoProperty().setValue(false);
			tabla.clear();
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}

	public VBox getView() {
		return view;
	}

	public RootModel getModel() {
		return model;
	}

}
