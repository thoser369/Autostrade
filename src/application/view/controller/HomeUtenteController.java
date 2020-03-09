package application.view.controller;

import java.io.IOException;

import application.controller.UtenteController;
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
	
	public static boolean p=false;//visibilità bottone per admin
	public static String utente="";
	public static String pwd="";
	
	BoxBlur shadow = new BoxBlur();
	

    @FXML
    private Button bottone_pedaggio;

    @FXML
    private Button bottone_veicolo;
   
    @FXML
    private Label label_username;
  
    @FXML
    private Button bottone_impostazioni;
    
    public void initialize() {
    	
    	label_username.setText(HomeUtenteController.utente);
    	bottone_impostazioni.setVisible(false);
    	if(HomeUtenteController.p) 
    		bottone_impostazioni.setVisible(true);
    		
    }
   

    @FXML
    void impostazioni(ActionEvent event) throws IOException {
    	((Node)event.getSource()).getScene().getWindow().hide(); 
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		AnchorPane root=loader.load(getClass().getResource("/application/view/fxml/Impostazioni.fxml").openStream());
		Scene scene = new Scene(root);							
		primaryStage.setScene(scene);
		primaryStage.setTitle("Impostazioni");
		primaryStage.show();
    }
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
    void calcolo_pedaggio(ActionEvent event) throws IOException {
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
    	((Node)event.getSource()).getScene().getWindow().hide(); 
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		AnchorPane root=loader.load(getClass().getResource("/application/view/fxml/CalcoloDelPedaggio.fxml").openStream());
		Scene scene = new Scene(root);							
		primaryStage.setScene(scene);
		primaryStage.setTitle("Calcolo del pedaggio");
		primaryStage.show();
    }
    
    @FXML
    void logout(ActionEvent event) throws IOException {
         HomeUtenteController.p= false;
    	((Node)event.getSource()).getScene().getWindow().hide(); 
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		AnchorPane root=loader.load(getClass().getResource("/application/view/fxml/Login.fxml").openStream());
		Scene scene = new Scene(root);							
		primaryStage.setScene(scene);
		primaryStage.setTitle("Login");
		primaryStage.show();

    }
   
    //passaggio di parametri (username)
    public void passaggio_username(String utente, String pwd) {
      HomeUtenteController.utente=utente;
      HomeUtenteController.pwd=pwd;
      label_username.setText(HomeUtenteController.utente);
      if(UtenteController.getInstance().login(utente, pwd).getTipo().equals("utente")) {
    	  System.out.println("ciao");
    	  bottone_impostazioni.setVisible(false);
    	  }
      else {
    	  HomeUtenteController.p= true;
    	  bottone_impostazioni.setVisible(true);          
      }
    }
}
