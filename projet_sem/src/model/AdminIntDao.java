package model;

import javafx.collections.ObservableList;

public interface AdminIntDao {
	public int add(Admin A);
	public int modify(Admin A);
	public int select(Admin A);
	public void remove(String AdId);
	public int tableRowNumber(Admin A);
	int selectAdmins(Admin A);
	void updatepassword(String adId, String pass);
	ObservableList<Admin> displayAdmins();
}
