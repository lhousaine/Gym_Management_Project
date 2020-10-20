package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.ConnectDB;

public class EntraineurDEmp implements EntraineurD{
	 ObservableList<Entraineur> Enlist ;
	private Connection con;
	private ConnectDB cb;
	private ResultSet res;
	private PreparedStatement ps;
	public EntraineurDEmp() {
		super();
		Enlist =FXCollections.observableArrayList();
		this.cb = cb=new ConnectDB();
		this.con = cb.getConnection();
	}
	public ObservableList<Entraineur> displayEntraineurs() {
		 Enlist = FXCollections.observableArrayList();
		 String qr = "SELECT * FROM `entraineur`";
		try {
			ps=con.prepareStatement(qr);
			res=ps.executeQuery();
			 while(res.next()){
				 Enlist.add(new Entraineur(
						   res.getString("name"),
						   res.getString("Surname"),
						   res.getString("CNI"),
						   res.getInt("montantg"),
						   res.getString("passemetsal"),
						   res.getString("photo"),
						   res.getString("experience")));
			 }
			 return Enlist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void insert(Entraineur ent) {
		  String query="INSERT INTO `entraineur`(`name`, `surname`,`CNI`,`Tel`,`Email`, `Sport`,`montantg`,`photo`,`experience`,`passemetsal`) VALUES (?,?,?,?,?,?,?,?,?,?)";
	         try {
				ps=con.prepareStatement(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	         try {
				ps.setString(1, ent.getName());
				ps.setString(2,ent.getSurname());
				ps.setString(3,ent.getCni());
				ps.setString(4,ent.getTel());
				ps.setString(5,ent.getEmail());
				ps.setString(6,ent.getSport());
				ps.setInt(7,ent.getMontantg());
				ps.setString(8, ent.getPhoto());
				ps.setString(9, ent.getExperience());
				ps.setString(10,ent.getPassementSal());
				ps.setString(11,ent.getDate_recrute());
				ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
	         }
	}
	@Override
	public void delete(Entraineur ent) {
		String dlqr="DELETE FROM `entraineur` WHERE CNI=?";
		try {
			ps = con.prepareStatement(dlqr);
			ps.setString(1,ent.getCni());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
