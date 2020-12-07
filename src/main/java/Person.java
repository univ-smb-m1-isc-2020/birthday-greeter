public class Person {

    private String name;
    private String email;
    private String date;

    public Person(String name, String email, String date) {
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", date='" + date + '\'' +
                '}';
    }


    public boolean isBirthday(String dateToday){
        String date = this.getDate();
        String lines[] = date.split("-");
        date = lines[1] + "-" + lines[2];

        if (date.equals(dateToday)) {
            return true;
        }

        return false;
    }
}
