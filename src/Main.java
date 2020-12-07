import java.util.Date;

public class Main {

	public static void main(String[] args) {
		String fileName = "birthdays.txt";
		
		//Date d = new Date();
		Date d = new Date(1999,6,27);
		
		BirthdayController bc = new BirthdayController();
		bc.start(fileName, d);

	}

}
