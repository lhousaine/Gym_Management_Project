package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.ConnectDB;

public class Sportdaoimp implements sportdaoi{
    private PreparedStatement ps;
    private Statement st;
    private   ResultSet res;
    private Connection con;
    private ConnectDB connect;
    private ObservableList<Sport> Slist;
	public Sportdaoimp() {
		super();
		this.connect =new ConnectDB();
		con=connect.getConnection();
		 Slist= FXCollections.observableArrayList();
	}
	@Override
	public void insert(Sport s){
		String query="INSERT INTO `sport`(`name`, `Entraineur`,`Categorie`) VALUES (?,?,?)";
        try {
			ps=con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setString(2,s.getEntraineur());
			ps.setString(3,s.getCategorie());
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
	public ObservableList<Sport> sportlist(){
		Slist.clear();
		 String qr = "SELECT * FROM `sport`";
		try {
			ps=con.prepareStatement(qr);
			res=ps.executeQuery();
			 while(res.next()) {
				 Slist.add(new Sport(
						   res.getString("name"),
						   res.getString("Entraineur"),
						   res.getString("Categorie")));
			 }
			 return Slist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void supprimersport(String name){
		String dlqr="DELETE FROM `sport` WHERE name=?";
		try{
		ps = con.prepareStatement(dlqr);
		ps.setString(1,name);
		ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
