package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.ConnectDB;

public class AdminCDao implements AdminIntDao{
	   private ConnectDB cx;
	   private Connection con;
	   private java.sql.PreparedStatement ps;
	   private ResultSet res;
	   private ObservableList<Admin> Alist;
	   public AdminCDao(){
			super();
			this.cx = new ConnectDB();
			con=cx.getConnection();
			 Alist= FXCollections.observableArrayList();
		}
	@Override
	public int add(Admin A){
		   String query="INSERT INTO `admins`(`name`,`surname`,`CNI`,`tel`,`email`, `password`) VALUES (?,?,?,?,?,?)";
	         try {
				ps=con.prepareStatement(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	         try {
				ps.setString(1, A.getName());
				ps.setString(2,A.getSurname());
				ps.setString(3,A.getCni());
				ps.setString(4,A.getTel());
				ps.setString(5,A.getEmail());
		        ps.setString(6,A.getPassword());
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
	public int modify(Admin A){
		return 0;
	}
	@Override
	public void remove(String AdId){
		String qr="DELETE FROM `admins` WHERE CNI=?";
		try {
			ps = con.prepareStatement(qr);
			ps.setString(1,AdId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int  select(Admin A){
		int count=0;
		String qr="SELECT * FROM `admins` WHERE name=? and password=?";
		try {
			ps=con.prepareStatement(qr);
			ps.setString(1,A.getName());
			ps.setString(2,A.getPassword());
			res=ps.executeQuery();
			while(res.next()){
				count+=1;
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}
		return count;
	}
	@Override
	public int  selectAdmins(Admin A){
		int count=0;
		String qr="SELECT * FROM `admins` WHERE CNI=? and name=? and email=? and tel=?";
		try {
			ps=con.prepareStatement(qr);
			ps.setString(1,A.getCni());
			ps.setString(2,A.getName());
			ps.setString(3,A.getEmail());
			ps.setString(4,A.getTel());
			res=ps.executeQuery();
			while(res.next()){
				count+=1;
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}
		return count;
	}
	@Override
	public  ObservableList<Admin> displayAdmins() {
		Alist.clear();
		 String qr = "SELECT * FROM `admins`";
		try {
			ps=con.prepareStatement(qr);
			res=ps.executeQuery();
			 while(res.next()) {
				 Alist.add(new Admin(
						   res.getString("name"),
						   res.getString("surname"),
						   res.getString("CNI"),
						   res.getString("tel"),
						   res.getString("email")));
			 }
			 return Alist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int tableRowNumber(Admin A) {
		int cpt=0;
		String frqr="SELECT COUNT(*) FROM `admins`";
		try {
			ps = con.prepareStatement(frqr); 
		    res = ps.executeQuery();
		    while (res.next()) {
			 cpt=res.getInt("count(*)");
			 }
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return cpt;
	}
	@Override
	public void updatepassword(String adId,String pass) {
		String upqr ="UPDATE `admins` SET `password`=? WHERE CNI=?";
		try {
			ps = con.prepareStatement(upqr); 
			ps.setString(1,pass);
			ps.setString(2,adId);
		    ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
