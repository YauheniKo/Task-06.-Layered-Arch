package by.company.library.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import by.company.library.bean.Book;
import by.company.library.bean.User;
import by.company.library.dao.BookDao;
import by.company.library.dao.exception.DAOException;

/*
 *
 */
public class BookDaoImpl implements BookDao {

	/*
	 * @Override public void addBook(Book book) throws DAOException { StringBuilder
	 * sb = new StringBuilder(); sb.append(book.getAuthor() +
	 * ", ").append(book.getTitle() + ", ").append(book.isAgeLim()); String b =
	 * book.getAuthor() + book.getTitle(); BufferedWriter writer = null;
	 * BufferedReader reader = null; File myFile = null; String line = null; boolean
	 * isFl = true; try {
	 * 
	 * myFile = new File(Book.BOOK_LIBRARY);
	 * 
	 * writer = new BufferedWriter(new FileWriter(myFile, true)); writer.write(sb +
	 * "\n");
	 * 
	 * } catch (IOException e) { new DAOException("Файл не найден"); } finally {
	 * 
	 * try { if (writer != null) writer.close(); } catch (IOException e) { new
	 * DAOException(e); } }
	 * 
	 * }
	 */

	@Override
	public void addBook(Book book) throws DAOException {
		File file = new File(Book.BOOK_LIBRARY);
		String text = book.getAuthor() + ", " + book.getTitle() + ", " + book.isAgeLim();

		boolean b = true;
		try (FileOutputStream fos = new FileOutputStream(file, true);
				PrintStream printStream = new PrintStream(fos);
				FileInputStream fis = new FileInputStream(file);
				Scanner scanner = new Scanner(fis)) {
			if (scanner.hasNext()) {
				while (scanner.hasNext()) {

					if (scanner.nextLine().equals(text)) {
						b = false;
						break;
					}
				}
				if (b != false) {
					printStream.println(text);
				} else
					throw new DAOException("Книга  внесена ранее");
			} else
				printStream.println(text);

		} catch (IOException ex) {

			throw new DAOException(ex);
		}

	}

	@Override
	public boolean delete(Book book) throws DAOException {
		boolean result = false;
		String line = null;
		String sb = book.getAuthor() + ", " + book.getTitle() + ", " + book.isAgeLim();
		book = new Book();
		BufferedReader reader = null;
		BufferedWriter writer = null;
		File myFile = null;
		File outputFile = null;

		try {
			myFile = new File(Book.BOOK_LIBRARY);
			outputFile = new File("Temp");

			// Записываем в новый файл все данные, кроме удаляемой строки.

			reader = new BufferedReader(new FileReader(myFile));
			writer = new BufferedWriter(new FileWriter(outputFile));

			while ((line = reader.readLine()) != null) {
				if (!line.equals(sb)) {
					writer.write(line);
					writer.newLine();

				}
			}

			result = true;

		} catch (IOException e) {
			System.out.println(new DAOException("Файл не найден"));
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
			// Затем удаляем исходный файл, а получившийся файл переименовываем.
			myFile.delete();
			outputFile.renameTo(myFile);
		}
		return result;

	}

	@Override

	public Book searchBook(String author, String title, boolean ageLim) throws DAOException {

		boolean ban = true;
		File file;
		boolean res = false;
		String[] arr = null;
		Scanner scanner = null;
		try {
			file = new File(Book.BOOK_LIBRARY);
			scanner = new Scanner(file);

			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				arr = line.split(", ");

				if (author.equals(arr[0]) & title.equals(arr[1])) {
					res = true;
					break;
				}

			}
		}

		catch (IOException e) {
			throw new DAOException("Файл не найден");
		} finally {
			scanner.close();
		}
		if (res = true) {
			ban = Boolean.parseBoolean(arr[2]);
			return new Book(arr[0], arr[1], ban);
		} else
			throw new DAOException("Файл не найден");

	}

}
