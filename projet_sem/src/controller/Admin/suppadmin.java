package controller.Admin;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.AdminCDao;
import model.C_ClientDao;

public class suppadmin {

    @FXML
    private Button supprimerad;

    @FXML
    private Button Annuler;

    @FXML
    private TextField idadmin;

    @FXML
    void AnnulerAction(ActionEvent event) {
    Annuler.getScene().getWindow().hide();
    }
    @FXML
    void ValiderAction(ActionEvent event) {
    	(new AdminCDao()).remove(idadmin.getText());
    supprimerad.getScene().getWindow().hide();
    }
}

