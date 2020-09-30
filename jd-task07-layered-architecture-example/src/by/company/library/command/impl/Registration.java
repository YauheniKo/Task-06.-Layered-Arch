package by.company.library.command.impl;

import by.company.library.bean.Book;
import by.company.library.bean.User;
import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.UpdateLibraryService;
import by.company.library.service.UserService;
import by.company.library.service.exception.ServiceException;
import by.company.library.service.impl.UserServiceImpl;

public class Registration implements Command {

	@Override
	public String execute(String request) throws CommandException {
		String res=null;
				
		String[] mas = request.split(", ");
		try {
			String login = mas[1];
			String password = mas[2];

			int age=Integer.parseInt(mas[3]);

			

			User user = new User(login, password, age);

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			UserService userservice = serviceFactory.getUserService();
			

			if(userservice.registerUser(user)==true) {
				res = "Регистрация произошла упешно";
			}
			else 
				res="Ошибка регистрации(логин занят)";
			
			
		} catch (ServiceException e) {
			throw new CommandException(e);
		}

		return res;
	}

}
