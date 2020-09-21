package comm;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import comm.Receptor.OnMessageListener;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class Session{

	private String username;
	private Socket socket;
	private Emisor emisor;
	private Receptor receptor;

	private OnMessageListener listener;

	public Session(Socket socket) {
		try {
			this.socket = socket;
			receptor = new Receptor(this,socket.getInputStream());
			receptor.start();
			emisor = new Emisor(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Emisor getEmisor() {
		return this.emisor;
	}

	public Receptor getReceptor() {
		return this.receptor;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void closeSocket() {
		try {
			socket.close();
		} 
		catch (SocketException a) {
//			System.out.println("Socket cerrado");
			a.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
