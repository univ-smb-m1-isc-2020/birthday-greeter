import Model.FileParser;
import Model.Person;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws IOException, ParseException {
        File file = new File(args[0]);
        ArrayList<Person> people = FileParser.fetchPeopleFromFile(file);

        for(int i = 0; i < people.size(); i++)
            System.out.println(people.get(i).toString());
    }
}
