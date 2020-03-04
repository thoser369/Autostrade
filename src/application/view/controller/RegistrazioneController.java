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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.sql.*;

import application.Main;

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
    private TextField txtdatanascita;
    
    @FXML
    private TextField txtcittanascita;

    @FXML
    private RadioButton ru;

    @FXML
    private RadioButton rd;

    @FXML
    private Button bottone_conferma;
    
    @FXML
    private Button bottone_indietro;
    
   final ToggleGroup gruppo= new ToggleGroup();

    @FXML
    void conferma_registrazione(ActionEvent event) throws SQLException {
    	boolean verifica=true;
    	boolean verifica_password=true;
    	boolean verifica_genere=true;
    	String nome=txtnome.getText();
    	String cognome=txtcognome.getText();
    	String username= txtusername.getText();
    	String password= txtpwd1.getText();
    	String password1=txtpwd2.getText();
        String datanascita=txtdatanascita.getText();
        String cittanascita=txtcittanascita.getText();
        String genere="";
        ru.setToggleGroup(gruppo);
        rd.setToggleGroup(gruppo);
    	String sql1="insert into utente(ID,nome,cognome,genere,citta_nascita,data_nascita,username,password,tipo) values (null,?,?,?,?,?,?,?,?)";
    	Connection cn;
		Statement st;
		ResultSet rs;
		String sql;
		//connessione
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch

		// Creo la connessione al database
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/autostrade","root","ciao123abcd");
		// autostrade è il nome del database

		sql = "SELECT * FROM utente;";
		//query
		try {
			st = cn.createStatement(); // creo sempre uno statement sulla connessione
			rs = st.executeQuery(sql); // faccio la query su uno statement
			while (rs.next() == true) {
				System.out.println(rs.getString("id") + rs.getString("username"));
				String verifica1=rs.getString("username");
				System.out.println(username);
				//x=rs.getInt("id");
				
				//controllo verifica nome utente
				if(username.equals(verifica1)) {
					System.out.println("no");
				    verifica=false;
				    txtusername.setStyle("-fx-border-color: red");
				    Alert alert = new Alert(AlertType.ERROR, "Lo username inserito è gia in uso. Reinserirne un altro.");
					alert.showAndWait();
				    break;
				    }
			}
			//controllo radiobutton
			if (ru.isSelected())
				genere="uomo";
			else if(rd.isSelected())
				genere="donna";
			else {verifica_genere= false;
			      Alert alert = new Alert(AlertType.ERROR, "Inserire il genere");
			      alert.showAndWait();
			      }
			//controllo password
			if (!(password.equals(password1))) {
				verifica_password=false;
				txtpwd1.setStyle("-fx-border-color: red");
				txtpwd2.setStyle("-fx-border-color: red");
				Alert alert = new Alert(AlertType.ERROR, "Le due password non corrispondono. Riprovare.");
				alert.showAndWait();

			}
			if (verifica && verifica_password && verifica_genere) {
				txtnome.setStyle("-fx-border-color:  #4AA02C");
				txtcognome.setStyle("-fx-border-color:  #4AA02C");
				txtusername.setStyle("-fx-border-color:  #4AA02C");
				txtpwd1.setStyle("-fx-border-color:  #4AA02C");
				txtpwd2.setStyle("-fx-border-color:  #4AA02C");
				txtdatanascita.setStyle("-fx-border-color:  #4AA02C");
				txtcittanascita.setStyle("-fx-border-color:  #4AA02C");
				//System.out.println(x);
				PreparedStatement st1=cn.prepareStatement(sql1);
				//st1.setInt(1, x);
				st1.setString(1, nome);
				st1.setString(2, cognome);
				st1.setString(3, genere);
				st1.setString(4, cittanascita);
				st1.setString(5, datanascita);
				st1.setString(6, username);
				st1.setString(7, password);
				st1.setString(8, "viaggiatore");
				st1.execute();
				System.out.println("ok");
			}
			
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
			txtdatanascita.setStyle("-fx-border-color:  red");
			Alert alert = new Alert(AlertType.ERROR, "Il formato data non è inserito correttamente.Riprovare.");
			alert.showAndWait();
		} // fine try-catch
		cn.close(); // chiusura connessione

    }
    

    @FXML
    void indietro(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/application/view/fxml/Login.fxml"));
        AnchorPane root = (AnchorPane) loader.load();
      Scene scene= new Scene(root);
      Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.setTitle("Login");
      window.show();
    }

}