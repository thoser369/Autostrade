package application.view.controller;

import java.io.IOException;

import application.controller.AutostradaController;
import application.controller.CaselloController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AutostradeECaselliController {
	
	ObservableList<String> elenco_autostrade = FXCollections.observableArrayList();
	ObservableList<String> elenco_caselli = FXCollections.observableArrayList();

	@FXML
    private Button bottone_indietro;

    @FXML
    private TextField txtautostrada;

    @FXML
    private Button bottone_aggiungiAutostrada;

    @FXML
    private Button bottone_eliminaAutostrada;

    @FXML
    private ComboBox<String> comboautostrada;

    @FXML
    private TextField txttariffa;

    @FXML
    private TextField txtcasello;

    @FXML
    private Button bottone_aggiungiCasello;

    @FXML
    private Button bottone_eliminaCasello;

    @FXML
    private ComboBox<String> combocasello;

    @FXML
    private TextField txtRiferimentoAutostrada;

    @FXML
    private TextField txtkm;
    
    public void initialize() {
    	elenco_autostrade.setAll(AutostradaController.getInstance().getAllAutostrade());
    	elenco_autostrade.sort(null);//viene mantenuto l'ordine naturale degli elementi
    	comboautostrada.setItems(elenco_autostrade);
    	
    	elenco_caselli.setAll(CaselloController.getInstance().getAllCaselli());
    	elenco_caselli.sort(null);//viene mantenuto l'ordine naturale degli elementi
    	combocasello.setItems(elenco_caselli);
    }

    @FXML
    void aggiungi_autostrada(ActionEvent event) {
    	
    	if(txtautostrada.getText().equals("")|txttariffa.getText().equals("")) {
    		Alert alert = new Alert(AlertType.ERROR, "Inserire l'autostrada da aggiungere e la relativa tariffa.");
		    alert.showAndWait();
    	}
    	else {
    		if (AutostradaController.getInstance().verificaAutostrada(txtautostrada.getText())) {
    			Alert alert = new Alert(AlertType.ERROR, "L'autostrada inserita esiste già. Riprovare.");
    		    alert.showAndWait();
    		}
    		else {
    			AutostradaController.getInstance().aggiungiAutostrada(txtautostrada.getText(), Float.parseFloat(txttariffa.getText()));
    			Alert alert = new Alert(AlertType.CONFIRMATION, "L'autostrada è stata inserita correttamente.");
    		    alert.showAndWait();
    		    initialize();
    		    txtautostrada.setText("");
    		    txttariffa.setText("");
    		}
    	}

    }

    @FXML
    void aggiungi_casello(ActionEvent event) {
    	if(txtcasello.getText().equals("")|txtRiferimentoAutostrada.getText().equals("")|txtkm.getText().equals("")) {
    		Alert alert = new Alert(AlertType.ERROR, "Inserire il casello da aggiungere con relativa autostrada e km di riferimento.");
		    alert.showAndWait();
    	}
    	else {
    		if (!CaselloController.getInstance().getCasello(txtcasello.getText()).getNome().equals("")) {
    			Alert alert = new Alert(AlertType.ERROR, "Il casello inserito esiste già. Riprovare.");
    		    alert.showAndWait();
    		} else if (!AutostradaController.getInstance().verificaAutostrada(txtRiferimentoAutostrada.getText())) {
    			       Alert alert = new Alert(AlertType.ERROR, "L'Autostrada a cui fa riferimento il casello non esiste. Aggiungere prima l'autostrada e successivamente i relativi caselli.");
    		           alert.showAndWait();
    		       } else {
    			           CaselloController.getInstance().aggiungiCasello(AutostradaController.getInstance().getAutostrada(txtRiferimentoAutostrada.getText()).getId(), txtcasello.getText(), Integer.parseInt(txtkm.getText()));
    			           Alert alert = new Alert(AlertType.CONFIRMATION, "Il casello è stato inserito correttamente.");
    		               alert.showAndWait();
    		               initialize();
    		               txtcasello.setText("");
    		               txtRiferimentoAutostrada.setText("");
    		               txtkm.setText("");
    		          }
    	}

    }

    @FXML
    void elimina_autostrada(ActionEvent event) {
    	
    	if(comboautostrada.getValue()==null) {
    		Alert alert = new Alert(AlertType.ERROR, "Selezionare l'autostrada da eliminare.");
		    alert.showAndWait();
    	}
    	else {
    			AutostradaController.getInstance().eliminaAutostrada(comboautostrada.getValue());
    			Alert alert = new Alert(AlertType.CONFIRMATION, "L'autostrada è stata eliminata correttamente.");
    		    alert.showAndWait();
    		    initialize();
    		    comboautostrada.setValue(null);
    	}

    }

    @FXML
    void elimina_casello(ActionEvent event) {
    	if(combocasello.getValue()==null) {
    		Alert alert = new Alert(AlertType.ERROR, "Selezionare il casello da eliminare.");
		    alert.showAndWait();
    	}
    	else {
    			CaselloController.getInstance().eliminaCasello(combocasello.getValue());
    			Alert alert = new Alert(AlertType.CONFIRMATION, "Il casello è stato eliminato correttamente.");
    		    alert.showAndWait();
    		    initialize();
    		    combocasello.setValue(null);
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
