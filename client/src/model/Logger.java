
import java.time.*;

public class Logger {

	public static void log(String data) {
		System.out.println(LocalDate.now() + " " + LocalTime.now() + " - " + data);
	}

}