package model;

import java.time.LocalDate;
import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Client extends Personne{

   private StringProperty date_de_naissance;
   private StringProperty civile;
   private IntegerProperty payment_ment;
   private StringProperty photo;
   private StringProperty Payer;
   private StringProperty Sport;
   private StringProperty groupe;
   private StringProperty date_inscript;
   public Client() {
		super();

		 this.date_de_naissance= new SimpleStringProperty();
		 this.civile= new SimpleStringProperty();
		 this.payment_ment= new SimpleIntegerProperty();
		 this.photo= new SimpleStringProperty();
		 this.Payer= new SimpleStringProperty();
		 this.Sport= new SimpleStringProperty();
		 this.groupe= new SimpleStringProperty();
		 this.date_inscript= new SimpleStringProperty();
	}

public Client(String name, String surname, String cni, String tel, String email,String date_de_naissance, String civile, int payment_ment, 
		String photo, String payer, String sport, String groupe,String date_inscript) {
	super(name,surname,cni,tel,email);
	 this.date_de_naissance= new SimpleStringProperty(date_de_naissance);
	 this.civile= new SimpleStringProperty(civile);
	 this.payment_ment= new SimpleIntegerProperty(payment_ment);
	 this.photo= new SimpleStringProperty(photo);
	 this.Payer= new SimpleStringProperty(payer);
	 this.Sport= new SimpleStringProperty(sport);
	 this.groupe= new SimpleStringProperty(groupe);
	 this.date_inscript= new SimpleStringProperty(date_inscript);
}
public Client(String name, String surname, String cni,int payment_ment, String sport,String payer, String groupe,String date_inscript) {
	 super(name,surname,cni);
	 this.payment_ment= new SimpleIntegerProperty(payment_ment);
	 this.Sport= new SimpleStringProperty(sport);
	 this.Payer= new SimpleStringProperty(payer);
	 this.groupe= new SimpleStringProperty(groupe);
	 this.date_inscript= new SimpleStringProperty(date_inscript);
}

public String getDate_de_naissance(){
	return date_de_naissance.get();
}
public void setDate_de_naissance(String date_de_naissance) {
	this.date_de_naissance.set(date_de_naissance);
}
public String getCivile() {
	return civile.get();
}
public void setCivile(String civile) {
	this.civile.set(civile);
}
public int getPayment_ment() {
	return payment_ment.get();
}
public IntegerProperty payment_mentProperty() {
	return payment_ment;
}
public void setPayment_ment(int payment_ment) {
	this.payment_ment.set(payment_ment);
}
public String getPhoto(){
	return photo.get();
}
public void setPhoto(String photo) {
	this.photo.set(photo);
}
public String getPayer() {
	return Payer.get();
}
public StringProperty PayerProperty() {
	return Payer;
}
public void setPayer(String payer){
	Payer.set(payer);
}
public String getSport(){
	return Sport.get();
}
public void setSport(String sport){
	Sport.set(sport);
}
public StringProperty SportProperty(){
	return Sport;
}
public String getGroupe() {
	return groupe.get();
}
public StringProperty groupeProperty() {
	return groupe;
}
public void setGroupe(String groupe) {
	this.groupe.set(groupe);
}
public String getDate_inscript() {
	return date_inscript.get();
}
public StringProperty date_inscriptProperty() {
	return date_inscript;
}
public void setDate_inscript(String date_inscript) {
	this.date_inscript.set(date_inscript);
}
}
