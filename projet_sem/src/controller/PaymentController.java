package controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.C_ClientDao;
import model.Client;
import model.Entraineur;
import model.EntraineurDEmp;

public class PaymentController implements Initializable{
    @FXML
    private TableView<Client> tableclient;
    @FXML
    private TableColumn<Client,String> clcnicol;

    @FXML
    private TableColumn<Client,String> clnomcol;

    @FXML
    private TableColumn<Client,String> clprencol;

    @FXML
    private TableColumn<Client,String> clpayecol;
    @FXML
    private TableColumn<Client,Integer> Montantp;
    @FXML
    private TableView<Entraineur> tableent;

    @FXML
    private TableColumn<Entraineur,String> entcnicol;

    @FXML
    private TableColumn<Entraineur, String> entnomcol;

    @FXML
    private TableColumn<Entraineur,String> entprenomcol;

    @FXML
    private TableColumn<Entraineur,Integer> envoislcol;
    @FXML
    private TableColumn<Entraineur,String> passementSal;
     private C_ClientDao cl;
     private EntraineurDEmp Ent;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cl=new C_ClientDao();
		Ent=new EntraineurDEmp();
		this.CreateElementClients(cl.displayClients());
		this.CreateElementEntraineurs(Ent.displayEntraineurs());
	}
	public void CreateElementClients(ObservableList<Client> Clist) {
	     clcnicol.setCellValueFactory(cellData -> cellData.getValue().cniProperty());
		 clnomcol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		 clprencol.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
		 clpayecol.setCellValueFactory(cellData -> cellData.getValue().PayerProperty());
		 Montantp.setCellValueFactory(cellData -> cellData.getValue().payment_mentProperty().asObject());
		 tableclient.setItems(Clist);
	}
	public void CreateElementEntraineurs(ObservableList<Entraineur> Entlist) {
		entcnicol.setCellValueFactory(cellData -> cellData.getValue().cniProperty());
		entnomcol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		entprenomcol.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
		envoislcol.setCellValueFactory(cellData -> cellData.getValue(). montantgProperty().asObject());
		passementSal.setCellValueFactory(cellData -> cellData.getValue().passementSalProperty());
		tableent.setItems(Entlist);
	}
}

