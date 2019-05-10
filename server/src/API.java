import java.util.*;

public class API 
{
	private static String output;

	public static String parse(Map data) throws java.sql.SQLException, java.lang.ClassNotFoundException{
		Map<String, String> header = data;

		if (header.containsKey("GET")) {
			Logger.log("Received: " + (String) header.get("GET"));
			switch ((String) header.get("GET")) {
				case "Hello":
					output = "this is an api";
					break;
				default:
					output = (String) header.get("GET");
			}
		}

		if (header.containsKey("CREATE_USER")) {
			Logger.log("API: create user");
			String args[] = header.get("CREATE_USER").split(",");
			DB.createUser(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10]);
			Logger.log("API: user created");
			output = "user created: " + args[1];
		}

		return output;
	}

}