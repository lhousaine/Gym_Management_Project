package model;

import javafx.collections.ObservableList;

public interface EntraineurD {
	public ObservableList<Entraineur> displayEntraineurs();
	public void insert(Entraineur ent);
	public void delete(Entraineur ent);
}
