import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;

public class Main {


/*
* Lorsqu'on lance le programme, il doit vérifier la date du jour et envoyer un mail d'anniversaire
* */

    public static void main(String[] args) throws Exception {

        File file = new File("D:\\hhers\\Documents\\Univ_2020-2021\\S7\\Info 806 - Intégration\\birthday-greeter\\birthdays.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        while ((st = br.readLine()) != null){
            //System.out.println(st);
            String[] line = st.split(";",3);
            Personne p = new Personne(line[0], line[1], line[2]);
            System.out.println(p.toString());

        }

    }
}
