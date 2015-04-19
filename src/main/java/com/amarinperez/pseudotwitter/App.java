package com.amarinperez.pseudotwitter;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PseudoTwitter twitter = new PseudoTwitter();
		CommandInterpreter interpreter = new CommandInterpreter(twitter);
		String line;

		line = scanner.nextLine();

		while (line != null) {
			Command command = interpreter.interpret(line);

			System.out.println(command.execute());

			line = scanner.nextLine();
		}
		
		scanner.close();
	}
}
