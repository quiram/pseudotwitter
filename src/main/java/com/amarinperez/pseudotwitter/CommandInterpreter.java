package com.amarinperez.pseudotwitter;

public class CommandInterpreter {
	private PseudoTwitter twitter;

	public CommandInterpreter(PseudoTwitter twitter) {
		this.twitter = twitter;
	}

	public Command interpret(String line) {
		if (line.contains("->")) {
			String[] elements = line.split("->");
			String username = elements[0].trim();
			String message = elements[1].trim();
			return new PostCommand(twitter, username, message);
		} else if (line.contains("follows")) {
			String[] elements = line.split("follows");
			String follower = elements[0].trim();
			String followee = elements[1].trim();
			return new FollowComand(twitter, follower, followee);
		} else if (line.contains("wall") && line.split(" ").length == 2) {
			String username = line.split(" ")[0];
			return new WallComand(twitter, username);
		} else {
			return new ReadCommand(twitter, line);
		}
	}
}
