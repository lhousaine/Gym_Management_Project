package controller.Entraineurs;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import model.Entraineur;
import model.EntraineurDEmp;

public class AjoutEntraineurAction implements Initializable{
	@FXML
    private TextField prenom;

    @FXML
    private TextField numTel;

    @FXML
    private TextField cni;

    @FXML
    private TextField nom;

    @FXML
    private TextField email;

    @FXML
    private Button Annuler;

    @FXML
    private Button valider;

    @FXML
    private TextField Sportname;

    @FXML
    private Label Sport;

    @FXML
    private TextField Experience;

    @FXML
    private TextField passmentSal;

    @FXML
    private ImageView enraineurphoto;

    @FXML
    private Button selectectimage;

    @FXML
    private TextField salaire;
	private String pathImage;
    @FXML
    void AjoutENtrAction(ActionEvent event) {
    	        LocalDate date = LocalDate.now();
    			Entraineur ent=new Entraineur(nom.getText(),prenom.getText(),cni.getText(),email.getText(),numTel.getText(),Sportname.getText(), Integer.parseInt(salaire.getText()),pathImage,Experience.getText(),passmentSal.getText(),date.toString());
    			EntraineurDEmp entd=new EntraineurDEmp();
    	    	entd.delete(ent);
    			entd.insert(ent);
    			valider.getScene().getWindow().hide();
    }
    @FXML
    void AnuulerAjEntrAction(ActionEvent event) {
    	Annuler.getScene().getWindow().hide();
    }
    @FXML
    void selectionerimage(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null){
            try {
                String imageUrl = file.toURI().toURL().toExternalForm();
                pathImage=file.getPath();
                Image image = new Image(imageUrl);
                enraineurphoto.setImage(image);
            } catch (MalformedURLException ex) {
                throw new IllegalStateException(ex);
            }
        }
    }
	public void transferMessage(String idtoupdate) {
		cni.setText(idtoupdate);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
	}
}

