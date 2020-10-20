package controller.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Admin;
import model.AdminCDao;

public class priviligeSceneController implements Initializable{

    @FXML
    private TableView<Admin> tableadmin;

    @FXML
    private TableColumn<Admin,String> Nomcol;

    @FXML
    private TableColumn<Admin,String> prenomcol;

    @FXML
    private TableColumn<Admin,String> cnicol;

    @FXML
    private TableColumn<Admin,String> numtelcol;

    @FXML
    private TableColumn<Admin,String> emailcol;

        @FXML
        private FontAwesomeIcon choicelist;

        @FXML
        private VBox menulist;

        @FXML
        private Button ajoutadmin;

        @FXML
        private Button supprimerAd;

        @FXML
        private Button modieradmin;
        private AdminCDao ad;
    	@Override
    	public void initialize(URL arg0, ResourceBundle arg1){
    		menulist.setVisible(false);
    		ad=new AdminCDao();
    		CreateElementAdmins(ad.displayAdmins());
    	}
    	public void CreateElementAdmins(ObservableList<Admin> Alist) {
    		cnicol.setCellValueFactory(cellData -> cellData.getValue().cniProperty());
    		Nomcol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    		prenomcol.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
    		numtelcol.setCellValueFactory(cellData -> cellData.getValue().telProperty());
    		emailcol.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
    		tableadmin.setItems(Alist);
    	}
        @FXML
        void menuclickedAction(MouseEvent event) {
       menulist.setVisible(true);
        }
        @FXML
        void ajoutAction(ActionEvent event) {
        	Stage ajadmin =new Stage();
    		try{
    			Parent root =FXMLLoader.load(getClass().getResource("/view/Priviliges/ajouterAdmin.fxml"));
    			Scene scene = new Scene(root);
    		    ajadmin.setScene(scene);
    			ajadmin.show();
    			ajadmin.setResizable(false);
    			menulist.setVisible(false);

    		}catch (IOException ef){
    			ef.printStackTrace();
    		}
    		
        }

    @FXML
    void modifierAction(ActionEvent event) {
    	Stage ajadmin =new Stage();
		try{
			Parent root =FXMLLoader.load(getClass().getResource("/view/Priviliges/updateAdmin.fxml"));
			Scene scene = new Scene(root);
		    ajadmin.setScene(scene);
			ajadmin.show();
			ajadmin.setResizable(false);
			menulist.setVisible(false);
		}catch (IOException ef){
			ef.printStackTrace();
		}
    }

    @FXML
    void supprimerAction(ActionEvent event) {
       	Stage supadmin =new Stage();
    			try{
    				Parent root =FXMLLoader.load(getClass().getResource("/view/Priviliges/supprimerAdmin.fxml"));
    				Scene scene = new Scene(root);
    			    supadmin.setScene(scene);
    				supadmin.show();
    				supadmin.setResizable(false);
    				menulist.setVisible(false);

    			}catch (IOException ef){
    				ef.printStackTrace();
    			}
    }
}
