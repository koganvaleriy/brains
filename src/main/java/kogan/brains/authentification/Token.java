package kogan.brains.authentification;

import java.util.UUID;

public class Token {
	
	String token;
	
	public Token() {
		token = this.generateToken();
	}

	private String generateToken() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");;
        return uuid;
	}

	public Token(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
