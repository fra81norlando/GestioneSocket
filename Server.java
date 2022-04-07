import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
	public static void main(String[] args) {
		try {
			
			ServerSocket serverSocket=new ServerSocket(2000);//apertura socket sulla porta 2000
			System.out.println("Server avviato correttamente");//stampa di avvio
			Socket socket=serverSocket.accept();
			System.out.println("Connessione avvenuta");//stampa di connessione avvenuta
			System.out.println("Socket: " +socket);
			DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());//creazione stream di output
			outToClient.writeBytes("Ciao");//invio messaggio di saluto 
			DataInputStream inFromClient = new DataInputStream(socket.getInputStream());//creazione stream di input
			String in = inFromClient.toString();
			if(in.equals("orario")) {
				SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
		        String timeStamp = date.format(new Date());// stampa data
		        outToClient.writeBytes(timeStamp);
			}
			serverSocket.close();//chiusura socket
		} catch(BindException e) {
			System.err.println("porta occupata");//errore in avvio programma di porta occupata
			e.printStackTrace();
		}
		catch (IOException e) {
			System.err.println("Errore avvio del server sulla porta 2000");//errore in avvio programma con porta 2000 occupata
			e.printStackTrace();
		}
	}
}
