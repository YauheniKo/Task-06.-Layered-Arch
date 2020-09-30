package by.company.library.dao;

import java.util.List;

import by.company.library.bean.Book;
import by.company.library.dao.exception.DAOException;

public interface BookDao {

	public void addBook(Book book) throws DAOException;

	public boolean delete(Book book) throws DAOException;
	
	public Book searchBook(String author, String title,boolean ageLim) throws DAOException;
}

