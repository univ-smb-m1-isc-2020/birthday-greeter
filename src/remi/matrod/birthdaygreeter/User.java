package remi.matrod.birthdaygreeter;

public class User {
	private String name;
	private String mail;
	private String birthdate;
	
	public User(String name, String mail, String birthdate) {
		this.name = name;
		this.mail = mail;
		this.birthdate = birthdate;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public String getBirthDate() {
		return this.birthdate;
	}
}
