package controller.Client;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.C_ClientDao;

public class SupprimerClientcontr implements Initializable{

    @FXML
    private TextField cnitext;

    @FXML
    private Button annuler;

    @FXML
    private Button valider;
     private C_ClientDao Cl;
    @FXML
    void AnnulerAction(ActionEvent event){
     annuler.getScene().getWindow().hide();
    }
    @FXML
    void ValiderAction(ActionEvent event) throws ClassNotFoundException, SQLException {
           (new C_ClientDao()).deleteClientWithId(cnitext.getText());
    	   valider.getScene().getWindow().hide();
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
}