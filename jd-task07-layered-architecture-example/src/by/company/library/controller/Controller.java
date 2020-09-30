package by.company.library.controller;

import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;

public class Controller {
	private final CommandProvider provider = new CommandProvider();
	
	
	public String doAction(String request) {
		String commandName;
		String[] mas = request.split(", ");
		commandName = mas[0];
		

		String response;
		try {
			Command command = provider.getCommand(commandName);
			response = command.execute(request);
			
			
			
		} catch (CommandException | NullPointerException e) {
			response = "Ошибка";
		}
		return response;

	}
}
