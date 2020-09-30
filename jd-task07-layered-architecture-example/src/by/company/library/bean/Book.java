package by.company.library.bean;

public class Book {

	
	private String title;
	private String author;
	private boolean ageLim;
	public static final String BOOK_LIBRARY="Library.txt";
	
	public Book() {
		this.title="no title";
		this.author="no author";

	}
	

	public Book(String author,String title, boolean ageLim) {

		
		this.author = author;
		this.title = title;
		this.ageLim = ageLim;
	}
public Book(String author,String title) {

		
		this.author = author;
		this.title = title;
		
	}

	

public Book(String author) {

	
	this.author = author;
	
	
}


	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isAgeLim() {
		return ageLim;
	}

	public void setAgeLim(boolean ageLim) {
		this.ageLim = ageLim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ageLim ? 1231 : 1237);
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (ageLim != other.ageLim)
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [ author= " + author + ",title=" + title + ", ageLim=" + ageLim + "]";
	}

}
