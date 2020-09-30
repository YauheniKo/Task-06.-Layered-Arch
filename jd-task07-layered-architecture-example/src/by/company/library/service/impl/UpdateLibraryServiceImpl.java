package by.company.library.service.impl;

import by.company.library.bean.Book;
import by.company.library.dao.DAOFactory;
import by.company.library.dao.exception.DAOException;
import by.company.library.service.UpdateLibraryService;
import by.company.library.service.exception.ServiceException;

public class UpdateLibraryServiceImpl implements UpdateLibraryService {

	@Override
	public void addNewBook(Book book) throws ServiceException {
		String author = book.getAuthor();
		String title = book.getTitle();
		boolean ageLim = book.isAgeLim();
		DAOFactory daoFactory = null;

		try {
			daoFactory=DAOFactory.getInstance();
			daoFactory.getBookDAO().addBook(new Book(author, title, ageLim));
		} catch (DAOException e) {
			throw new ServiceException("Книга уже существует");
		}
	}

	@Override
	public boolean delleteBook(Book book) throws ServiceException {
		boolean res=false;
		DAOFactory daoFactory = null;

		try {
			daoFactory=DAOFactory.getInstance();
			daoFactory.getBookDAO().delete(book);
			res=true;
		} catch (DAOException e) {
			throw new ServiceException("Книга не найдена");
		}
		return res;

	}

	@Override
	public Book searchBook(String author, String title, boolean ageLim) throws ServiceException {
		DAOFactory daoFactory = null;
		Book book;

		try {
			daoFactory=DAOFactory.getInstance();
			book = daoFactory.getBookDAO().searchBook(author, title, ageLim);
		} catch (DAOException e) {
			throw new ServiceException("Книга не найдена");
		}

		return book;
	}

	

}
