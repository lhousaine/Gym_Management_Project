package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.imageC;

public class accueilController implements Initializable{

    @FXML
    private ImageView imageV;

    @FXML
    private Button Avantph;

    @FXML
    private Button nouveauP;

    @FXML
    private Button supprimer;

    @FXML
    private Button apresPh;
    
    @FXML
    private FontAwesomeIcon menu;
    @FXML
    private Pane menupane;
    
    private imageC im;
    private Image image;
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	menupane.setVisible(false);
		setfirstimage();
	}
	public void setfirstimage() {
		im=new imageC();
		if(im.selectNombreimage()>=1) {
			String path=im.selectorderimages().get(0).getPath();
	    	image = new Image(path,900,550,false,false);
	    	}else {
	    		image = new Image("/images/clean-gym.jpg",900,550,true,true);	
	    	}
		imageV.setImage(image);
	}
    @FXML
    void ApresphotoAction(ActionEvent event){
    	image=imageV.getImage();
    	@SuppressWarnings("deprecation")
		String path=image.impl_getUrl();
    	image = new Image(im.selectapimage(path));
    	imageV.setImage(image);
    }
    @FXML
    void AvantphotoAction(ActionEvent event) {
    	image=imageV.getImage();
    	@SuppressWarnings("deprecation")
		String path=image.impl_getUrl();
    	image = new Image(im.selectavimage(path));
    	
    	imageV.setImage(image);
    }
    @FXML
    void nouveauAction(ActionEvent event) {
    	try {
			im.insertimage();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	menupane.setVisible(false);
    }
    @FXML
    void supprimerAction(ActionEvent event) {
    	image=imageV.getImage();
    	@SuppressWarnings("deprecation")
		String path=image.impl_getUrl();
    	if(im.selectNombreimage()>=1) {
    	im.supprimerImage(path);
    	setfirstimage();
    	}
    	menupane.setVisible(false);
    }
    @FXML
    void choiceAction(MouseEvent event) {
    	menupane.setVisible(true);
    }
}
