package controller;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ResourceBundle;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Admin;
import model.AdminCDao;
import util.ConnectDB;

public class LoginContrller implements Initializable{
	@FXML
    private TextField Username;
    @FXML
    private PasswordField Userpassword;
    @FXML
    private Button login;
    @FXML
    private ImageView idloading;
    @FXML
    private Button ForgetPass;
    @FXML
    private Label newpassError;
   private Admin A;
   private AdminCDao Ad;
   public void transferMessage(String message) {
	   newpassError.setText(message);
   }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
       login.setDisable(false);
       Userpassword.setDisable(false);
       idloading.setVisible(false);
	   A=new Admin();
	   Ad=new AdminCDao();
	}
     public void LogIn() {
    	 idloading.setVisible(true);
    	 PauseTransition pt=new PauseTransition();
    	 A.setName(Username.getText());
    	 A.setPassword(Userpassword.getText());
    			pt.setOnFinished(ev -> {
    					if(Ad.select(A)==1){
    						toprincipaleview(A);
    					}
    					else if(Ad.tableRowNumber(A)==0){
    							if(Username.getText().equals("admin") && Userpassword.getText().equals("admin")) {
    								toprincipaleview(A);
    							}
    							else {
    								Alert alert=new Alert(Alert.AlertType.ERROR);
    								alert.setHeaderText(null);
    								alert.setContentText("Username or Password is incorrecte");
    								alert.show();
    							}
    					       } 
    					else {
    						Alert alert=new Alert(Alert.AlertType.ERROR);
    						alert.setHeaderText(null);
    						alert.setContentText("Username or Password is incorrecte");
    						alert.show();
    					}
    				
    			});
    			pt.play();
     }
   @FXML
   void LoginAction(ActionEvent event) {
	   LogIn();
   }

   @FXML
   void ForgetPassAction(ActionEvent event){
		Stage home=new Stage();
		try {
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Priviliges/ForgetPassword.fxml"));
	         Parent root = loader.load();
			Scene scene=new Scene(root);
			home.setScene(scene);
			home.setTitle("Kech Club");
			home.setResizable(true);
			home.show();
			ForgetPass.getScene().getWindow().hide();
		} catch (IOException e) {
			e.printStackTrace();
		}
   }
   @FXML
   void ActionLogin(KeyEvent event) {
     if(event.getCode()==KeyCode.ENTER) {
    	 LogIn();
     }
   }
   public void toprincipaleview(Admin a) {
	   login.getScene().getWindow().hide();
		Stage home=new Stage();
		try {
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/principaleView.fxml"));
	         Parent root = loader.load();
	         contPrincipalecontroller scene2 = loader.getController();
			scene2.transferMessage(a.getName());
			Scene scene=new Scene(root);
			home.setScene(scene);
			home.show();
			home.setTitle("Kech Club");
			home.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
   }
}
