package com.amarinperez.pseudotwitter;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PseudoTwitter twitter = new PseudoTwitter();
		String line;

		line = scanner.nextLine();

		while (line != null) {
			line = line.trim();
			
			if(!line.contains("->"))
			{
				System.out.println(twitter.getTimeline(line));
			}
			else
			{
				String[] elements = line.split("->");
				String username = elements[0].trim();
				String message = elements[1].trim();
				twitter.post(username, message);
			}
			
			line = scanner.nextLine();
		}
		
		scanner.close();
	}
}
