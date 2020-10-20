package controller.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import model.Admin;
import model.AdminCDao;

public class newpasswordContr implements Initializable{
    @FXML
    private PasswordField Nvpass;
    @FXML
    private PasswordField confirmeNvpass;
    @FXML
    private Button Annulerpass;
    @FXML
    private Button Validerpass;
    @FXML
    private Label cniadmin;
    @FXML
    private Label passErr;
    private AdminCDao adD;
    private Admin ad;
    @FXML
    void AnnulerPassAction(ActionEvent event) {
    	Annulerpass.getScene().getWindow().hide();
		Stage home=new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/LoginMain.fxml"));
			Scene scene=new Scene(root);
			home.setScene(scene);
			home.show();
			home.setTitle("Kech Club");
			home.setResizable(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void ValiderpassAction(ActionEvent event) {
      if(confirmeNvpass.getText().equals(Nvpass.getText())) {
    	  adD.updatepassword(cniadmin.getText(),Nvpass.getText());
    	  Validerpass.getScene().getWindow().hide();
      }
      else {
    	  passErr.setText("les passwords ne sont pas les memes");
      }
    }
    public void transferMessage(String message) {
        cniadmin.setText(message);
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cniadmin.setVisible(false);
		adD=new AdminCDao();
	}
}
