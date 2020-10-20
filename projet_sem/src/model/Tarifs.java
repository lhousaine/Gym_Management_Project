package model;

public class Tarifs {
private int id;
private String N_mois;
private String Categorie;
private float prix;
public Tarifs() {
	super();
}
public Tarifs(String n_mois, String categorie, float prix) {
	super();
	this.N_mois = n_mois;
	this.Categorie = categorie;
	this.prix = prix;
}
public Tarifs(int id,String n_mois, String categorie, float prix) {
	super();
	this.id = id;
	N_mois = n_mois;
	Categorie = categorie;
	this.prix = prix;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getN_mois() {
	return N_mois;
}
public void setN_mois(String n_mois) {
	N_mois = n_mois;
}
public String getCategorie() {
	return Categorie;
}
public void setCategorie(String categorie) {
	Categorie = categorie;
}
public float getPrix() {
	return prix;
}
public void setPrix(float prix) {
	this.prix = prix;
}
}
