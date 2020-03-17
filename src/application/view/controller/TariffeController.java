package application.view.controller;

import java.io.IOException;

import application.controller.ModificaTariffaController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TariffeController {

    @FXML
    private TextField txtnome;

    @FXML
    private Button bottone_conferma;

    @FXML
    private Button bottone_indietro;

    @FXML
    private MenuButton classe_ambientale;

    @FXML
    private MenuItem classeEuro1;

    @FXML
    private MenuItem classeEuro2;

    @FXML
    private MenuItem classeEuro3;

    @FXML
    private MenuItem classeEuro4;

    @FXML
    private MenuItem classeEuro5;

    @FXML
    private MenuItem classeEuro6;

    @FXML
    void classeE1_selezionata(ActionEvent event) {
    	classe_ambientale.setText("Euro 1");
    }

    @FXML
    void classeE2_selezionata(ActionEvent event) {
    	classe_ambientale.setText("Euro 2");
    }

    @FXML
    void classeE3_selezionata(ActionEvent event) {
    	classe_ambientale.setText("Euro 3");
    }

    @FXML
    void classeE4_selezionata(ActionEvent event) {
    	classe_ambientale.setText("Euro 4");
    }

    @FXML
    void classeE5_selezionata(ActionEvent event) {
    	classe_ambientale.setText("Euro 5");
    }

    @FXML
    void classeE6_selezionata(ActionEvent event) {
    	classe_ambientale.setText("Euro 6");
    }
    

    @FXML
    void conferma_tariffa(ActionEvent event) {
    	//Controllo campi vuoti
    	if(txtnome.getText().equals("")|classe_ambientale.getText().equals("Classe Ambientale")) {
    		Alert alert = new Alert(AlertType.ERROR, "Selezionare la classe ambientale e immettere l'importo della nuova tariffa per quella classe.");
		    alert.showAndWait();
    	}
    	else { //controllo importo tariffa
    		if (ModificaTariffaController.getInstance().getTariffaAmbientale(classe_ambientale.getText()).getTariffa()==(Float.parseFloat(txtnome.getText()))) {
    			Alert alert = new Alert(AlertType.ERROR, "E' già applicato questo importo per questa classe ambientale.");
    		    alert.showAndWait();
    		}
    		else { //modifica tariffa
    			ModificaTariffaController.getInstance().modifica_tariffa(classe_ambientale.getText(), Float.parseFloat(txtnome.getText()));
    			Alert alert = new Alert(AlertType.CONFIRMATION, "Il nuovo importo è stato impostato.");
    		    alert.showAndWait();
    		    txtnome.setText("");
    		}
    		   
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

}
