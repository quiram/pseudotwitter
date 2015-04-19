package com.amarinperez.pseudotwitter;

import java.util.ArrayList;
import java.util.Collection;

public class User {
	private String username;
	private Timeline timeline;
	private ArrayList<User> followees;

	public User(String username) {
		this.username = username;
		timeline = new Timeline();
		followees = new ArrayList<User>();
	}

	public String getUsername() {
		return username;
	}

	public void post(String message) {
		timeline.add(message);
	}

	public String toString() {
		return timeline.toString();
	}

	public Collection<User> getFollowees() {
		return followees;
	}

	public void follows(User carmen) {
		followees.add(carmen);
	}

}
