package application.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

import application.controller.UtenteController;

public class RegistrazioneController {

    @FXML
    private TextField txtnome;

    @FXML
    private TextField txtcognome;

    @FXML
    private TextField txtusername;

    @FXML
    private PasswordField txtpwd1;

    @FXML
    private PasswordField txtpwd2;

    @FXML
    private Button bottone_conferma;
    
    @FXML
    private Button bottone_indietro;
    
    UtenteController uc= new UtenteController();

    @FXML
    void conferma_registrazione(ActionEvent event) throws SQLException, IOException {
    	String nome=txtnome.getText();
    	String cognome=txtcognome.getText();
    	String username= txtusername.getText();
    	String password= txtpwd1.getText();
    	String password1=txtpwd2.getText();
    	
    	//controllo campi vuoti
    	
    	if(nome.equals("")|cognome.equals("")|username.equals("")|password.equals("")) {
			Alert alert = new Alert(AlertType.ERROR, "Riempire tutti i campi.");
			alert.showAndWait();
    	}
    	
    	//controllo password
    	
    	else if (!(password.equals(password1))) {
			txtpwd1.setStyle("-fx-border-color: red");
			txtpwd2.setStyle("-fx-border-color: red");
			Alert alert = new Alert(AlertType.ERROR, "Le due password non corrispondono. Riprovare.");
			alert.showAndWait();
		}
    	//verifica campo username e/o inserimento utente
    	else { 
    		if(!uc.verifica_utente(username)){
    		      txtnome.setStyle("-fx-border-color:  #4AA02C");
			      txtcognome.setStyle("-fx-border-color:  #4AA02C");
			      txtusername.setStyle("-fx-border-color:  #4AA02C");
			      txtpwd1.setStyle("-fx-border-color:  #4AA02C");
			      txtpwd2.setStyle("-fx-border-color:  #4AA02C");
			      //inserimento utente
    	          uc.registrazione(nome, cognome, username, password);
			      Alert alert = new Alert(AlertType.CONFIRMATION, "Registrazione avvenuta correttamente. Accedere per continuare.");
			      alert.showAndWait();
			      //passaggio view Login
    	          ((Node)event.getSource()).getScene().getWindow().hide(); 
    	  		  Stage primaryStage = new Stage();
    	  		  FXMLLoader loader = new FXMLLoader();
    	  		  AnchorPane root=loader.load(getClass().getResource("/application/view/fxml/Login.fxml").openStream());
    	  		  Scene scene = new Scene(root);							
    	  		  primaryStage.setScene(scene);
    	  		  primaryStage.setTitle("Login");
    	  		  primaryStage.show();	
    	    } else {
    		         txtusername.setStyle("-fx-border-color: red");
			         Alert alert = new Alert(AlertType.ERROR, "Il nome utente risulta gia in uso. Riprovare.");
			          alert.showAndWait();
    	           }
    	}  
    }
    

    @FXML
    void indietro(ActionEvent event) throws IOException {
    	((Node)event.getSource()).getScene().getWindow().hide(); 
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		AnchorPane root=loader.load(getClass().getResource("/application/view/fxml/Login.fxml").openStream());
		Scene scene = new Scene(root);							
		primaryStage.setScene(scene);
		primaryStage.setTitle("Login");
		primaryStage.show();
    }

}