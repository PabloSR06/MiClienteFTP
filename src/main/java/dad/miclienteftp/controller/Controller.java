package dad.miclienteftp.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import dad.miclienteftp.main.App;
import dad.miclienteftp.model.ConexionProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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

public class Controller implements Initializable{
	
//	private FileChooser fileChooser;
//	private DirectoryChooser directoryChooser;
	
	//MODEL
//	private ConexionProperty ConexionProperty;
	
	
	//VIEW
	
	@FXML
    private MenuItem conectMenu;

    @FXML
    private MenuItem disconectMenu;
    
    @FXML
    private  Label directorioLabel;
        
    @FXML
    private Button downloadButton;

    @FXML
    private TableView<?> fileTable;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> sizeColumn;

    @FXML
    private Menu stateMenu;

    @FXML
    private TableColumn<?, ?> tipeColumn;

    @FXML
    private BorderPane view;
    

	
	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/servidor.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	
	

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
    	//directorioLabel.setText(ConectionController.getCliente().printWorkingDirectory());
    	
    }
    
    @FXML
    void onConectAction(ActionEvent event) {
    	ConectionController controller = new ConectionController();
		controller.showOnStage(App.getPrimaryStage());
    }
    
    @FXML
    void onDisconectAction(ActionEvent event) throws IOException {
    }
    
    public BorderPane getView() {
		return view;
	}

	

}
