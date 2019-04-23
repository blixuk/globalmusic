import java.io.*;
import java.net.*;
import java.util.*;

public class Server
{
	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(Config.getPort()); //Start server
			Logger.log("Server Running");
			Logger.log(serverSocket.toString());

			Socket clientSocket = serverSocket.accept(); //Accept client connection
			Logger.log("Client Connected");
			Logger.log(clientSocket.toString());

			ObjectOutputStream socketOut = new ObjectOutputStream(clientSocket.getOutputStream());
			ObjectInputStream socketIn = new ObjectInputStream(clientSocket.getInputStream());

			while (true) {
				//String clientInput = (String) socketIn.readObject(); //Read client input
				String clientInput = API.parse((Map) socketIn.readObject());

				if (clientInput.equalsIgnoreCase("exit")) {
					try {
						Logger.log("Sent: " + clientInput);
						break;
					} catch (Exception e) {
						Logger.error("Exception", e); //Log error
					}
				}

				Logger.log("Sent: " + clientInput);

				String converted = clientInput.toUpperCase();
				socketOut.writeObject(converted);
			}

			try {
				socketIn.close();
				socketOut.close();
				clientSocket.close();
				serverSocket.close();
			} catch (Exception e) {
				Logger.error("Exception", e); //Log error
			}

		} catch (Exception e) {
			Logger.error("Exception", e); //Log error
		}
	}
}