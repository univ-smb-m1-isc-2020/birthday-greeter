public class Person
{
    ///Attributes
    private String name;
    private String emailAdress;
    private int birthMonth; // represents months from 0 (Jan) to 11 (Dec)
    private int birthDay; //represents days of the month, range from 1 to 31

    public Person(int birthDay, int birthMonth, String name, String emailAdress)
    {
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.name = name;
        this.emailAdress = emailAdress;
    }

    public boolean compareBirthDayAndBirthMonth(int day, int month)
    {
        return day == this.birthDay && month == this.birthMonth;
    }


}