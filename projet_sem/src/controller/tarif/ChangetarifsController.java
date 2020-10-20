package controller.tarif;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Tarifs;
import model.TarifsImpDat;

public class ChangetarifsController implements Initializable{
	ObservableList<String> fld=FXCollections.observableArrayList("Categorie 1","Categorie 2","Categorie 3","Categorie 4");
	ObservableList<String> NbrM=FXCollections.observableArrayList("1 Mois","2 Mois","3 Mois","6 Mois","12 Mois");
    @FXML
    private ComboBox<String> Categoreies;
    @FXML
    private ComboBox<String> NbrMois;
    @FXML
    private TextField prix;
    @FXML
    private Button Annuler;
    @FXML
    private Button Valider;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	  Categoreies.setItems(fld);
	  Categoreies.setValue("Categorie 1");
	  NbrMois.setItems(NbrM);
	  NbrMois.setValue("1 Mois");
	}
    @FXML
    void AnnulerTarifAction(ActionEvent event) {
    	Annuler.getScene().getWindow().hide();
    }
    @FXML
    void ValiderTarifAction(ActionEvent event) {
        Tarifs tr=new Tarifs(NbrMois.getValue(),Categoreies.getValue(),Float.parseFloat(prix.getText()));
    	(new TarifsImpDat()).modifierTarif(tr);
    	Valider.getScene().getWindow().hide();
    }
}

