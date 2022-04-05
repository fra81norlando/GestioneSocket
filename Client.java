import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try {
			String in;
			Socket socket = new Socket("127.0.0.1",2000);
			
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			in = inFromServer.toString();
			
			DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
			outToServer.writeBytes("Sincornizziamo l'ora");
		} catch (IOException e) {
			System.err.println("Errore nella connessione al server nella porta 2000");
			e.printStackTrace();
		}
	}
}
