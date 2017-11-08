package kogan.herokuresttest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table (name = "users")
@Entity
public class Account {
	@Id
	private String username;
	private String email;
	private String password;

	public Account() {

	}

	public Account(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
