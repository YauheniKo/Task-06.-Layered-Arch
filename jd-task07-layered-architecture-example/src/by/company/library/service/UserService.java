package by.company.library.service;

import by.company.library.bean.User;
import by.company.library.dao.exception.DAOException;
import by.company.library.service.exception.ServiceException;




public interface UserService {
	
	boolean registerUser(User user) throws ServiceException;
	
	User logination(String login, String password) throws ServiceException;
}
