package controller.Client;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.C_ClientDao;
import model.Client;
import util.ConnectDB;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
public class ClientController implements Initializable{

    @FXML
    private Button nvClient;

    @FXML
    private TableView<Client> table;

    @FXML
    private TableColumn<Client,String> cniCollumn;

    @FXML
    private TableColumn<Client,String> nomCollumn;

    @FXML
    private TableColumn<Client,String> prenomCollumn;

    @FXML
    private TableColumn<Client, String> sportCollumn;

    @FXML
    private TableColumn<Client,String> GroupeCollumn;

    @FXML
    private TableColumn<Client,String> date_inscriptCollumn;
    private C_ClientDao cl;
    @FXML
    private FontAwesomeIcon choiceClient;
    @FXML
    private Button ModifierCl;
    @FXML
    private Button supprimerClient;
    @FXML
    private VBox choicelist;
    @FXML
    private TextField Membrecherche;

    @FXML
    private Button valider;

    @FXML
    private Button ViewAll;
    @FXML
    void ViewAllAction(ActionEvent event) {
    	CreateElement(cl.displayClients());
    }
    @FXML
    void validerAction(ActionEvent event) {
    	CreateElement(cl.ChercherClient(Membrecherche.getText()));
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		choicelist.setVisible(false);
		cl=new C_ClientDao();
		CreateElement(cl.displayClients());
	}
	public void CreateElement(ObservableList<Client> Clist) {
		 cniCollumn.setCellValueFactory( new PropertyValueFactory<Client,String>("cni"));
		 nomCollumn.setCellValueFactory( new PropertyValueFactory<Client,String>("name"));
		 prenomCollumn.setCellValueFactory( new PropertyValueFactory<Client,String>("surname"));
		 sportCollumn.setCellValueFactory( new PropertyValueFactory<Client,String>("Sport"));
		 GroupeCollumn.setCellValueFactory( new PropertyValueFactory<Client,String>("groupe"));
		 date_inscriptCollumn.setCellValueFactory( new PropertyValueFactory<Client,String>("date_inscript"));
		 table.setItems(Clist);
	}
	  @FXML
	  void NouveauClientAction(ActionEvent event) {
			Stage home=new Stage();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/view/Client/ClientSignUp.fxml"));
				Scene scene=new Scene(root);
				home.setScene(scene);
				home.show();
				home.setTitle("Kech Club");
				home.setResizable(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			choicelist.setVisible(false);
	 }

	    @FXML
	    void ModifierClientAction(ActionEvent event) {
	    	Stage home=new Stage();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/view/Client/ClientUpdate.fxml"));
				Scene scene=new Scene(root);
				home.setScene(scene);
				home.show();
				home.setTitle("Kech Club");
				home.setResizable(true);
			} catch(IOException e){
				e.printStackTrace();
			}
			choicelist.setVisible(false);
	    }
	    @FXML
	    void SupprimerClientAction(ActionEvent event) {
	    	Stage home=new Stage();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/view/Client/deleteClient.fxml"));
				Scene scene=new Scene(root);
				home.setScene(scene);
				home.show();
				home.setTitle("Kech Club");
				home.setResizable(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			choicelist.setVisible(false);
	    }
	    @FXML
	    void choiceAction(MouseEvent event) {
         choicelist.setVisible(true);
	    }
}
