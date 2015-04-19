package com.amarinperez.pseudotwitter;

public class PostCommand implements Command {
	private PseudoTwitter twitter;
	private String username;
	private String message;

	public PostCommand(PseudoTwitter twitter, String username, String message) {
		this.twitter = twitter;
		this.username = username;
		this.message = message;
	}

	public String execute() {
		twitter.post(username, message);
		return "posted!";
	}

}
