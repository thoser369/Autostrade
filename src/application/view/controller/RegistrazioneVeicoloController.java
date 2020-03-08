package application.view.controller;

import java.io.IOException;

import application.controller.VeicoloController;
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

public class RegistrazioneVeicoloController {

    @FXML
    private TextField txtmarca;

    @FXML
    private TextField txtmodello;

    @FXML
    private TextField txtassi;

    @FXML
    private TextField txtpeso;

    @FXML
    private TextField txtaltezza;

    @FXML
    private TextField txtanno;

    @FXML
    private TextField txttarga;

    @FXML
    private MenuButton classe;
   
    @FXML
    private MenuItem classeA;

    @FXML
    private MenuItem classeB;

    @FXML
    private MenuItem classeC;

    @FXML
    private MenuItem classe4;

    @FXML
    private MenuItem classe5;

    
    @FXML
    private Button bottone_conferma2;

    @FXML
    private Button bottone_indietro2;
   
    @FXML
    void classe4_selezionata(ActionEvent event) {
       classe.setText("Classe 4");
    }

    @FXML
    void classe5_selezionata(ActionEvent event) {
    	classe.setText("Classe 5");
    }

    @FXML
    void classeA_selezionata(ActionEvent event) {
    	classe.setText("Classe A");
    }

    @FXML
    void classeB_selezionata(ActionEvent event) {
    	classe.setText("Classe B");
    }

    @FXML
    void classeC_selezionata(ActionEvent event) {
    	classe.setText("Classe C");
    }

    VeicoloController rvc= new VeicoloController();
    
    @FXML
    void conferma_registrazione_veicolo(ActionEvent event) throws IOException {
    	//controllo campi vuoti
    	if(txtmarca.getText().equals("")|txtmodello.getText().equals("")|
    			txtpeso.getText().equals("")|txtaltezza.getText().equals("")|
    			txtanno.getText().equals("")|txttarga.getText().equals("")|classe.getText().equals("Classe Veicolo")) {
    		Alert alert = new Alert(AlertType.ERROR, "Riempire tutti i campi.");
		    alert.showAndWait();
		}
    	else {
    		if (classe.getText().equals("Classe A")&& Integer.parseInt(txtaltezza.getText())<=130)
    			txtassi.setText("1");
    		else if(classe.getText().equals("Classe B")&& Integer.parseInt(txtaltezza.getText())>130)
    			 txtassi.setText("2");
    		     else if(classe.getText().equals("Classe 3")) txtassi.setText("3");
    		          else if(classe.getText().equals("Classe 4")) txtassi.setText("4");
    		               else txtassi.setText("5 o piu");
    		if(!rvc.verifica_presenza_veicolo(txttarga.getText())) {
    			  txtmarca.setStyle("-fx-border-color:  #4AA02C");
			      txtmodello.setStyle("-fx-border-color:  #4AA02C");
			      txtassi.setStyle("-fx-border-color:  #4AA02C");
			      txtpeso.setStyle("-fx-border-color:  #4AA02C");
			      txtaltezza.setStyle("-fx-border-color:  #4AA02C");
			      txtanno.setStyle("-fx-border-color:  #4AA02C");
			      txttarga.setStyle("-fx-border-color:  #4AA02C");
			      rvc.aggiungi_veicolo(VeicoloController.getInstance().getIDUtente(HomeUtenteController.utente), txtmodello.getText(), txtmarca.getText(), txttarga.getText(), 
			    		  txtpeso.getText(), txtanno.getText(), Integer.parseInt(txtaltezza.getText()), txtassi.getText());
			      Alert alert = new Alert(AlertType.CONFIRMATION, "Registrazione del veicolo avvenuta correttamente.");
			      alert.showAndWait();
    	          ((Node)event.getSource()).getScene().getWindow().hide(); 
    	  		  Stage primaryStage = new Stage();
    	  		  FXMLLoader loader = new FXMLLoader();
    	  		  AnchorPane root=loader.load(getClass().getResource("/application/view/fxml/HomeUtente.fxml").openStream());
    	  		  Scene scene = new Scene(root);							
    	  		  primaryStage.setScene(scene);
    	  		  primaryStage.setTitle("Home");
    	  		 // HomeUtenteController.label_username.setText(HomeUtenteController.utente);
    	  		  primaryStage.show();	
    		} else {
    			txttarga.setStyle("-fx-border-color: red");
		         Alert alert = new Alert(AlertType.ERROR, "La targa inserita non è corretta. Riprovare.");
		         alert.showAndWait();
    		}
    	}
    	
    }

    @FXML
    void indietro2(ActionEvent event) throws IOException {
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
