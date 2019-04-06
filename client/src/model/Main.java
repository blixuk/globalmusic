
import java.net.*;
import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

public class Main
{

	Socket s; // Defining the initial socket
	DataInputStream dis; // Defining Data Input Steam
	DataOutputStream dos; // Defining Data Output Stream
	Scanner sysin = new Scanner(System.in);

	public static final void main(String[] args) {
		new Main(); // Creating a new instance of the constructor
	}

	public Main() {
		try {
			this.s = new Socket(); // Assigning the new socket
			this.s.connect(new InetSocketAddress(Config.getHost(), Config.getPort()), Config.getTimeout()); // Establishing the Connection to the sever
			this.dis = new DataInputStream(this.s.getInputStream()); // Establishing the DataInput from the Socket
			this.dos = new DataOutputStream(this.s.getOutputStream()); // Establishing the output to the Socket
			Listner(); // Run the Listner Loop for sending and receiving data
		} catch (SocketTimeoutException e) {
			//Do something on Timeout
			Logger.log("SocketTimeoutException: " + e.getMessage()); //Log exception
		} catch (IOException e) {
			Logger.log("IOException: " + e.getMessage()); //Log exception
		}
	}

	public void Listner() {
		while (true) {
			while (!sysin.hasNextLine()) {
				try {
					Thread.sleep(1); // Sleep to not overload the requests on the CPU
				} catch (Exception e) {
					Logger.log("Exception: " + e.getMessage()); //Log exception
				}
			}

			String input = this.sysin.nextLine();

			if (input.toLowerCase().equals("quit")) {
				break; // Break out of loop if input is equal to quit
			}

			try {
				this.dos.writeUTF(input);

				while (this.dis.available() == 0) {
					try {
						Thread.sleep(1);
					} catch (Exception e) {
						Logger.log("Exception: " + e.getMessage()); //Log exception
					}
				}

				String responce = this.dis.readUTF();
				Logger.log("Sent: " + responce); //Log Sent Data

			} catch (Exception e) {
				Logger.log("Exception: " + e.getMessage()); //Log exception
				break;
			}
		}

		try {
			dis.close(); // Close Data Input Steam
			dos.close(); // Close Data Output Stream
			s.close(); // Close Initial Socket
		} catch (Exception e) {
			Logger.log("Exception: " + e.getMessage()); //Log exception
		}
	}
}
