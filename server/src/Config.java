
public class Config {
	
	// DATABASE //
	//private static String DB_HOST = "192.168.1.50";
	//private static String DB_NAME = "globalmusic";
	//private static String DB_USER = "global";
	//private static String DB_PASS = "!ZeroCube0112358";
	
	private static String DB_HOST = "10.1.63.200";
	private static String DB_NAME = "CIS017_1807379";
	private static String DB_USER = "1807379";
	private static String DB_PASS = "1807379";

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