package application.view.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private Button bottone_conferma2;

    @FXML
    private Button bottone_indietro2;

    @FXML
    void conferma_registrazione_veicolo(ActionEvent event) {

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
