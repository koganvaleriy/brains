package kogan.brains.api;

import javax.persistence.ManyToOne;

import kogan.brains.authentification.Token;
import kogan.brains.entities.Level;

public class UserData {
	
	public String username;
	public String email;
	public String password;
	public Token token;
	public int levelNumber;
	public int score;
	public String userStatus;
	
	public UserData() {

	}

	public UserData(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public UserData(String usernameOrEmail, String password) {
		super();
		this.username = usernameOrEmail;
		this.email = usernameOrEmail;
		this.password = password;
	}
	
	public UserData(String username, String email, String password, Token token, int levelNumber, int score,
			String userStatus) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.token = token;
		this.levelNumber = levelNumber;
		this.score = score;
		this.userStatus = userStatus;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Token getToken() {
		return token;
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

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public int getLevelNumber() {
		return levelNumber;
	}

	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}
	
	
	
	
}
