package kogan.brains.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import kogan.brains.authentification.Token;
import kogan.brains.model.UserStatus;

import static kogan.brains.api.Tables.*;

@Table (name = USERS)
@Entity
public class User {
	
	@Id
	private String username;
	@Column(unique=true)
	private String email;
	private String password;
	private String token;
	
	@ManyToOne
	private Level level;
	private int score;
	private String userStatus;
	

	public User() {

	}

	public User(String username, String email, String password, Token token) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.token = token.getToken();
	}
	
	public User(String username, String email, String password, Token token, Level level, int score,
			String userStatus) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.token = token.getToken();
		this.level = level;
		this.score = score;
		this.userStatus = userStatus;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus, int userStatusNumber) {
		this.userStatus = userStatus.getUserStatuses().get(userStatusNumber);
	}

}
