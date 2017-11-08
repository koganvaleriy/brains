package kogan.herokuresttest.api;

public class AccountData {
	
	public String username;
	public String email;
	public String password;

	public AccountData() {

	}

	public AccountData(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
}
