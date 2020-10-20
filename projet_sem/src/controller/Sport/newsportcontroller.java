package controller.Sport;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Admin;
import model.Sport;
import model.Sportdaoimp;

public class newsportcontroller implements Initializable{
    @FXML
    private TextField namesp;

    @FXML
    private TextField entraineur;

    @FXML
    private Button annuler;

    @FXML
    private Button valider;
    private Sportdaoimp spd;
    @FXML
    private ChoiceBox<String> namecategorie;
    ObservableList<String> categories=FXCollections.observableArrayList("Categorie 1","Categorie 2","Categorie 3","Categorie");
	public void transferMessage(String message){
		namesp.setText(message);
	}
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		namecategorie.setItems(categories);
		namecategorie.setValue("Categorie 1");
		spd=new Sportdaoimp();
	}
    @FXML
    void AnnulerAction(ActionEvent event) {
    	annuler.getScene().getWindow().hide();
    }
    @FXML
    void ValiderAction(ActionEvent event) {
    	 Sport sp=new Sport(namesp.getText(),entraineur.getText(),namecategorie.getValue().toString());
     	spd.insert(sp);
     	valider.getScene().getWindow().hide();
    }
}
