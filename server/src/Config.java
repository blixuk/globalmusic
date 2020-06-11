
public class Config {
	
	private static String DB_HOST = "IPADDRESS";
	private static String DB_NAME = "DBNAME";
	private static String DB_USER = "USERNAME";
	private static String DB_PASS = "PASSWORD";

	public static String getHost() {
		return DB_HOST;
	}

	public static String getName() {
		return DB_NAME;
	}

	public static String getUser() {
		return DB_USER;
	}

	public static String getPass() {
		return DB_PASS;
	}

	// SERVER //
	private static int S_PORT = 5959;

	public static int getPort() {
		return S_PORT;
	}

}
