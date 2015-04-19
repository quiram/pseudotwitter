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
			
			Command command = null;
			
			if(!line.contains("->"))
			{
				command = new ReadCommand(twitter, line);
			}
			else
			{
				String[] elements = line.split("->");
				String username = elements[0].trim();
				String message = elements[1].trim();
				command = new PostCommand(twitter, username, message);
			}

			System.out.println(command.execute());

			line = scanner.nextLine();
		}
		
		scanner.close();
	}
}
