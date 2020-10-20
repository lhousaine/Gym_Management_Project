package model;

import javafx.collections.ObservableList;

public interface tarifintdao {
	 public ObservableList<Tarifs> SelectTarifs();
	 public void modifierTarif(Tarifs tr);
}
