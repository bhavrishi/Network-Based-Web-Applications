import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*Author
 * Bhargava Tarigopula and Shail Patel
 */
public class ServerSide {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSide server= new ServerSide();
		server.serverSideMethod();
	}
	/*
	 * Java method that is responsible to send response to client when instantiated
	 */
public void serverSideMethod() throws IOException {
	ServerSocket server= new ServerSocket(444);
	Socket serverSocket= server.accept();
	InputStreamReader inputFromClient= new InputStreamReader(serverSocket.getInputStream());
	BufferedReader readClientMessage= new BufferedReader(inputFromClient);
	
	String message= readClientMessage.readLine();
	System.out.println("Message is "+message);
	
	if(message!=null)
	{
		PrintStream messageResponse= new PrintStream(serverSocket.getOutputStream());
		messageResponse.println("This is the response to client message");
	}
	
}
}
