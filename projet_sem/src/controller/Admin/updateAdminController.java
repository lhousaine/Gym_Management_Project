package controller.Admin;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class updateAdminController {

    @FXML
    private Button annuler;

    @FXML
    private Button valider;

    @FXML
    private TextField AdminId;

    @FXML
    void AnnulerAction(ActionEvent event) {

    }

    @FXML
    void ValiderAction(ActionEvent event) {
     	Stage home=new Stage();
    		try {
    			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Priviliges/ajouterAdmin.fxml"));
    	         Parent root = loader.load();
    	        ajoutadminctrl scene2 = loader.getController();
    			scene2.transferMessage(AdminId.getText());
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