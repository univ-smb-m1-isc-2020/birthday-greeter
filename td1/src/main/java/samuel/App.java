package samuel;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        File file = new File("D:/Cours/M1/S1/INFO806/birthday-greeter/birthdays.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String[] arrayRes = input.nextLine().split(";");
            String name = arrayRes[0].trim();
            String mail = arrayRes[1].trim();
            String birth = arrayRes[2].trim();
            String birthWithoutYr = birth.split("-")[1] + "-" + birth.split("-")[2];
            if(birthWithoutYr.equals(date)){
                sendEmail(mail, name);
            }
        }
        input.close();
    }

    public static void sendEmail(String mail, String name) {
        System.out.println("c'est l'anniversaire de " + name + " : " + mail);
    }
}
