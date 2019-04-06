
import java.net.*;
import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Main
{

	ServerSocket ss; // Defining the initial Server Socket
	Socket s; // Defining the initial socket
	DataInputStream dis; // Defining Data Input Steam
	DataOutputStream dos; // Defining Data Output Stream

	public static final void main(String[] args) throws IOException {
		new Main(); // Creating a new instance of the constructor
	}

	public Main() {
		try {
			ss = new ServerSocket(Config.getPort()); // Assigning the new socket to the Port
			s = ss.accept(); // Accept connections from client
			dis = new DataInputStream(s.getInputStream()); // Establishing the DataInput from the Socket
			dos = new DataOutputStream(s.getOutputStream()); // Establishing the output to the Socket
			Listner(); // Run the Listner Loop for sending and receiving data
		} catch (IOException e) {
			Logger.log("IOException: " + e.getMessage()); //Log exception
		}
	}


	public void Listner() {
		while (true) {
			try {
				while (dis.available() == 0) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						Logger.log("InterruptedException: " + e.getMessage()); //Log exception
					}
				}

				String responce = dis.readUTF();
				dos.writeUTF(responce);
				Logger.log("Received: " + responce); //Log Received Data

			} catch (IOException e) {
				Logger.log("IOException: " + e.getMessage()); //Log exception
				break;
			}
		}

		try {
			dis.close(); // Close Data Input Steam
			dos.close(); // Close Data Output Stream
			s.close(); // Close Initial Socket
			ss.close(); // Close Initial Server Socket
		} catch (IOException e) {
			Logger.log("IOException: " + e.getMessage()); //Log exception
		}

	}

}
