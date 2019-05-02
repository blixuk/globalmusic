
public class Config {
	
	// SERVER //
	private static String S_HOST = "localhost";	// Server Host address
	private static int S_PORT = 5959;			// Server Port Address
	private static int S_TIMEOUT = 1000;		// Server Connection Timeout

	public static String getHost() {
		return S_HOST;
	}

	public static int getPort() {
		return S_PORT;
	}

	public static int getTimeout() {
		return S_TIMEOUT;
	}

}