package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public abstract class FileParser {
    public static ArrayList<Person> fetchPeopleFromFile(File file) throws IOException, ParseException {
        ArrayList<Person> res = new ArrayList<Person>();
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        String[] args = new String[3];

        while ((line = br.readLine()) != null) {
            args = line.split("; ");
            PrintStringTabContent(args);
            Date currentBirthDate = MyStringToDateParser(args[2]);
            Person p = new Person(args[0], args[1], currentBirthDate);
            res.add(p);
        }
        return res;
    }

    private static Date MyStringToDateParser(String StringDate) {
        int year, month, day;
        String[] args = StringDate.split("-");
        year = Integer.parseInt(args[0]);
        month = Integer.parseInt(args[1]);
        day = Integer.parseInt(args[2]);
        return new Date(year, month, day);
    }

    public static void PrintStringTabContent(String[] args) {
        for(int i = 0; i < args.length; i++)
            System.out.println("i : " + args[i]);
    }
}
