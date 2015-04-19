package com.amarinperez.pseudotwitter;

public class ReadCommand implements Command {
	private PseudoTwitter twitter;
	private String username;

	public ReadCommand(PseudoTwitter twitter, String username) {
		this.twitter = twitter;
		this.username = username;
	}

	public String execute() {
		return twitter.getTimeline(username);
	}

}
