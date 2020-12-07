package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class FileParser {
    public static ArrayList<Person> fetchPeopleFromFile(File file) throws IOException, ParseException {
        ArrayList<Person> res = new ArrayList<Person>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String line;
        String[] args = new String[3];

        while (((line = br.readLine()) != null)) {
            args = line.split("; ");
            Person p = new Person(args[0], args[1], LocalDate.parse(args[2], dateTimeFormatter));
            res.add(p);
        }
        return res;
    }
}
