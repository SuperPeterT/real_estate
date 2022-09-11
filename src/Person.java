public class Person {

	private String first_name;
	private String last_name;
	private String login;
	private String password;

	// Constructor
	public Person() {
		this.first_name = "";
		this.last_name = "";
		this.login = "";
		this.password = "";
	}

public Person(String first_name) {
	this.first_name = first_name;
	this.last_name = "";
	this.login = "";
	this.password = "";
}
	
	
	public Person(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public Person(String fname, String lname, String login, String password) {
		this.first_name = fname;
		this.last_name = lname;
		this.login = login;
		this.password = password;

	}

	// Getter
	public String getName() {
		return this.first_name + " " + this.last_name;
	}
	


	public String getFirstName() {
		return this.first_name;
	}

	public String getLastName() {
		return this.last_name;
	}

	public String getLogin() {
		return this.login;
	}

	public String getPassword() {
		return this.password;
	}

	// Setter

	public void setFname(String firstName) {
		this.first_name = firstName;
	}

	public void setLname(String lastName) {
		this.last_name = lastName;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public boolean passwordMatch(String anotherPassword) {
		if (this.password.equals(anotherPassword)) {
			return true;
		} else {
			return false;
		}

	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof Customer)) {
			return false;
		} else {

			Person compare = (Person) o;

			if (!this.login.equals(compare.getLogin())) {
				return false;
			} else if (passwordMatch(compare.password) == false) {
				return false;
			} else {
				return true;
			}
		}
	}


	@Override
	public int hashCode() {
		int key = 0;
		String combine = this.login + this.password;
		for (int i = 0; i < combine.length(); i++) {
			key += ((int) combine.charAt(i));
		}
		return key;
	}
}





