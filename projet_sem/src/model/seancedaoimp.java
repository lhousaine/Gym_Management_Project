package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.ConnectDB;

public class seancedaoimp implements seancedaoi{
	 private PreparedStatement ps;
     private ResultSet res;
     private Connection con;
     private ConnectDB connect;
     private ObservableList<seance> seances;
	public seancedaoimp(){
		super();
		this.connect =new ConnectDB();
		con=connect.getConnection();
		seances= FXCollections.observableArrayList();
	}
	@Override
	public void modifierSeance(seance sce) {
		String upqr ="UPDATE `tarifs` SET `sports`=?,`Entraineur`=? WHERE `temps`=? AND `jour`=?";
		try {
			ps=con.prepareStatement(upqr);
			ps.setString(1,sce.getSports());
			ps.setString(2,sce.getEntraineurs());
			ps.setString(3,sce.getTemps());
			ps.setString(4,sce.getJour());
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
	public ObservableList<seance> seanceslist() {
		String qr = "SELECT * FROM `seance` ORDER BY temps,jour ASC";
		try{
			ps=con.prepareStatement(qr);
			res=ps.executeQuery();
			 while(res.next()){
			   		seances.add(new seance(
			   				      res.getString("sports"),
			   				      res.getString("temps"),
			   				      res.getString("jour")));
			 }
			 return seances;
		 }catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
