package model;

public class ConnectionPossible {
	
	public String type = "ConnectionPossible";
	private boolean possible;
	
	
	
	public ConnectionPossible(boolean possible) {
		super();
		this.possible = possible;
	}
	public String getType() {
		return type;
	}
	public boolean isPossible() {
		return possible;
	}
	
	
	
}
