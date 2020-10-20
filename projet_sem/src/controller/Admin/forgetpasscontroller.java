package controller.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.LoginContrller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Admin;
import model.AdminCDao;

public class forgetpasscontroller implements Initializable{

    @FXML
    private TextField adCNI;

    @FXML
    private TextField adname;

    @FXML
    private TextField adsurname;

    @FXML
    private TextField ademail;

    @FXML
    private Button adannuler;

    @FXML
    private Button adenvoyer;

    @FXML
    private TextField adtel;
    private AdminCDao adD;
    private Admin ad;
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		adD=new AdminCDao();
	}
    @FXML
    void AdannulerAction(ActionEvent event) {
      adannuler.getScene().getWindow().hide();
    }
    @FXML
    void AdenvoyerAction(ActionEvent event) throws IOException {
    	ad=new Admin(adname.getText(),adsurname.getText(),adCNI.getText(),adtel.getText(),ademail.getText());
    	Stage home=new Stage();
    	if(adD.selectAdmins(ad)==1) {
        	    adenvoyer.getScene().getWindow().hide();
					 FXMLLoader loader = new FXMLLoader(getClass().getResource("/view//view/Priviliges/valideNewpass.fxml"));
			         Parent root = loader.load();
			         newpasswordContr scene2 = loader.getController();
					scene2.transferMessage(adCNI.getText());
					Scene scene=new Scene(root);
					home.setScene(scene);
					home.setTitle("Kech Club");
					home.setResizable(true);
					home.show(); 
          }else {
        	  FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoginMain.fxml"));
 	         Parent root = loader.load();
 	         LoginContrller scene2 = loader.getController();
 			 scene2.transferMessage("vous avez entrée des informations incorrects");
 			Scene scene=new Scene(root);
			home.setScene(scene);
			home.setTitle("Kech Club");
			home.setResizable(true);
			home.show();
        	  adenvoyer.getScene().getWindow().hide();
          }
    }
}
