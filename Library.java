package sourceCode;

public class Library {
	private Book[] books;
	private int index;
	Library() {
		Book[] temp = new Book[50];
		books = temp;
		index = 0;
	}
	Library(Book[] books) {
		this.books = books;
		index = books.length;
	}
	public Book[] getBooks() {
		return books;
	}
	public void setBooks(Book[] books) {
		this.books = books;
	}
	
	public void addBook(Book book) {
		books[index] = book;
		index++;
	}
	
}
