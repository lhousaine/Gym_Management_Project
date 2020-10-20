package controller.Sport;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Sportdaoimp;

public class supprimerSportcont {

    @FXML
    private TextField sportname;

    @FXML
    private Button supprmer;

    @FXML
    private Button annuler;

    @FXML
    void annulerAction(ActionEvent event) {
    	annuler.getScene().getWindow().hide();
    }
    @FXML
    void supprimerClient(ActionEvent event) {
    	(new Sportdaoimp()).supprimersport(sportname.getText());
    	supprmer.getScene().getWindow().hide();
    }
}

