package model;

import javafx.collections.ObservableList;

public interface sportdaoi {
	public void insert(Sport s);
    public  ObservableList<Sport> sportlist();
    public void supprimersport(String name);
}
