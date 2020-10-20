package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personne{
	private StringProperty name;
	private StringProperty surname;
	private StringProperty cni;
	private StringProperty tel;
	private StringProperty email;
		   public Personne(){
				super();
				 this.name= new SimpleStringProperty();
				 this.surname= new SimpleStringProperty();
				 this.cni= new SimpleStringProperty();
				 this.tel= new SimpleStringProperty();
				 this.email= new SimpleStringProperty();
			}
		public Personne(String name, String surname, String cni, String tel, String email) {
			super();
			 this.name= new SimpleStringProperty(name);
			 this.surname= new SimpleStringProperty(surname);
			 this.cni= new SimpleStringProperty( cni);
			 this.tel= new SimpleStringProperty(tel);
			 this.email= new SimpleStringProperty(email);
		}
		public Personne(String name, String surname, String cni) {
			 this.name= new SimpleStringProperty(name);
			 this.surname= new SimpleStringProperty(surname);
			 this.cni= new SimpleStringProperty( cni);
		}
		public StringProperty cniProperty() {
			return cni;
		}
		public void setCni(String cni) {
			this.cni.set(cni);
		}
		public String getCni() {
			return cni.get();
		}
		public StringProperty nameProperty() {
			return name;
		}
		public void setName(String name) {
			this.name.set(name);
		}
		public String getName() {
			return this.name.get();
		}
		public StringProperty surnameProperty() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname.set(surname);
		}
		public String getSurname() {
			return surname.get();
		}
		public StringProperty telProperty() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel.set(tel);
		}
		public String getTel() {
			return tel.get();
		}
		public StringProperty emailProperty() {
			return email;
		}
		public void setEmail(String email) {
			this.email.set(email);
		}
		public String getEmail() {
			return email.get();
		}
}
