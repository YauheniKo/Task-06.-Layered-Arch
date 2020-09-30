package by.company.library.service.impl;

import by.company.library.bean.User;
import by.company.library.dao.DAOFactory;
import by.company.library.dao.UserDao;
import by.company.library.dao.exception.DAOException;
import by.company.library.dao.impl.UserDaoImpl;
import by.company.library.service.UserService;
import by.company.library.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	@Override
	public boolean registerUser(User user) throws ServiceException {
		boolean res = false;
		DAOFactory daoFactory = null;

		if (user.getLogin() == null || user.getLogin().isEmpty() || user.getPassword().length() < 6) {
			throw new ServiceException("Некорректный логин или пароль");
			
		}
		try {
			daoFactory = DAOFactory.getInstance();
			res=daoFactory.getUserDAO().registerUser(user);
			
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return res;

	}

	@Override
	public User logination(String login, String password) throws ServiceException {
		User user;
		DAOFactory daoFactory = null;

		try {
			daoFactory = DAOFactory.getInstance();
			user = daoFactory.getUserDAO().logination(login, password);
		} catch (DAOException e) {
			throw new ServiceException("Пользователь не найдена");
		}

		return user;
	}
}
