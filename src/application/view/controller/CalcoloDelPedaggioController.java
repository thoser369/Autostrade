package application.view.controller;

import java.io.IOException;

import application.controller.CaselloController;
import application.controller.PedaggioController;
import application.controller.SceltaClassePedaggioController;
import application.controller.UtenteController;
import application.controller.VeicoloController;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CalcoloDelPedaggioController {
	
	ObservableList<String> elenco_caselli = FXCollections.observableArrayList();
	ObservableList<String> elenco_veicoli = FXCollections.observableArrayList();

    @FXML
    private Label label_classe;

    @FXML
    private Button bottone_pedaggio;

    @FXML
    private TextField txtpedaggio;

    @FXML
    private Button bottone_indietro;

    @FXML
    private ComboBox<String> combocasellopartenza;
    
    @FXML
    private ComboBox<String> combocaselloarrivo;

    @FXML
    private ComboBox<String> comboveicolo;

    public void initialize() {
    	elenco_caselli.setAll(CaselloController.getInstance().getAllCaselli());
    	elenco_caselli.sort(null);//viene mantenuto l'ordine naturale degli elementi
    	elenco_veicoli.setAll(PedaggioController.getInstance().getAllTarghe(UtenteController.getInstance().login(HomeUtenteController.utente, HomeUtenteController.pwd).getId()));
    	elenco_veicoli.sort(null);//viene mantenuto l'ordine naturale degli elementi
    	combocasellopartenza.setItems(elenco_caselli);
    	combocaselloarrivo.setItems(elenco_caselli);
    	comboveicolo.setItems(elenco_veicoli);
    	
    	label_classe.setText(SceltaClassePedaggioController.getInstance().getGestione().getNome());
    	
    	
    }
    @FXML
    void calcolo_pedaggio(ActionEvent event) {
    	
    	int distanza=0;
    	float pedaggio, tariffaunitaria, tariffaambientale, tariffaautostrada=0;
    	
    	if(combocasellopartenza.getValue()==null|combocaselloarrivo.getValue()==null|comboveicolo.getValue()==null) {
    		Alert alert = new Alert(AlertType.ERROR, "Selezionare i caselli di partenza e di arrivo e la targa del veicolo per calcolare il pedaggio.");
		    alert.showAndWait();
    	} else {
    		if(CaselloController.getInstance().getCasello(combocasellopartenza.getValue()).getId_autostrada()!=
    				CaselloController.getInstance().getCasello(combocaselloarrivo.getValue()).getId_autostrada()) {
    			Alert alert = new Alert(AlertType.ERROR, "I caselli selezionati si trovano su due autostrade differenti. Selezionare due caselli della stessa autostrada.");
    		    alert.showAndWait();
    		}
    		else {
    			distanza=(CaselloController.getInstance().getCasello(combocasellopartenza.getValue()).getKm()) - 
    					(CaselloController.getInstance().getCasello(combocaselloarrivo.getValue()).getKm());
    			if (distanza<0) distanza = distanza * (-1);
    			if(label_classe.getText().equals("Classe Unitaria")) {
    				tariffaunitaria=PedaggioController.getInstance().getTariffaVeicolo(VeicoloController.getInstance().getVeicolo(comboveicolo.getValue()).getId_classeveicolo()).getTariffa();
    				tariffaautostrada=PedaggioController.getInstance().getTariffaAutostrada(CaselloController.getInstance().getCasello(combocasellopartenza.getValue()).getId_autostrada()).getTariffa();
    				pedaggio= distanza * ( tariffaunitaria + tariffaautostrada);
    				//aggiunta iva 22%
    				pedaggio= pedaggio + (pedaggio *22 / 100);
    				pedaggio = (float) (Math.round(pedaggio * 100) / 100.0);
    				txtpedaggio.setText(Float.toString(pedaggio));
    			} else {
    				tariffaunitaria=PedaggioController.getInstance().getTariffaVeicolo(VeicoloController.getInstance().getVeicolo(comboveicolo.getValue()).getId_classeveicolo()).getTariffa();
    				tariffaambientale=PedaggioController.getInstance().getTariffaAmbientale(VeicoloController.getInstance().getVeicolo(comboveicolo.getValue()).getId_classeambientale()).getTariffa();
    				pedaggio= distanza * ( tariffaunitaria + tariffaambientale);
    				//aggiunta iva 22%
    				pedaggio= pedaggio + (pedaggio *22 / 100);
    				pedaggio = (float) (Math.round(pedaggio * 100) / 100.0);
    				txtpedaggio.setText(Float.toString(pedaggio));
    			}
    		}
    	}

    }

    @FXML
    void indietro(ActionEvent event) throws IOException {
    	((Node)event.getSource()).getScene().getWindow().hide(); 
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		AnchorPane root=loader.load(getClass().getResource("/application/view/fxml/HomeUtente.fxml").openStream());
		Scene scene = new Scene(root);							
		primaryStage.setScene(scene);
		primaryStage.setTitle("Home");
		primaryStage.show();

    }

}
