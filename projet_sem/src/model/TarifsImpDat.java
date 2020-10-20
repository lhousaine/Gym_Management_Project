package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.ConnectDB;

public class TarifsImpDat implements tarifintdao{
	 private PreparedStatement ps;
     private ResultSet res;
     private Connection con;
     private ConnectDB connect;
     private ObservableList<Tarifs> tarifs;
     public TarifsImpDat(){
    		super();
    		this.connect =new ConnectDB();
    		con=connect.getConnection();
    		tarifs= FXCollections.observableArrayList();
    	     }
     public ObservableList<Tarifs> SelectTarifs(){
    		String qr = "SELECT * FROM `tarifs` ORDER BY N_mois,Categorie ASC";
    		try{
    			ps=con.prepareStatement(qr);
    			res=ps.executeQuery();
    			 while(res.next()){
    			   		tarifs.add(new Tarifs(
    			   				      res.getString("N_mois"),
    			   				      res.getString("Categorie"),
    			   				      res.getInt("prix")));
    			   		System.out.println(res.getInt("prix"));
    			 }
    			 return tarifs;
    		 }catch (SQLException e){
    			e.printStackTrace();
    		}
    		return null;
     }
	@Override
	public void modifierTarif(Tarifs tr) {
		String upqr ="UPDATE `tarifs` SET `prix`=? WHERE `Categorie`=? AND `N_mois`=?";
		try {
			ps=con.prepareStatement(upqr);
			ps.setFloat(1,tr.getPrix());
			ps.setString(2,tr.getCategorie());
			ps.setString(3,tr.getN_mois());
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
}
