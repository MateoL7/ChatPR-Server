package model;

public class Message {

	public String type = "Message";
	private String id;
	private String body;
	
	public Message() {}
	
	public Message(String id, String body) {
		super();
		this.id = id;
		this.body = body;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	
}
