package model;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import util.ConnectDB;

public class imageC{
	 private PreparedStatement ps;
     private ResultSet res;
     private Connection con;
     private ConnectDB connect;
     private ObservableList<image> images;
public imageC(){
	super();
	this.connect =new ConnectDB();
	con=connect.getConnection();
	images= FXCollections.observableArrayList();
     }

public   ObservableList<image> selectorderimages(){
	String qr = "SELECT * FROM `images` ORDER BY Numero ASC";
	String path="";
	try{
		ps=con.prepareStatement(qr);
		res=ps.executeQuery();
		 while(res.next()){
		   		images.add(new image(
		   				      res.getInt("Numero"),
		   				      res.getString("path")));
		 }
		 return images;
	 }catch (SQLException e){
		e.printStackTrace();
	}
	return null;
}
public  String selectavimage(String path){
	  images=selectorderimages();
		 String nextpath="";
	      int i=0;
			 while(i<images.size()) {
				 if(path.equals(images.get(i).getPath())){
					 if(i>0){
			   		   nextpath=images.get(i-1).getPath();
					 }else{
						 nextpath=images.get(images.size()-1).getPath(); 
					 }
					 System.out.println(nextpath);
			   		   break;
				 }
			 }
		return nextpath;
}
public String selectapimage(String path){
     images=selectorderimages();
	 String nextpath="";
      int i=0;
		 while(i<images.size()) {
			 if(path.equals(images.get(i).getPath())){
				 if(i<images.size()-1){
		   		   nextpath=images.get(i+1).getPath();
				 }else {
					 nextpath=images.get(0).getPath(); 
				 }
				 System.out.println(nextpath);
		   		   break;
			 }
		 }
	return nextpath;
}
public  int selectNombreimage(){
	int cpt=0;
	String qr="SELECT COUNT(*) FROM `images`";
	try{
		ps = con.prepareStatement(qr); 
	    res = ps.executeQuery();
	    while (res.next()){
		 cpt=res.getInt("count(*)");
		}
	}catch (SQLException e){
		e.printStackTrace();
	}
	return cpt;
}
public void insertimage() throws SQLException{
	String path=choiseImage();
	if(path==null){
		System.out.println("no added to the database");
		return;
	}
	String qr = "INSERT INTO `images`(`path`) VALUES(?)";
	ps=con.prepareStatement(qr);
	ps.setString(1,path);
	ps.executeUpdate();
}
public void supprimerImage(String path) {
	     try {
			ps=con.prepareStatement("delete FROM `images` WHERE path=?");
			 ps.setString(1,path);
			 ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
}
public String choiseImage() {
	FileChooser fileChooser = new FileChooser();
    File file = fileChooser.showOpenDialog(null);
    if (file != null){
        try {
            String imageUrl = file.toURI().toURL().toExternalForm();
            Image image = new Image(imageUrl);
            return imageUrl;
        } catch (MalformedURLException ex) {
            throw new IllegalStateException(ex);
        }
    }
	return null;
}
}
