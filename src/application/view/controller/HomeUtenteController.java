package application.view.controller;

import java.io.IOException;

import application.controller.UtenteController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeUtenteController {
	
	public static boolean admin_loggato=false;//visibilità bottone per admin
	public static String utente="";
	public static String pwd="";
	
	

    @FXML
    private Button bottone_pedaggio;

    @FXML
    private Button bottone_veicolo;
   
    @FXML
    private Label label_username;
  
    @FXML
    private Button bottone_impostazioni;
    
    @FXML
    private Label tipo_utente;
    
    public void initialize() {
    	
    	label_username.setText(HomeUtenteController.utente);
    	bottone_impostazioni.setVisible(false);
    	tipo_utente.setText("Utente");
    	if(HomeUtenteController.admin_loggato) {
    		bottone_impostazioni.setVisible(true);
    	    tipo_utente.setText("Amministratore");
    	    }
    		
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
         HomeUtenteController.admin_loggato= false;
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
    	  bottone_impostazioni.setVisible(false);
    	  tipo_utente.setText("Utente");
    	  }
      else {
    	  HomeUtenteController.admin_loggato= true;
    	  bottone_impostazioni.setVisible(true);  
    	  tipo_utente.setText("Amministratore");
      }
    }
}
