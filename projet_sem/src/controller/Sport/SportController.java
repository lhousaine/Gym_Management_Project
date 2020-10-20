package controller.Sport;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Sport;
import model.Sportdaoimp;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

	public class SportController implements Initializable{

	    @FXML
	    private FontAwesomeIcon choicelist;
	    @FXML
	    private VBox menulist;
	    @FXML
	    private Button NvSport;

	    @FXML
	    private Button MdSport;

	    @FXML
	    private ListView<String> listcategorie1;

	    @FXML
	    private ListView<String> listcategorie3;

	    @FXML
	    private ListView<String> listcategorie2;

	    @FXML
	    private ListView<String> listcategorie4;
	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			menulist.setVisible(false);
			menulist.toFront();
			remplirlists(new Sportdaoimp().sportlist());
		}
		public void remplirlists(ObservableList<Sport> Slist) {
			for(Sport sp:Slist) {
				if(sp.getCategorie().equals("Categorie 1")) {
					listcategorie1.getItems().add(sp.getName());
				}
				else if(sp.getCategorie().equals("Categorie 2")) {
					listcategorie2.getItems().add(sp.getName());
				}
				else if(sp.getCategorie().equals("Categorie 3")) {
					listcategorie3.getItems().add(sp.getName());
				}
				else if(sp.getCategorie().equals("Categorie 4")) {
					listcategorie4.getItems().add(sp.getName());
				}
			}
		}
	    @FXML
	    void choiceAction(MouseEvent event) {
         menulist.setVisible(true);
	    }
	    @FXML
	    void SupprimerAction(ActionEvent event){
	    	menulist.setVisible(false);
	    	Stage signup =new Stage();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/view/Sport/supprimerSport.fxml"));
				Scene scene = new Scene(root);
				signup.setScene(scene);
				signup.show();
			
			} catch (IOException e){
				e.printStackTrace();
			}
	    }
    @FXML
    void AjouterSportAction(ActionEvent event) {
    	menulist.setVisible(false);
    	Stage signup =new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Sport/newSportScene.fxml"));
			Scene scene = new Scene(root);
			signup.setScene(scene);
			signup.show();
		
		} catch (IOException e){
			e.printStackTrace();
		}
    }
    @FXML
    void ModifierSportAction(ActionEvent event) {
    	menulist.setVisible(false);
    	Stage signup =new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Sport/modifierSport.fxml"));
			Scene scene = new Scene(root);
			signup.setScene(scene);
			signup.show();
		
		} catch (IOException e){
			e.printStackTrace();
		}
    }
}