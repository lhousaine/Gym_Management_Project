package controller.Admin;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Admin;
import model.AdminCDao;
import model.C_ClientDao;
import model.Client;

public class ajoutadminctrl implements Initializable{

    @FXML
    private TextField nameId;

    @FXML
    private TextField surnameId;

    @FXML
    private TextField cniId;

    @FXML
    private TextField telid;

    @FXML
    private TextField emailid;

    @FXML
    private Button annuler;

    @FXML
    private Button valider;

    @FXML
    private PasswordField passadmin;
    private AdminCDao  AdminD;
    public void transferMessage(String message){
        cniId.setText(message);
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	  AdminD=new AdminCDao();
	}
    @FXML
    void hideactadmin(ActionEvent event) {
    	annuler.getScene().getWindow().hide();
    }

    @FXML
    void valideactionadmin(ActionEvent event) {
     Admin ad=new Admin(nameId.getText(),surnameId.getText(),cniId.getText(),telid.getText(),emailid.getText(),passadmin.getText());
    	AdminD.add(ad);
    	valider.getScene().getWindow().hide();
    }

}

