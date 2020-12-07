import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TimerTask;

public class BirthdayTask extends TimerTask {

    ArrayList<Person> persons;

    public BirthdayTask(ArrayList<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void run() {
        System.out.println("Running new check...");
        LocalDate currentDate = LocalDate.now();

        for (Person p : persons) {
            if (p.birthday.getDayOfMonth() == currentDate.getDayOfMonth() && p.birthday.getMonth() == currentDate.getMonth()) {
                MailSender.sendBirthdayMail(p);
            }
        }
    }
    
}
