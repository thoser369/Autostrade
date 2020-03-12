package application.view.controller;

import java.io.IOException;
import java.sql.SQLException;

import application.view.controller.HomeUtenteController;
import application.controller.UtenteController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
	
	UtenteController uc= new UtenteController();
	@FXML
    private TextField utentefield;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private Button bottone_login;

    @FXML
    private Button bottone_registrati;

    @FXML
    void initialize(ActionEvent event) throws SQLException, IOException {
    	if(uc.verifica_utente_password(utentefield.getText(), passwordfield.getText())){
    	//passagio view home
    	((Node)event.getSource()).getScene().getWindow().hide(); 
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		AnchorPane root=loader.load(getClass().getResource("/application/view/fxml/HomeUtente.fxml").openStream());
		Scene scene = new Scene(root);							
		primaryStage.setScene(scene);
		primaryStage.setTitle("Home");
		primaryStage.show();	
		//settaggio label nome utente con passaggio di parametri
	    HomeUtenteController controller = loader.<HomeUtenteController>getController();
	    controller.passaggio_username(utentefield.getText(), passwordfield.getText());
	    } else {
	    	//parte grafica 
	    	utentefield.setStyle("-fx-border-color: red");
	    	passwordfield.setStyle("-fx-border-color: red");
	         Alert alert = new Alert(AlertType.ERROR, "Username o password errati. Riprovare.");
	          alert.showAndWait();
	    }
    }

    @FXML
    void registrazione(ActionEvent event) throws IOException{
    	((Node)event.getSource()).getScene().getWindow().hide(); 
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		AnchorPane root=loader.load(getClass().getResource("/application/view/fxml/Registrazione.fxml").openStream());
		Scene scene = new Scene(root);							
		primaryStage.setScene(scene);
		primaryStage.setTitle("Registrazione");
		primaryStage.show();	
       
    }
   
}
