import javax.accessibility.AccessibleRelationSet;
import java.io.*;
import java.util.ArrayList;

public class Parser
{
    ///Attributes
    ArrayList<Person> persons = new ArrayList();

    ///Constructors
    public Parser(String filepath) throws Exception
    {
        this.parseTxtFile(filepath);
    }

    ///Methods
    private void parseTxtFile(String filepath) throws Exception
    {
        //we assume the format is name followed by ; then email adress followed by ; then birthday in iso format
        String line;
        String[] array;
        String name;
        String emailAdress;
        String[] birthDate;
        int birthMonth;
        int birthDay;
        Person p;

        File file = new File(filepath);
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((( line = br.readLine() ) != null))
        {
            array = line.split(";");
            name = array[0];
            emailAdress = array[1];
            birthDate = array[2].split("-");
            birthMonth = Integer.parseInt(birthDate[1]) - 1;
            birthDay = Integer.parseInt(birthDate[2]);
            p = new Person(birthDay, birthMonth, name, emailAdress);

            this.persons.add(p);

        }
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }
}