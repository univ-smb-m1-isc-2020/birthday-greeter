import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Reader {

	public FileReader file;
	
	/**
	 * @param fileName
	 * 				
	 */
	public Reader(String fileName) {
		try {
			this.file = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> ligneDuJour(Date date){
		ArrayList lLigneDuJour = new ArrayList<String>();
		
		BufferedReader objReader = new BufferedReader(file);
		String currentLine;
		
		try {
			//1 lecture du fichier
			while((currentLine = objReader.readLine()) != null) {
				
				//2 - découpe de la ligne 
				String[] parts = currentLine.split(";");
				
				if(parts.length >= 3) {//3 TODO vérifier plus poussé ex le format du 3eme éléments est bon avant la suite
					
					//4 vérification si même date (mois et jours)
					String[] partsDate = parts[2].split("-");
					partsDate[0] = partsDate[0].replaceAll("\\s", "");
					
					Date cDate = new Date(Integer.parseInt(partsDate[0]), Integer.parseInt(partsDate[1]), Integer.parseInt(partsDate[2]));
					if(date.getMonth() == cDate.getMinutes() && date.getDay() == cDate.getDay()) {
						lLigneDuJour.add(currentLine);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lLigneDuJour;
	}

}
