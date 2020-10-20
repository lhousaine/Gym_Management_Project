package model;

public class Sport {
private String name;
private String entraineurName;
private int nombreM;
private String Categorie;

public Sport(String name, String entraineur, int nombreM, String categorie){
	super();
	this.name = name;
	this.entraineurName = entraineur;
	this.nombreM = nombreM;
	Categorie = categorie;
}
public Sport(String name,String entraineur, String categorie) {
	super();
	this.name = name;
	this.entraineurName = entraineur;
	Categorie = categorie;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEntraineur() {
	return entraineurName;
}
public void setEntraineur(String entraineur) {
	this.entraineurName = entraineur;
}
public int getNombreM() {
	return nombreM;
}
public void setNombreM(int nombreM) {
	this.nombreM = nombreM;
}
public String getCategorie() {
	return Categorie;
}
public void setCategorie(String categorie) {
	Categorie = categorie;
}
}
