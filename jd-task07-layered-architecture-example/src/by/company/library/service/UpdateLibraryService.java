package by.company.library.service;

import by.company.library.bean.Book;
import by.company.library.dao.exception.DAOException;
import by.company.library.service.exception.ServiceException;



public interface UpdateLibraryService {
	
	public void addNewBook(Book book) throws ServiceException;
	
	public boolean delleteBook(Book book)throws ServiceException;
	
	Book searchBook(String author, String title, boolean ageLim) throws ServiceException;
	
	
}
