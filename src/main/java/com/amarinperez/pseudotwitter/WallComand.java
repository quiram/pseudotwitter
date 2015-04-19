package com.amarinperez.pseudotwitter;

public class WallComand implements Command {

	private PseudoTwitter twitter;
	private String username;

	public WallComand(PseudoTwitter twitter, String username) {
		this.twitter = twitter;
		this.username = username;
	}

	@Override
	public String execute() {
		return twitter.wall(username);
	}

}
