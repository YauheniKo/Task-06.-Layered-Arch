package by.company.library.bean;

public class User {

	public static boolean AGE_LIM;
	private String login;
	private String password;
	private int age;
	public static final String USER_FILE = "User.txt";

	public User(String login, String password, int age) {

		this.login = login;
		this.password = password;
		this.age = age;

		if (getAge() < 18) {
			AGE_LIM = false;
		} else
			AGE_LIM = true;

	}
	public User(String login, String password, boolean AGE_LIM) {

		this.login = login;
		this.password = password;
		this.AGE_LIM = AGE_LIM;

		
	}
	public User(String login, String password) {

		this.login = login;
		this.password = password;
		

		
	}

	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", AGE_LIM=" + AGE_LIM + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}
