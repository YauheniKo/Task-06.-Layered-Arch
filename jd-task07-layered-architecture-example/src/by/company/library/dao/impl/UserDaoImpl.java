package by.company.library.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import by.company.library.bean.Book;
import by.company.library.bean.User;
import by.company.library.dao.UserDao;
import by.company.library.dao.exception.DAOException;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean registerUser(User user) throws DAOException {
		File file = new File(User.USER_FILE);
		String text = user.getLogin() + ", " + user.getPassword() + ", " + User.AGE_LIM;
		String userLog = user.getLogin();
		String[] userArr;
		String line = null;
		boolean res = true;
		try (FileOutputStream fos = new FileOutputStream(file, true);
				PrintStream printStream = new PrintStream(fos);
				FileInputStream fis = new FileInputStream(file);
				Scanner scanner = new Scanner(fis)) {
			if (scanner.hasNext()) {
				while (scanner.hasNext()) {
					line = scanner.nextLine();
					userArr = line.split(", ");
					if (userLog.equals(userArr[0])) {
						res = false;

					}
				}
				if (res != false) {
					printStream.println(text);
				}
				
			} else
				printStream.println(text);
			

		} catch (IOException ex) {
			
				throw new DAOException(ex);
		}

		return res;

	}

	@Override
	public User logination(String login, String password) throws DAOException {
		File file = new File(User.USER_FILE);

		String[] userArr = null;
		String line = null;
		boolean b = false;
		boolean ageLim;
		try (FileOutputStream fos = new FileOutputStream(file, true);
				PrintStream printStream = new PrintStream(fos);
				FileInputStream fis = new FileInputStream(file);
				Scanner scanner = new Scanner(fis)) {
			if (scanner.hasNext()) {
				while (scanner.hasNext()) {
					line = scanner.nextLine();
					userArr = line.split(", ");
					boolean boolean2 = Boolean.parseBoolean(userArr[2]);
					if (login.equals(userArr[0]) & password.equals(userArr[1])) {
						b = true;
						break;

					}

				}
			}

			ageLim = Boolean.parseBoolean(userArr[2]);

		} catch (IOException ex) {

			throw new DAOException("Пользователь не найден");
		}

		if (b == true) {
			return new User(userArr[0] + ", ", userArr[1], ageLim);
		} else {
			throw new DAOException("Пользователь не найден");
		}

	}
}
