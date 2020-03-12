package application.view.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AutostradeECaselliController {

	@FXML
    private Button bottone_indietro;

    @FXML
    private TextField txtautostrada;

    @FXML
    private Button bottone_aggiungiAutostrada;

    @FXML
    private Button bottone_eliminaAutostrada;

    @FXML
    private ComboBox<?> comboautostrada;

    @FXML
    private TextField txttariffa;

    @FXML
    private TextField txtcasello;

    @FXML
    private Button bottone_aggiungiCasello;

    @FXML
    private Button bottone_eliminaCasello;

    @FXML
    private ComboBox<?> combocasello;

    @FXML
    private TextField txtRiferimentoAutostrada;

    @FXML
    private TextField txtkm;

    @FXML
    void aggiungi_autostrada(ActionEvent event) {

    }

    @FXML
    void aggiungi_casello(ActionEvent event) {

    }

    @FXML
    void elimina_autostrada(ActionEvent event) {

    }

    @FXML
    void elimina_casello(ActionEvent event) {

    }

    @FXML
    void indietro(ActionEvent event) throws IOException {
    	((Node)event.getSource()).getScene().getWindow().hide(); 
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		AnchorPane root=loader.load(getClass().getResource("/application/view/fxml/Impostazioni.fxml").openStream());
		Scene scene = new Scene(root);							
		primaryStage.setScene(scene);
		primaryStage.setTitle("Impostazioni");
		primaryStage.show();

    }

}
