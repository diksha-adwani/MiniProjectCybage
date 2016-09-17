package cybagenet.pojos;

public class Book 
{
	long isbn;
	String bookName;
	String category;
	String author;
	String publication;
	String description;
	
	public Book()
	{
		
	}
	
	//Parameterized constructor.

	public Book(long isbn, String bookName, String category, String author, String publication, String description) {
		super();
		this.isbn = isbn;
		this.bookName = bookName;
		this.category = category;
		this.author = author;
		this.publication = publication;
		this.description = description;
	}

	//Accessores and Mutatores 
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
