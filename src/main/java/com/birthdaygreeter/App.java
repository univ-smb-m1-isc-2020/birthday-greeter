package com.birthdaygreeter;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;
import java.util.ArrayList;
import java.util.Data;

/**
 * Hello world!
 *
 */
public class App
{
    final static String PEOPLE_FILENAME = "birthdays.txt";

    public static List<People> getPeople() {

        ArrayList<People> people = new ArrayList<People>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(PEOPLE_FILENAME));

            for (String line : lines) {
                String[] tokens = line.split("; ", 3);
            
                people.add(new People(tokens[0], tokens[1], tokens[2]));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return people;
    }
    
    public static void main( String[] args )
    {
        List<People> people = getPeople();
    }
}
