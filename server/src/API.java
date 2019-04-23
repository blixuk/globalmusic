import java.util.*;

public class API 
{
	private static String output;

	public static String parse(Map data) {
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

		return output;
	}

}