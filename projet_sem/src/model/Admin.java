package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Admin extends Personne{
private StringProperty password;
public Admin() {
	super();
	 this.password= new SimpleStringProperty();
}
public Admin(String name, String password) {
	super();
	 this.password= new SimpleStringProperty(password);
}
public Admin(String name, String surname,String cni,String tel, String email, String password){
	super(name,surname,cni,tel,email);
	 this.password= new SimpleStringProperty(password);
}
public Admin(String name, String surname, String cni, String tel, String email){
super(name,surname,cni,tel,email);
}
public String getPassword(){
	return password.get();
}
public void setPassword(String password){
	this.password.set(password);
}
public StringProperty passwordProperty(){
	return password;
}
}
