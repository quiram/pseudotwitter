package com.amarinperez.pseudotwitter;

public class Post {
	private String message;
	private String username;

	public Post(String username, String message) {
		this.message = message;
		this.username = username;
	}

	public Post(String message) {
		this(null, message);
	}

	public String toString() {
		return message;
	}

	public String getUsername() {
		return username;
	}

	public String getMessage() {
		return message;
	}

}
