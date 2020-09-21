package model;

import java.util.ArrayList;

public class Members {

	public String type = "Members";
	public ArrayList<User> users;
	
	public Members() {}
	
	public Members(ArrayList<User> users) {
		this.users =users;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public String getType() {
		return type;
	}
	
}
