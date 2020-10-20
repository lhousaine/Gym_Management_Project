package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import util.ConnectDB;

public class C_ClientDao implements ClientDao{
     private PreparedStatement ps;
     private Statement st;
     private   ResultSet res;
     private Connection con;
     private ConnectDB connect;
     private ObservableList<Client> Clist;
 	public C_ClientDao() {
		super();
		this.connect =new ConnectDB();
		con=connect.getConnection();
		 Clist= FXCollections.observableArrayList();
	}
	public  ObservableList<Client> displayClients() {
		Clist.clear();
		 String qr = "SELECT * FROM `clients`";
		try {
			ps=con.prepareStatement(qr);
			res=ps.executeQuery();
			 while(res.next()) {
				 Clist.add(new Client(
						   res.getString("name"),
						   res.getString("Surname"),
						   res.getString("CNI"),
						   res.getInt("payment_ment"),
						   res.getString("Sport"),
						   res.getString("groupe"),
						   res.getString("payer"),
						   res.getString("date_inscription").toString()));
			 }
			 return Clist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void modify(Client P,String ClientId) throws SQLException, ClassNotFoundException {
		String upqr ="UPDATE `clients` SET `name`=?, `Surname`=?,`CNI`=?,`Tel`=?,`Email`=?, `date de naissance`=?,`civilité`=?,`payment_ment`=?,`photo`=?,`payer`=?,`Sport`=?,`groupe`=?,`date_inscription`=? WHERE CNI=?";
	try {	con=connect.getConnection();
		ps=con.prepareStatement(upqr);
		ps.setString(1, P.getName());
		ps.setString(2,P.getSurname());
		ps.setString(3,P.getCni());
		ps.setString(4,P.getTel());
		ps.setString(5,P.getEmail());
		ps.setString(6,P.getDate_de_naissance().toString());
		ps.setString(7, P.getCivile());
		ps.setInt(8, P.getPayment_ment());
		ps.setString(9, P.getPhoto());
		ps.setString(10, P.getPayer());
		ps.setString(11,P.getSport());
		ps.setString(12,P.getGroupe());
		ps.setString(13,P.getDate_inscript().toString());
		ps.setString(14,ClientId);
		ps.executeUpdate();
        } catch (SQLException e) {
	          e.printStackTrace();
             }
          finally {
    	    try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
     }
	}
	@Override
	public void deleteClientWithId(String ClientId) throws SQLException, ClassNotFoundException {
		String dlqr="DELETE FROM `clients` WHERE CNI=?";
		ps = con.prepareStatement(dlqr);
		ps.setString(1,ClientId);
		ps.executeUpdate();
	}
	@Override
	public int add(Client P) {
	   String query="INSERT INTO `clients`(`name`, `Surname`,`CNI`,`Tel`,`Email`, `date de naissance`,`civilité`,`payment_ment`,`photo`,`payer`,`Sport`,`groupe`,`date_inscription`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
         try {
			ps=con.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
         try {
			ps.setString(1, P.getName());
			ps.setString(2,P.getSurname());
			ps.setString(3,P.getCni());
			ps.setString(4,P.getTel());
			ps.setString(5,P.getEmail());
			ps.setString(6,P.getDate_de_naissance().toString());
			ps.setString(7, P.getCivile());
			ps.setInt(8, P.getPayment_ment());
			ps.setString(9, P.getPhoto());
			ps.setString(10, P.getPayer());
			ps.setString(11,P.getSport());
			ps.setString(12,P.getGroupe());
			ps.setString(13,P.getDate_inscript().toString());
			ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
         finally {
        	 try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
         }
		return 0;
	}
	@Override
	public ObservableList<Client> ChercherClient(String name) {
		 Clist= FXCollections.observableArrayList();
		 String qr="SELECT * FROM `clients` WHERE name=?";
		try {
			ps=con.prepareStatement(qr);
			ps.setString(1,name);
			res=ps.executeQuery();
			 while(res.next()){
				 Clist.add(new Client(
						   res.getString("name"),
						   res.getString("Surname"),
						   res.getString("CNI"),
						   res.getInt("payment_ment"),
						   res.getString("Sport"),
						   res.getString("groupe"),
						   res.getString("payer"),
						   res.getString("date_inscription").toString()));
			 }
			 return Clist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
}
}
