package model;

public class seance {
private String sports;
private String temps;
private String jour;
private String Entraineurs;
public seance(String sports, String temps, String jour) {
	super();
	this.sports = sports;
	this.temps = temps;
	this.jour = jour;
}
public seance(String sports, String temps, String jour, String entraineurs) {
	super();
	this.sports = sports;
	this.temps = temps;
	this.jour = jour;
	Entraineurs = entraineurs;
}
public String getSports() {
	return sports;
}
public void setSports(String sports) {
	this.sports = sports;
}
public String getTemps() {
	return temps;
}
public void setTemps(String temps) {
	this.temps = temps;
}
public String getJour() {
	return jour;
}
public void setJour(String jour) {
	this.jour = jour;
}
public String getEntraineurs() {
	return Entraineurs;
}
public void setEntraineurs(String entraineurs) {
	Entraineurs = entraineurs;
}
}
