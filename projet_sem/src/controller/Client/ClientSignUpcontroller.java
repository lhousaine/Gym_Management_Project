package controller.Client;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import model.AdminCDao;
import model.C_ClientDao;
import model.Client;
import javafx.scene.control.ComboBox;

    public class ClientSignUpcontroller implements Initializable{
    	ObservableList<String> fld=FXCollections.observableArrayList("C1","C2","C3");
    	ObservableList<String> cvl=FXCollections.observableArrayList("Male","Female");
    	private C_ClientDao clientD;
    	private Client client;
    	@FXML
        private Button reset;
        @FXML
        private Button send;
        @FXML
        private TextField surname;
        @FXML
        private TextField cni;
        @FXML
        private DatePicker date_de_naissance;
        @FXML
        private ChoiceBox<String> Sport;

        @FXML
        private TextField email;

        @FXML
        private TextField tel;

        @FXML
        private TextField name;

        @FXML
        private Button back;

        @FXML
        private TextField Payment;

        @FXML
        private TextField payer;

        @FXML
        private ChoiceBox<String> civile;

        @FXML
        private ImageView profile;

        @FXML
        private Button imageSelect;

        @FXML
        private DatePicker date_inscript;

        @FXML
        private TextField groupe;

        @FXML
        private Label PhoneErr;

        @FXML
        private Label NameErr;

        @FXML
        private Label surnameErr;

        @FXML
        private Label cniErr;

        @FXML
        private Label genderErr;

        @FXML
        private Label paymentErr;

        @FXML
        private Label groupeErr;

        @FXML
        private Label SportEr;

        @FXML
        private Label dateInErr;

        @FXML
        private Label EmailErr;

        @FXML
        private Label dateNErr;

        @FXML
        private Label PayerErr;
    	SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
    	private String pathImage;
    	 public void transferMessage(String message){
    	        cni.setText(message);
    	    }
     @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
		Sport.setItems(fld);
		Sport.setValue("C1");
		civile.setItems(cvl);
		civile.setValue("Male");
	    clientD=new C_ClientDao();
	}
    @FXML
    void envoyercontnu(ActionEvent event) {
    	if(!validateEmail(email.getText())) {
    		EmailErr.setText("the Gmail structure is not correcte");
    		return;
    	}
    	if(!validatePhone(tel.getText())){
    		PhoneErr.setText("the Phone structure is not correcte");
    		return;
    	} 
        client=new Client(name.getText(),surname.getText(),cni.getText(),tel.getText(),email.getText(),date_de_naissance.getValue().toString(),civile.getValue(),Integer.parseInt(Payment.getText()),pathImage,payer.getText(),Sport.getValue().toString(),groupe.getText(),date_inscript.getValue().toString());
    	clientD.add(client);
    	send.getScene().getWindow().hide();
    }
    @FXML
    void backAction(ActionEvent event) {
    	back.getScene().getWindow().hide();
    }
    @FXML
    void reinitialiserformule(ActionEvent event) {
     name.setText("");
     surname.setText("");
     cni.setText("");
     tel.setText("");
     email.setText("");
     payer.setText("");
    }
    @FXML
    void selectimageAction(ActionEvent event) {
       	FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null){
            try {
                String imageUrl = file.toURI().toURL().toExternalForm();
                pathImage=file.getPath();
                Image image = new Image(imageUrl);
                profile.setImage(image);
            } catch (MalformedURLException ex) {
                throw new IllegalStateException(ex);
            }
        }
    }
    	public static boolean validateEmail(String emailStr) {
    		 Pattern VER = 
    		 Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    	     Matcher matcher = VER.matcher(emailStr);
    	     return matcher.find();
    	}
    	public static boolean validatePhone(String emailStr) {
    		String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
   		 Pattern VPR = Pattern.compile(regex);
   	     Matcher matcher = VPR.matcher(emailStr);
   	     return matcher.find();
   	}
}
