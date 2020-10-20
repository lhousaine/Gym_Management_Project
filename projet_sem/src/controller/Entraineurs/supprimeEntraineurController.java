package controller.Entraineurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Entraineur;
import model.EntraineurDEmp;

public class supprimeEntraineurController {

    @FXML
    private TextField EntraineurId;

    @FXML
    private Button Annuler;

    @FXML
    private Button Supprimer;

    @FXML
    void AnnulerAction(ActionEvent event) {
    	Annuler.getScene().getWindow().hide();
    }
    @FXML
    void SupprimerAction(ActionEvent event) {
    	Entraineur ent=new Entraineur();
    	ent.setCni((EntraineurId.getText()));
    	EntraineurDEmp entd=new EntraineurDEmp();
    	entd.delete(ent);
    	Supprimer.getScene().getWindow().hide();
    }
}

