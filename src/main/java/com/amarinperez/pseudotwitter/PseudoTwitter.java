package com.amarinperez.pseudotwitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PseudoTwitter {
	
	private HashMap<String, List<String>> messages = new HashMap<String, List<String>>();
	
	public void post(String username, String message) {
		List<String> timeline = messages.get(username);
		if(timeline == null)
		{
			timeline = new ArrayList<String>();
			messages.put(username, timeline);
		}
		
		timeline.add(message);
	}
	
	public String getTimeline(String username) {
		return String.join(System.lineSeparator(), messages.get(username).toArray(new String[0]));
	}

}
