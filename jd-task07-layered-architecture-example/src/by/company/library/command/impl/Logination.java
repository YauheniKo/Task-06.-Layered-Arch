package by.company.library.command.impl;

import by.company.library.bean.User;
import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.UserService;
import by.company.library.service.exception.ServiceException;

public class Logination implements Command{

	@Override
	public String execute(String request) throws CommandException {
		String response=null;
		
		String[] mas = request.split(", ");
		try {
			String login = mas[1];
			String password = mas[2];

			int age=Integer.parseInt(mas[3]);

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			
			UserService userservice = serviceFactory.getUserService();
			
			userservice.logination(login, password);
			
			response="Пользовать с логином - "+userservice.logination(login, password).getLogin()+" в базе зарегистрирован(а)";
			
		} catch (ServiceException e) {
			throw new CommandException(e);
		}

		return response;
	}

}
