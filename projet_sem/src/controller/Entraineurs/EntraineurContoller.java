package controller.Entraineurs;

import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Entraineur;
import model.EntraineurDEmp;

public class EntraineurContoller implements Initializable{

    @FXML
    private Button suprimerEnt;

    @FXML
    private Button AjouterEntrAction;
    @FXML
    private ScrollPane principalePane;
    @FXML
    private VBox menulist;

    @FXML
    private Button ModifierEnt;

    @FXML
    private FontAwesomeIcon menu;
    @FXML
    void AjouterEntrAction(ActionEvent event) {
    	Stage signup =new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Entraineurs/AjoutNouveuEntraineur.fxml"));
			Scene scene = new Scene(root);
			signup.setScene(scene);
			signup.show();
		
		} catch (IOException e){
			e.printStackTrace();
		}
		menulist.setVisible(false);
    }
    @FXML
    void SupprimerEntrAction(ActionEvent event) {
    	Stage signup =new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Entraineurs/supprimerEntraineur.fxml"));
			Scene scene = new Scene(root);
			signup.setScene(scene);
			signup.show();
		
		} catch (IOException e){
			e.printStackTrace();
		}
		menulist.setVisible(false);
    }
    @FXML
    void ActionMenuAction(MouseEvent event) {
    	menulist.setVisible(true);
    }
    @FXML
    void ModifierEntrAction(ActionEvent event) {
    	Stage signup =new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Entraineurs/updateEntraineur.fxml"));
			Scene scene = new Scene(root);
			signup.setScene(scene);
			signup.show();
		
		} catch (IOException e){
			e.printStackTrace();
		}
		menulist.setVisible(false);
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		principalePane.toBack();
		menulist.setVisible(false);
		 afficheEntr();
	}
	public void afficheEntr() {
		AnchorPane p=new AnchorPane();
		p.setPrefHeight(520);
		p.setPrefHeight(800);
		ObservableList<Entraineur> Enlist= FXCollections.observableArrayList();
		      Enlist=(new EntraineurDEmp()).displayEntraineurs();
		      for(Entraineur ent:Enlist) {
		    	  VBox pn=new VBox();
			      pn.setPrefSize(250,250);
			      pn.setStyle("-fx-background-color: #23e");
			      pn.setPadding(new Insets(10, 10, 2, 5));
			      pn.setSpacing(10);
		    	  ImageView imv=new ImageView();
		    	  Image image = new Image(ent.getPhoto());
		    	  imv.setFitHeight(200);
		    	  imv.setFitWidth(200);
	              imv.setImage(image);
	              pn.getChildren().add(imv);
	              TextField nm=new TextField(ent.getName());
	              nm.setStyle("-fx-background-color: #23e");
	              nm.setFont(Font.font(20));
	              TextField exp=new TextField(ent.getExperience());
	              exp.setStyle("-fx-background-color: #23e");
	              exp.setFont(Font.font(20));
	              pn.getChildren().add(nm);
	              pn.getChildren().add(exp);
	              p.getChildren().add(pn);
		      }
		      principalePane.setContent(p);
	}
}

