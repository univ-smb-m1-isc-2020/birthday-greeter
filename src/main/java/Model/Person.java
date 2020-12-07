package Model;

import java.util.Date;

public class Person {
    private String _name;
    private String _email;
    private Date _birthDate;

    public Person(String name, String email, Date birthDate){
        this._name = name;
        this._email = email;
        this._birthDate = birthDate;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        this._email = email;
    }

    public Date getBirthDate() {
        return _birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this._birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "_name='" + _name + '\'' +
                ", _email='" + _email + '\'' +
                ", _birthDate=" + _birthDate +
                '}';
    }
}
