package kogan.brains.model;

import java.util.ArrayList;

public class UserStatus {
	
	ArrayList<String> userStatuses;
	
	public UserStatus(ArrayList<String> userStatuses) {
		super();
		this.userStatuses = userStatuses;
	}

	public UserStatus() {
		super();
		userStatuses = new ArrayList<String>();
		userStatuses.add(0, "New User");
		userStatuses.add(1, "Advanced User");
	}

	public ArrayList<String> getUserStatuses() {
		return userStatuses;
	}

	public void setUserStatuses(ArrayList<String> userStatuses) {
		this.userStatuses = userStatuses;
	}
	
	

}
