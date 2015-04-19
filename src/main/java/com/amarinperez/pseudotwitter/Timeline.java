package com.amarinperez.pseudotwitter;

import java.util.ArrayList;
import java.util.List;

public class Timeline {

	List<String> messages = new ArrayList<String>();
	
	public void add(String message) {
		messages.add(message);
	}
	
	public String toString()
	{
		return String.join(System.lineSeparator(), messages.toArray(new String[0]));
	}
}
