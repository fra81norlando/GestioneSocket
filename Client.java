import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",2000);//istanzio socket (ip+porta)
			
			DataInputStream inFromServer = new DataInputStream(socket.getInputStream());
			String in = inFromServer.toString();
			
			DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
			outToServer.writeBytes("orario");
			
			socket.close();//chiusura socket
		} catch (IOException e) {
			System.err.println("Errore nella connessione al server nella porta 2000");//stampa errore nella connesione
			e.printStackTrace();
		}
	}
}
