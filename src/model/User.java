package model;

public class User {

	public String type = "User";
	private String username;
	
	public User() {}
	
	public User(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	

	public String getType() {
		return type;
	}
	
}
