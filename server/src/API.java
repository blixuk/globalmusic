import java.util.*;

public class API 
{
	private static String output;

	public static String parse(Map data) throws java.sql.SQLException, java.lang.ClassNotFoundException{
		Map<String, String> header = data;

		if (header.containsKey("USER")) {
			Logger.log("Received: " + (String) header.get("USER"));
			switch ((String) header.get("USER")) {
				case "TEST":
					output = "THIS IS WORKING";
					break;
				default:
					output = (String) header.get("USER");
			}
		}

		if (header.containsKey("CREATE_USER")) {
			Logger.log("Received: " + (String) header.get("CREATE_USER"));
			String args[] = header.get("CREATE_USER").split(",");
			DB.createUser(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10]);
			Logger.log("DB: user created: " + args[0]);
			output = "Completed";
		}

		if (header.containsKey("CREATE_TICKET")) {
			Logger.log("Received: " + (String) header.get("CREATE_TICKET"));
			String args[] = header.get("CREATE_TICKET").split(",");
			DB.createTicket(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11]);
			Logger.log("DB: ticket created: " + args[0]);
			output = "Completed";
		}

		if (header.containsKey("CREATE_INVOICE")) {
			Logger.log("Received: " + (String) header.get("CREATE_INVOICE"));
			String args[] = header.get("CREATE_INVOICE").split(",");
			DB.createInvoice(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9]);
			Logger.log("DB: invoice created: " + args[0]);
			output = "Completed";
		}

		if (header.containsKey("CREATE_EVENT")) {
			Logger.log("Received: " + (String) header.get("CREATE_EVENT"));
			String args[] = header.get("CREATE_EVENT").split(",");
			DB.createEvent(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10]);
			Logger.log("DB: event created: " + args[0]);
			output = "Completed";
		}

		if (header.containsKey("CREATE_BAND")) {
			Logger.log("Received: " + (String) header.get("CREATE_BAND"));
			String args[] = header.get("CREATE_BAND").split(",");
			DB.createBand(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]);
			Logger.log("DB: band created: " + args[0]);
			output = "Completed";
		}

		if (header.containsKey("CREATE_VENUE")) {
			Logger.log("Received: " + (String) header.get("CREATE_VENUE"));
			String args[] = header.get("CREATE_VENUE").split(",");
			DB.createVenue(args[0], args[1], args[2], args[3]);
			Logger.log("DB: venue created: " + args[0]);
			output = "Completed";
		}

		return output;
	}

}