package remi.matrod.birthdaygreeter;

import java.util.ArrayList;

public class Main {

	public static ArrayList<User> users;
	
	public static void main(String[] args) {
		String birthdayFilePos = "birthdays.txt";
		if (args.length > 0) {
			birthdayFilePos = args[0];
		}
		
		try {
			users = Parser.parseFile(birthdayFilePos);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		for (User user : users) {
			System.out.println(user.getName() + " - " + user.getMail() + " - " + user.getBirthDate());
		}
	}
}