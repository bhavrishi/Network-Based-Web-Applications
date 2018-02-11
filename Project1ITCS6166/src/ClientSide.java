import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSide {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		ClientSide client= new ClientSide();
		client.clientSide();
	}
public void clientSide () throws UnknownHostException, IOException {
	Socket clientSocket= new Socket("localhost", 444);
	PrintStream loadMessageToServer= new PrintStream(clientSocket.getOutputStream());
	loadMessageToServer.println("Hello Server I am your new client created now");
	
	
	InputStreamReader readResponseFromServer = new InputStreamReader(clientSocket.getInputStream());
	BufferedReader buffer= new BufferedReader(readResponseFromServer);
	String serverResponse= buffer.readLine();
	System.out.println(serverResponse);

}
}
