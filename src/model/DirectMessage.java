package model;

public class DirectMessage {

	public String type = "DirectMessage";
	private String body;
	private String fromClient;
	private String toClient;
	
	public DirectMessage(String fromClient, String body, String toClient) {
		super();
		this.body = body;
		this.fromClient = fromClient;
		this.toClient = toClient;
	}
	
	public DirectMessage() {}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getFromClient() {
		return fromClient;
	}
	public void setDate(String fromClient) {
		this.fromClient = fromClient;
	}
	public String getToClient() {
		return toClient;
	}
	public void setClientID(String toClient) {
		this.toClient = toClient;
	}
	
	
	
}
