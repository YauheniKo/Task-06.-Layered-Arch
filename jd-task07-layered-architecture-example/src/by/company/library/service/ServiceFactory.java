package by.company.library.service;

import by.company.library.service.exception.ServiceException;
import by.company.library.service.impl.UpdateLibraryServiceImpl;
import by.company.library.service.impl.UserServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final UpdateLibraryService updateLiraryService = new UpdateLibraryServiceImpl() ;
	private final UserService userService = new UserServiceImpl();
	
	
	public static ServiceFactory getInstance(){
		return instance;
	}
	
	public UpdateLibraryService getUpdateLiraryService(){
		return updateLiraryService;
	}
	
	public UserService getUserService(){
		return userService;
	}

}
