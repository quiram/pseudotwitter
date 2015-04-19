package com.amarinperez.pseudotwitter;

public class CommandInterpreter {
	private PseudoTwitter twitter;

	public CommandInterpreter(PseudoTwitter twitter) {
		this.twitter = twitter;
	}

	public Command interpret(String line) {
		if (!line.contains("->")) {
			return new ReadCommand(twitter, line);
		} else {
			String[] elements = line.split("->");
			String username = elements[0].trim();
			String message = elements[1].trim();
			return new PostCommand(twitter, username, message);
		}
	}

}
