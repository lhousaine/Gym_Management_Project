package controller.Client;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.C_ClientDao;

public class deleteClientController {

    @FXML
    private TextField ClientCNI;

    @FXML
    private Button Annuler;

    @FXML
    private Button Supprimer;

    @FXML
    void AnnulerAction(ActionEvent event) {
    Annuler.getScene().getWindow().hide();
    }
    @FXML
    void SupprimerAction(ActionEvent event) throws ClassNotFoundException, SQLException {
    	(new C_ClientDao()).deleteClientWithId(ClientCNI.getText());
    	Annuler.getScene().getWindow().hide();
    }
}
