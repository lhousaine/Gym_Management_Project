package controller.Sport;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.C_ClientDao;
import model.Sportdaoimp;

public class updateSportController {
    @FXML
    private Button annuler;
    @FXML
    private Button valider;
    @FXML
    private TextField Sportname;
    @FXML
    void AnnulerAction(ActionEvent event){
     annuler.getScene().getWindow().hide();
    }
    @FXML
    void ValiderAction(ActionEvent event){
    	Stage home=new Stage();
		try {
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Sport/newSportScene.fxml"));
	         Parent root = loader.load();
	         newsportcontroller scene2 = loader.getController();
			scene2.transferMessage(Sportname.getText());
			Scene scene=new Scene(root);
			home.setScene(scene);
			home.setTitle("Kech Club");
			home.setResizable(true);
			home.show();
			(new Sportdaoimp()).supprimersport(Sportname.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
     valider.getScene().getWindow().hide();
    }
}

