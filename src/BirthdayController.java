import java.util.ArrayList;
import java.util.Date;

public class BirthdayController {

	public void start(String fileName, Date d) {
		Reader r = new Reader(fileName);
	
		ArrayList<String> liste = r.ligneDuJour(d);
		
		//2 Envoie
		String[] cLigne;
		String cMail;
		String cNom;
		
		System.out.println("Liste anniversaire du " + d);
		for(int i=0; i<liste.size(); i++) {
			cLigne = liste.get(i).split(";");
			cNom = cLigne[0];
			cMail = cLigne[1];
			//TODO gestion d'erreur (exemple mail invalide)
		
			//TEST
			System.out.println("-> " + cNom + ", " + cMail);
			//Envoyer le mail
		}
	}
	
}
