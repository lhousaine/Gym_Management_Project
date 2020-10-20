package model;

public class image {
private int Num;
private String path;
public image(int num, String path) {
	super();
	Num = num;
	this.path = path;
}
public image() {
	super();
}
public int getNum() {
	return Num;
}
public void setNum(int num) {
	Num = num;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
}
