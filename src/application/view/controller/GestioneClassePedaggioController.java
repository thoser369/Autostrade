package application.view.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GestioneClassePedaggioController {

    @FXML
    private Button bottone_indietro;

    @FXML
    private TextField txtclasse;

    @FXML
    private Button bottone_aggiorna;

    @FXML
    private Label label_classeunitaria;

    @FXML
    private MenuButton classe;

    @FXML
    private MenuItem classe_unitaria;

    @FXML
    private MenuItem classe_ambientale;

    @FXML
    private Label label_classeambientale;

    @FXML
    void classe_ambientale_selezionata(ActionEvent event) {

    }

    @FXML
    void classe_unitaria_selezionata(ActionEvent event) {

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
