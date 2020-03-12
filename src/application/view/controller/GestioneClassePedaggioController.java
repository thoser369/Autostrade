package application.view.controller;

import java.io.IOException;

import application.controller.SceltaClassePedaggioController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GestioneClassePedaggioController {

    @FXML
    private Button bottone_indietro;

    @FXML
    private TextField txtclasse;

    @FXML
    private Button bottone_aggiorna;

    @FXML
    private Label label_classeunitaria;

    @FXML
    private MenuButton classe;

    @FXML
    private MenuItem classe_unitaria;

    @FXML
    private MenuItem classe_ambientale;

    @FXML
    private Label label_classeambientale;

    @FXML
    void classe_ambientale_selezionata(ActionEvent event) {
    	classe.setText("Classe Ambientale");
    }

    @FXML
    void classe_unitaria_selezionata(ActionEvent event) {
    	classe.setText("Classe Unitaria");
    }

    @FXML
    void aggiorna_scelta(ActionEvent event) {
      //controllo scelta non effettuata
    	if(classe.getText().equals("Scegli classe")) {
    		Alert alert = new Alert(AlertType.ERROR, "Selezionare la classe da importare per il calcolo del pedaggio.");
		    alert.showAndWait();
		    }
    	
        else {
    	SceltaClassePedaggioController.getInstance().modifica_gestione(classe.getText());
    	Alert alert = new Alert(AlertType.CONFIRMATION, "Modifica avvenuta correttamente.");
	    alert.showAndWait();
	    initialize();
        }
    }
    
    @FXML
    void indietro(ActionEvent event) throws IOException {
    	((Node)event.getSource()).getScene().getWindow().hide(); 
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		AnchorPane root=loader.load(getClass().getResource("/application/view/fxml/Impostazioni.fxml").openStream());
		Scene scene = new Scene(root);							
		primaryStage.setScene(scene);
		primaryStage.setTitle("Impostazioni");
		primaryStage.show();

    }
    
    public void initialize() {
    	txtclasse.setText(SceltaClassePedaggioController.getInstance().getGestione().getNome());
    	if(txtclasse.getText().equals("Classe Unitaria")) {
    		label_classeunitaria.setVisible(true);
    		label_classeambientale.setVisible(false);
    		} else {
    			label_classeunitaria.setVisible(false);
        		label_classeambientale.setVisible(true);
    		}
    }

}
