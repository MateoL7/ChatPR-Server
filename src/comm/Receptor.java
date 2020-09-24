package comm;
import java.io.*;

public class Receptor extends Thread {

	private InputStream is;

	private Session s;

	public OnMessageListener listener;

	public Receptor(Session s, InputStream is) {
		this.is = is;
		this.s = s;
	}

	@Override
	public void run() {
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(this.is));

			while(true) {
				String msg = br.readLine();
				if(msg == null) {
					TCPConnection.getInstance().disconnected(s);
					s.closeSocket();
					break;
				}else {
					if(listener!=null) listener.OnMessage(s, msg);
					else System.out.println("No hay Observer");

				}
			}
		} catch(IOException e ) {
			System.out.println("Excepcion en receptor server");
		}
	}
	public void setListener(OnMessageListener listener) {
		this.listener = listener;
	}

	public interface OnMessageListener{
		public void OnMessage(Session s, String msg);
	}
}