package sourceCode;

public class Book {
	private String id;
	private String title;
	private String author;
	private String publisher;
	private String edition;
	private String genre;
	private Integer quantity;
	
	Book() {
		this(null,null,null,null,null,null,null);
	}
	Book(String id,String title, String author, String publisher, String edition,
			String genre,Integer quantity) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.edition = edition;
		this.genre = genre;
		this.quantity = quantity;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		return this.title;
	}
	
}
