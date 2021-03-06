package by.company.library.command.impl;

import by.company.library.bean.Book;
import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.UpdateLibraryService;
import by.company.library.service.exception.ServiceException;

public class AddNewBook implements Command {

	@Override
	public String execute(String request) throws CommandException {

		String[] mas = request.split(", ");
		try {
			String author = mas[1];
			String title = mas[2];

			boolean ageLim = Boolean.valueOf(mas[3]);

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			UpdateLibraryService bookService = serviceFactory.getUpdateLiraryService();

			Book book = new Book(author, title, ageLim);
			bookService.addNewBook(book);

		} catch (ServiceException e) {
			throw new CommandException(e);
		}

		return "Книга добавлена";
	}
}
