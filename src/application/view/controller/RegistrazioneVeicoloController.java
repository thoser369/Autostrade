package application.view.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
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

    @FXML
    void conferma_registrazione_veicolo(ActionEvent event) {
    	//controllo campi vuoti
    	if(txtmarca.getText().equals("")|txtmodello.getText().equals("")|txtassi.getText().equals("")|
    			txtassi.getText().equals("")|txtpeso.getText().equals("")|txtaltezza.getText().equals("")|
    			txtanno.getText().equals("")|txttarga.getText().equals("")|classe.getText().equals("Classe Veicolo"))
    		System.out.println("ciao");
    	
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
