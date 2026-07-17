package dto;

public class book {
	private int book_id;
	private String title;
	private String author;
	private int availablecopies;
	public book(int book_id, String title, String author, int availablecopies) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.availablecopies = availablecopies;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
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
	public int getAvailablecopies() {
		return availablecopies;
	}
	public void setAvailablecopies(int availablecopies) {
		this.availablecopies = availablecopies;
	}
	@Override
	public String toString() {
		return "book [book_id=" + book_id + ", title=" + title + ", author=" + author + ", availablecopies="
				+ availablecopies + "]";
	}
	

}
