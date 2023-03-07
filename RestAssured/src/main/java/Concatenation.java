import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Concatenation {

	public static void main(String[] args) {
		String a1 = "Aravinda";
		String a2 = "30";

		System.out.println(a1 + "." + a2 + " " + getCurrentDateTime());

	}

	public static String getCurrentDateTime() {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		return timeStamp;
	}

}
