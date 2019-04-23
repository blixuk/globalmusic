import java.util.*;
import java.io.*;
import java.net.Socket;

public class Client 
{
	public static void main(String[] args) {
		Scanner consoleInput = new Scanner(System.in);
		Socket server;

		try {
			server = new Socket(Config.getHost(), Config.getPort()); //Connect to server

			ObjectOutputStream socketOut = new ObjectOutputStream(server.getOutputStream());
			ObjectInputStream socketIn = new ObjectInputStream(server.getInputStream());

			Logger.log("Client Connected");
			Logger.log(server.toString());

			while (true) {
				Logger.log("Sent: ");
				String userInput = consoleInput.nextLine(); //Get user input
				Map<String, String> header = new HashMap<>();
				header.put("GET",  userInput);

				socketOut.writeObject(header); //Send data to server

				String serverResponse = (String) socketIn.readObject(); //Read data from server

				Logger.log("Received: " + serverResponse); //Log data from server
			}

		} catch (Exception e) {
			Logger.error("Exception", e); //Log error
			consoleInput.close();
		}
	}
}