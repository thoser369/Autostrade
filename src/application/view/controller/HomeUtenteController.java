package application.view.controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.effect.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeUtenteController {
	BoxBlur shadow = new BoxBlur();
	

    @FXML
    private Button bottone_pedaggio;

    @FXML
    private Button bottone_veicolo;
   
    @FXML
    private Label label_username;

    @FXML
    void aggiungi_veicolo(ActionEvent event) throws IOException {
    	bottone_veicolo.addEventHandler(MouseEvent.MOUSE_ENTERED, 
    		    new EventHandler<MouseEvent>() {
    		        @Override public void handle(MouseEvent e) {
    		            bottone_veicolo.setEffect(shadow);
    		        }});
    	bottone_veicolo.addEventHandler(MouseEvent.MOUSE_EXITED, 
    		    new EventHandler<MouseEvent>() {
    		        @Override public void handle(MouseEvent e) {
    		            bottone_veicolo.setEffect(null);
    		        }
    		});
    	((Node)event.getSource()).getScene().getWindow().hide(); 
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		AnchorPane root=loader.load(getClass().getResource("/application/view/fxml/RegistrazioneVeicolo.fxml").openStream());
		Scene scene = new Scene(root);							
		primaryStage.setScene(scene);
		primaryStage.setTitle("Registrazione Veicolo");
		primaryStage.show();	
    	

    }

    @FXML
    void calcolo_pedaggio(ActionEvent event) {
    	bottone_pedaggio.addEventHandler(MouseEvent.MOUSE_ENTERED, 
    		    new EventHandler<MouseEvent>() {
    		        @Override public void handle(MouseEvent e) {
    		            bottone_pedaggio.setEffect(shadow);
    		        }});
    	bottone_pedaggio.addEventHandler(MouseEvent.MOUSE_EXITED, 
    		    new EventHandler<MouseEvent>() {
    		        @Override public void handle(MouseEvent e) {
    		            bottone_pedaggio.setEffect(null);
    		        }
    		});

    }
    //passaggio di parametri (username)
    public void passaggio_username(String utente) {
      label_username.setText(utente);
    }
}
