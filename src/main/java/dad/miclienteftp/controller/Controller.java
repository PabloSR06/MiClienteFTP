package dad.miclienteftp.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.miclienteftp.main.App;
import dad.miclienteftp.model.ConexionProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller implements Initializable{
	
	//MODEL
	private ConexionProperty ConexionProperty;

	
	//VIEW
	
	@FXML
    private MenuItem conectMenu;

    @FXML
    private MenuItem disconectMenu;

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
    void onDownloadAction(ActionEvent event) {
    	System.out.println(ConexionProperty.getPort());
    }
    
    @FXML
    void onConectAction(ActionEvent event) {
    	ConectionController controller = new ConectionController();
		controller.showOnStage(App.getPrimaryStage());
    }
    
    public BorderPane getView() {
		return view;
	}
	

}
