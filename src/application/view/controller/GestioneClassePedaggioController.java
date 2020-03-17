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
    private Label label_classe;

    @FXML
    private MenuButton classe;

    @FXML
    private MenuItem classe_unitaria;

    @FXML
    private MenuItem classe_ambientale;
    
    @FXML
    private TextField txtiva;

    @FXML
    private Button bottone_applica;

    @FXML
    private TextField txtnuovaiva;

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
    	txtiva.setText(Integer.toString(SceltaClassePedaggioController.getInstance().getGestione().getIva()));
    	if(txtclasse.getText().equals("Classe Unitaria")) {
    		label_classe.setText("Si ricorda che dal 2021, nel conteggio, verranno valutate anche \r\n" + 
    				"le classi ambientali di appartenenza a ciascun veicolo.");
    		} else {
    			label_classe.setText("I pedaggi verranno calcolati secondo il nuovo sistema\r\n" + 
    					"(valutando anche le classi ambientali).");
    		}
    }
    @FXML
    void aggiorna_iva(ActionEvent event) {
    	 //controllo campo vuoto
    	if(txtnuovaiva.getText().equals("")) {
    		Alert alert = new Alert(AlertType.ERROR, "Selezionare il nuovo importo iva da applicare.");
		    alert.showAndWait();
		    }
    	
        else {
    	SceltaClassePedaggioController.getInstance().modifica_iva(Integer.parseInt(txtnuovaiva.getText()));
    	Alert alert = new Alert(AlertType.CONFIRMATION, "Modifica avvenuta correttamente.");
	    alert.showAndWait();
	    initialize();
	    txtnuovaiva.setText("");
        }

    }

}
