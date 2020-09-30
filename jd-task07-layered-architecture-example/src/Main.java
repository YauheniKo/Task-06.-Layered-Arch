import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import by.company.library.bean.Book;
import by.company.library.bean.User;
import by.company.library.command.impl.AddNewBook;
import by.company.library.controller.Controller;
import by.company.library.dao.DAOFactory;
import by.company.library.dao.exception.DAOException;
import by.company.library.dao.impl.BookDaoImpl;
import by.company.library.service.ServiceFactory;
import by.company.library.service.exception.ServiceException;

public class Main {

	public static void main(String[] args) throws DAOException, ServiceException {
	
		
		Controller con1=new Controller();
		
		//System.out.println(con1.doAction("ADD_NEW_BOOK, Герберт Шилдт , Java, true"));
				
		//System.out.println(con1.doAction("ADD_NEW_BOOK, Брюс Эккель, Философия Java , true"));
				
		//System.out.println(con1.doAction("ADD_NEW_BOOK, Марк Лутц, Изучаем Python, true"));
		
		//System.out.println(con1.doAction("DELETE_BOOK, Марц, Изучаем Python, true"));
		
		//System.out.println(con1.doAction("REGISTRATION, DarthVader, qwerty123, 18"));
		
		//System.out.println(con1.doAction("REGISTRATION, Pocemon, 123qwerty, 22"));
		
		//System.out.println(con1.doAction("REGISTRATION, 5, 123qwerty, 22"));
		
		//System.out.println(con1.doAction("LOGINATION, Pocemon, 123qwerty, 22"));
	
	}

}
