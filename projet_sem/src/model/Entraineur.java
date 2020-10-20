package model;

import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class Entraineur extends Personne{
	   private StringProperty Sport;
	   private IntegerProperty montantg;
	   private StringProperty photo;
	   private StringProperty experience;
	   private StringProperty passementSal;
	   private StringProperty date_recrute;
	public Entraineur(){
			super();
			 this.montantg= new SimpleIntegerProperty();
			 this.photo= new SimpleStringProperty();
			 this.Sport= new SimpleStringProperty();
			 this.experience= new SimpleStringProperty();
			 this.passementSal=new SimpleStringProperty();
			 this.date_recrute=new SimpleStringProperty();
	}
	public Entraineur(String name, String surname, String cni, String tel, String email,String sport, 
			int montantg,String photo,String experience,String passesal,String date_recrut) {
		super(name,surname,cni,tel,email);
		 this.montantg= new SimpleIntegerProperty(montantg);
		 this.photo= new SimpleStringProperty(photo);
		 this.Sport= new SimpleStringProperty(sport);
		 this.passementSal= new SimpleStringProperty(passesal);
		 this.experience= new SimpleStringProperty(experience);
		 this.date_recrute= new SimpleStringProperty(date_recrut);
	}
	public Entraineur(String name, String surname, String cni, int montantg,String passesal,String photo,String experience) {
		super(name,surname,cni);
		 this.photo= new SimpleStringProperty(photo);
		 this.experience= new SimpleStringProperty(experience);
		 this.montantg= new SimpleIntegerProperty(montantg);
		 this.passementSal= new SimpleStringProperty(passesal);
	}
	public StringProperty SportProperty() {
		return Sport;
	}
	public String getSport() {
		return Sport.get();
	}
	public void setSport(String sport) {
		Sport.set(sport);
	}
	public IntegerProperty montantgProperty() {
		return montantg;
	}
	public int getMontantg() {
		return montantg.get();
	}
	public void setMontantg(int montantg) {
		this.montantg.set(montantg);
	}
	public StringProperty PhotoProperty() {
		return photo;
	}
	public String getPhoto() {
		return photo.get();
	}
	public void setPhoto(String photo) {
		this.photo.set(photo);
	}
	public StringProperty experienceProperty() {
		return experience;
	}
	public String getExperience() {
		return experience.get();
	}
	public void setExperience(String experience) {
		this.experience.set( experience);
	}
	   public String getPassementSal() {
			return passementSal.get();
		}
	   public StringProperty passementSalProperty() {
			return passementSal;
		}
		public void setPassementSal(String passementSal) {
			this.passementSal.set(passementSal);
		}
		public String getDate_recrute() {
			return date_recrute.get();
		}
		public StringProperty date_recruteProperty() {
			return date_recrute;
		}
		public void setDate_recrute(String date_recrute) {
			this.date_recrute.set(date_recrute);
		}
}
