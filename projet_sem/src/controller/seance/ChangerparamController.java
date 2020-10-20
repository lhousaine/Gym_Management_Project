package controller.seance;

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
import model.Tarifs;
import model.TarifsImpDat;
import model.seance;
import model.seancedaoimp;

public class ChangerparamController implements Initializable{

    @FXML
    private TextField sports;

    @FXML
    private TextField entraineur;

    @FXML
    private Button annuler;

    @FXML
    private Button valider;

    @FXML
    private ChoiceBox<String> temps_de_journe;

    @FXML
    private ChoiceBox<String> jour;
    ObservableList<String> jours=FXCollections.observableArrayList("Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche");
	ObservableList<String> temps=FXCollections.observableArrayList("09-12","13-16","16-19","19-22");
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		jour.setItems(jours);
		jour.setValue("Lundi");
		 temps_de_journe.setItems(temps);
		temps_de_journe.setValue("09-12");
	}
    @FXML
    void ModificationAnnulerAction(ActionEvent event) {
    	annuler.getScene().getWindow().hide();
    }

    @FXML
    void ModificationVliderAction(ActionEvent event) {
    	  seance sc=new seance(sports.getText(),temps_de_journe.getValue(),jour.getValue(),entraineur.getText());
      	(new seancedaoimp()).modifierSeance(sc);
      	valider.getScene().getWindow().hide();
    }
}

