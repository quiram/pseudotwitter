package com.amarinperez.pseudotwitter;

public class FollowComand implements Command {

	private PseudoTwitter twitter;
	private String follower;
	private String followee;

	public FollowComand(PseudoTwitter twitter, String follower, String followee) {
		this.twitter = twitter;
		this.follower = follower;
		this.followee = followee;
	}

	@Override
	public String execute() {
		twitter.follow(follower, followee);
		return "following!";
	}

}
