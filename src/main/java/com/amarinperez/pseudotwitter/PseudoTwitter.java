package com.amarinperez.pseudotwitter;

import java.util.HashMap;

public class PseudoTwitter {
	
	private HashMap<String, Timeline> messages = new HashMap<String, Timeline>();
	
	public void post(String username, String message) {
		Timeline timeline = messages.get(username);
		if(timeline == null)
		{
			timeline = new Timeline();
			messages.put(username, timeline);
		}
		
		timeline.add(message);
	}
	
	public String getTimeline(String username) {
		return messages.get(username).toString();
	}

}
