package comm;

import java.io.*;

public class Emisor {

	private OutputStream os;
	private BufferedWriter bw;
	
	public Emisor(OutputStream os) {
		this.os = os;
		bw = new BufferedWriter(new OutputStreamWriter(this.os));
	}
	
	public void sendMessage(String msg) {
		new Thread(
				()->{
					try {
						bw.write(msg+"\n");
						bw.flush();
					} catch (IOException e) {
						
					}
				}
				).start();
	}
}
