package control;



import java.util.ArrayList;

import com.google.gson.Gson;

import comm.TCPConnection;
import comm.TCPConnection.OnConnectionListener;
import javafx.application.Platform;
import model.ConnectionPossible;
import model.DirectMessage;
import model.Generic;
import model.Members;
import model.Message;
import model.User;
import comm.Receptor.OnMessageListener;
import comm.Session;
import view.ChatWindow;

public class ChatController implements OnMessageListener, OnConnectionListener{

	private ChatWindow view;
	private TCPConnection connection;
	
	private String username;

	public ChatController(ChatWindow view) {
		this.view = view;
		init();
	}

	public void init() {
		connection = TCPConnection.getInstance();
		connection.setPuerto(5000);
		connection.start();
		connection.setConnectionListener(this);
		connection.setMessageListener(this);	

	}


	@Override
	public void onConnection(String username) {
		Platform.runLater(

				()->{
					view.getMessagesArea().appendText("<<< "+ username +" se ha conectado >>>\n");
				}

				);
	}

	@Override
	public void OnMessage(Session s, String msg) {

		//
		Gson gson = new Gson();
		Generic type = gson.fromJson(msg, Generic.class);
		switch (type.getType()) {
		case "Message":
			connection.sendBroadcast(msg);
			break;
		case "DirectMessage":
			DirectMessage dm = gson.fromJson(msg, DirectMessage.class);
			connection.sendDirectMessage(dm.getToClient(), msg);
			break;
		case "User":
			User u = gson.fromJson(msg, User.class);
			s.setUsername(u.getUsername());
			//Existe
			boolean exists = connection.userExists(u);
			if(u.getUsername().isEmpty()) {
				exists = true;
			}
			ConnectionPossible cp = new ConnectionPossible(!exists);
			String jsonConnection = gson.toJson(cp);
			connection.sendApproval(s, jsonConnection);
			if(exists) {

				connection.removeFromWaitList(s);

			}
			//No existe
			else {
				connection.addUserToConnect(s, u);
				username = u.getUsername();
			}
			break;
		case "ConnectionPossible":
			ArrayList<User> users = new ArrayList<>();
			for(int i=0;i<connection.getSessions().size();i++) {
				users.add(new User(connection.getSessions().get(i).getUsername()));
			}
			Members m = new Members(users);
			String ms = gson.toJson(m);
			connection.sendBroadcast(ms);
			break;
		}
	}
}
