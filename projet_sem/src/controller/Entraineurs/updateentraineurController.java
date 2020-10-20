package controller.Entraineurs;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class updateentraineurController {

    @FXML
    private Button annuler;

    @FXML
    private Button valider;

    @FXML
    private TextField EntraineurId;

    @FXML
    void AnnulerAction(ActionEvent event) {
       annuler.getScene().getWindow().hide();
    }
    @FXML
    void ValiderAction(ActionEvent event) {
    	Stage home=new Stage();
		try {
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Entraineurs/AjoutNouveuEntraineur.fxml"));
	         Parent root = loader.load();
			AjoutEntraineurAction scene2 = loader.getController();
			scene2.transferMessage(EntraineurId.getText());
			Scene scene=new Scene(root);
			home.setScene(scene);
			home.setTitle("Kech Club");
			home.setResizable(true);
			home.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
