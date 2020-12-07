package remi.matrod.birthdaygreeter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Parser {
	public static ArrayList<User> parseFile(String file) throws Exception {
		ArrayList<User> userList = new ArrayList<>();
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		int linePos = 1; // Line position (for error detection)
		
		while (line != null) {
			if (!line.trim().isEmpty()) {
				// We only check non empty lines
				try {
					String[] values = line.split("; ");
					userList.add(new User(values[0], values[1], values[2]));				
				} catch (Exception e) {
					// We skip faulty lines and show an error message
					System.err.println("Error found on line " + linePos + ". Skipping to the next line.");
				}
			}
			
			line = reader.readLine();
			linePos++;
		}
		
		reader.close();
		return userList;
	}
}
