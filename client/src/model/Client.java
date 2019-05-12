import java.util.*;
import java.io.*;
import java.net.Socket;

public class Client 
{
	public static void main(String[] args) {
		Scanner consoleInput = new Scanner(System.in); //System input from the console
		Socket server;

		try {
			server = new Socket(Config.getHost(), Config.getPort()); //Connect to server using host and port

			ObjectOutputStream socketOut = new ObjectOutputStream(server.getOutputStream()); //Create object output stream for outbound data
			ObjectInputStream socketIn = new ObjectInputStream(server.getInputStream()); //Create object input stream for inbound data

			Logger.log("Client Connected");
			Logger.log(server.toString());

			//Map<String, String> call = new HashMap<>();
			//call.put("CREATE_USER", "null,testuser1,password,bob,smith,test@test.com,09090909090,null,1991-10-10,2019-10-10,1");
			//socketOut.writeObject(call);

			while (true) {
				String userInput = consoleInput.nextLine(); //Get user input

				Map<String, String> header = new HashMap<>(); //Create a hash map for a tuple
				header.put("USER",  userInput); //Create a tuple from user input

				socketOut.writeObject(header); //Send data to server

				Logger.log("Sent: " + userInput);

				String serverResponse = (String) socketIn.readObject(); //Read data from server

				Logger.log("Received: " + serverResponse); //Log data from server
			}

		} catch (Exception e) {
			Logger.error("Exception", e); //Log error
			consoleInput.close();
		}
	}
}