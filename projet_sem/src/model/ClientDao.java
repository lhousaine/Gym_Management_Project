package model;

import java.sql.SQLException;

import javafx.collections.ObservableList;

public interface ClientDao {
	public void deleteClientWithId (String ClientId) throws SQLException, ClassNotFoundException;
	public  ObservableList<Client> displayClients();
	int add(Client P);
	public void modify (Client C,String ClientId) throws SQLException,ClassNotFoundException;
	public ObservableList<Client> ChercherClient(String name);
}
