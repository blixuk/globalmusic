
import java.time.*;

public class Logger 
{


	public static void log(String data) {
		String datetime = LocalDate.now() + " " + LocalTime.now();
		System.out.println(datetime + " " + data);
	}

	public static void error(String name, Exception e) {
		String datetime = LocalDate.now() + " " + LocalTime.now();
		System.err.println(datetime + " " + name + " " + e.getMessage());
		e.printStackTrace();
	}

}