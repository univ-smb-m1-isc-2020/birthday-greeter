import java.time.LocalDate;

public class Person {

    LocalDate birthday;
    String mail;
    String name;

    public Person(String name, String mail, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
        this.mail = mail;
    }
}
