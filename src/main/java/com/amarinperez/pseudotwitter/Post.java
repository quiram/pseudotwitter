package com.amarinperez.pseudotwitter;

import static java.time.LocalDateTime.now;

import java.time.LocalDateTime;

public class Post {
	private String message;
	private String username;
	private LocalDateTime timestamp;

	public Post(String username, String message) {
		this.message = message;
		this.username = username;
		timestamp = now();
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

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getAge() {
		AgeCalculator calc = new AgeCalculator();
		return calc.getAge(timestamp, now());
	}
}
