package application.view.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.view.controller.HomeUtenteController;
import application.Main;
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
    	String utente= utentefield.getText();
    	String password=passwordfield.getText();
    	Connection cn;
		//Statement st;
		ResultSet rs;
		String sql;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} 

		// Creo la connessione al database
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/autostrade","root","ciao123abcd");
		// autostrade è il nome del database

		sql = "SELECT nome,cognome FROM utente WHERE username=? and password=?";
		//query
		try {
			PreparedStatement st1=cn.prepareStatement(sql);
			st1.setString(1, utente);
			st1.setString(2, password);
			st1.execute();
			rs=st1.getResultSet();
			if(rs.next()) {
			System.out.println("ok");
			utentefield.setStyle("-fx-border-color:  #4AA02C");
		    passwordfield.setStyle("-fx-border-color:  #4AA02C");
		    FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("/application/view/fxml/HomeUtente.fxml"));
	        AnchorPane root = (AnchorPane) loader.load();
	      Scene scene= new Scene(root);
	      Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
	      window.setScene(scene);
	      window.setTitle("Home");
	      HomeUtenteController controller = 
	    		    loader.<HomeUtenteController>getController();
	    		  controller.passaggio_username(utente);
	      window.show();
			}
			else {
			      utentefield.setStyle("-fx-border-color:  red");
			      passwordfield.setStyle("-fx-border-color:  red");
			      Alert alert = new Alert(AlertType.ERROR, "Credenzili non valide. Inserire i dati corretti.");
			      alert.showAndWait();
			}
		}catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		}
		cn.close(); // chiusura connessione

    }

    @FXML
    void registrazione(ActionEvent event) throws IOException{
    	 FXMLLoader loader = new FXMLLoader();
         loader.setLocation(Main.class.getResource("/application/view/fxml/Registrazione.fxml"));
         AnchorPane root = (AnchorPane) loader.load();
         Scene scene= new Scene(root);
         Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(scene);
         window.setTitle("Registrazione");
         window.show();
       
    }
   
   /* public void setMain(Main main) {
        this.main = main;
    }*/
}
