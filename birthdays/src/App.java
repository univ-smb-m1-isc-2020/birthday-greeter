import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;



public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please input birthday text file as argument");
            System.exit(1);
        }

        ArrayList<Person> persons = new ArrayList<Person>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();

            while (line != null) {

                System.out.println(line);
                String[] tokens = line.split(";");

                if(tokens.length != 3){
                    System.out.println("Invalid line");
                } else {
                    String name = tokens[0].trim();
                    String mail = tokens[1].trim();
                    LocalDate birthday = LocalDate.parse(tokens[2].trim());

                    persons.add(new Person(name, mail, birthday));
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Birthday routine

        Timer timer = new Timer();
        TimerTask task = new BirthdayTask(persons);

        timer.schedule(task, 0, 1000 * 60 * 60 * 24);

    }
}
