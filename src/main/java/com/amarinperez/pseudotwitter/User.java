package com.amarinperez.pseudotwitter;

public class User {
	private String username;
	private Timeline timeline;

	public User(String username) {
		this.username = username;
		timeline = new Timeline();
	}

	public String getUsername() {
		return username;
	}

	public void post(String message) {
		timeline.add(message);
	}
	
	public String toString()
	{
		return timeline.toString();
	}

}
