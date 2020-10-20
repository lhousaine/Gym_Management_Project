package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import util.ConnectDB;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class contPrincipalecontroller implements Initializable{
	@FXML
    private Button signup;
    @FXML
    private Button Acceuil;
    @FXML
    private Button Sports;

    @FXML
    private Button Entraineurs;
    @FXML
    private Button Seances;
    @FXML
    private Button Clients;
    @FXML
    private Button Tarifs;
    @FXML
    private Button Payments;
    @FXML
    private Button privilige;
    @FXML
    private Button LogOut;
    @FXML
    private Label adm;
    @FXML
    private AnchorPane homePane;
    private AnchorPane new_scene;
    public void transferMessage(String message) {
        adm.setText(message);
    }
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
	    	 adm.setVisible(false);
			 if(adm.getText().equals("root")){
				 privilige.setDisable(true);
			     }
			 createPage("/view/accueilScene.fxml");
		} 
       @FXML
	    void LogoutAction(ActionEvent event) {
    	 LogOut.getScene().getWindow().hide();
    	   Stage signup =new Stage();
   		try {
   			Parent root = FXMLLoader.load(getClass().getResource("/view/LoginMain.fxml"));
   			Scene scene = new Scene(root);
   			signup.setScene(scene);
   			signup.setResizable(false);
   			signup.show();
   		} catch (IOException e){
   			e.printStackTrace();
   		}
	    }

	public void setNode(Node node) {
		homePane.getChildren().clear();
		homePane.getChildren().add((Node) node);
		FadeTransition ft=new FadeTransition();
		ft.setNode(node);
		ft.setFromValue(0.1);
		ft.setToValue(1);
		ft.setCycleCount(1);
		ft.setAutoReverse(false);
		ft.play();
	}
	private void createPage(String scenepath) {
		try {
			new_scene = FXMLLoader.load(getClass().getResource(scenepath));
			setNode(new_scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	   }
	   @FXML
	    void AcceuilAction(ActionEvent event) {
		    createPage("/view/accueilScene.fxml");
	    }
	  @FXML
	    void ClientsAction(ActionEvent event) {
		    createPage("/view/Client/Clientscene.fxml");
	    }

	    @FXML
	    void EntraineursAction(ActionEvent event) {
	    	createPage("/view/Entraineurs/EntraineurScene.fxml");
	    }

	    @FXML
	    void PaymentsAction(ActionEvent event) {
	    	createPage("/view/PaymentScene.fxml");
	    }

	    @FXML
	    void SeancesAction(ActionEvent event) {
	    	createPage("/view/seances/SeanceScene.fxml");
	    }

	    @FXML
	    void SportsAction(ActionEvent event) {
	    	createPage("/view/Sport/Sports.fxml");
	    }

	    @FXML
	    void TarifsAction(ActionEvent event) {
	    	createPage("/view/tarif/TarifsScene.fxml");
	    }
	    @FXML
	    void priviligeAction(ActionEvent event) {
	 		createPage("/view/Priviliges/PrivilgeScene.fxml");
	    }
    }