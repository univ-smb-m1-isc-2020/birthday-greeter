import java.util.Date;

public class Main{
    public static void main(String[]args) throws Exception
    {
        Parser parse = new Parser("../birthdays.txt");
        Date today = new Date();

        for (int i = 0; i < parse.getPersons().size() ; ++i)
        {
            Person p = parse.getPersons().get(i);
            if (p.compareBirthDayAndBirthMonth(today.getDay(), today.getMonth()))
            {
                //send email and stuff
            }
        }
    }
}
