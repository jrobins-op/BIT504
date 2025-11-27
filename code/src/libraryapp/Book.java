package libraryapp;
/*
BIT504
Jonathan Robins
5119350
*/

public class Book {
	private String bookID;
	private String isbn;
	private String title;
	private String author;
	private String publicationDate;
	private String genre;
	private int ageRating;
	private Boolean borrowedStatus;
	
	public Book(String bookIDIn, String isbnIn, String titleIn, String authorIn, String publicationDateIn, String genreIn, int ageRatingIn, Boolean borrowedStatusIn) {
		
		this.bookID = bookIDIn;
		this.isbn = isbnIn;
		this.title = titleIn;
		this.author = authorIn;
		this.publicationDate = publicationDateIn;
		this.genre = genreIn;
		this.ageRating = ageRatingIn;
		this.borrowedStatus = borrowedStatusIn;
		
		
	}
	
	public String getBookID() {
		return bookID;
	}
	public String getISBN() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public String getGenre() {
		return genre;
	}
	public int getAgeRating() {
		return ageRating;
	}
	public Boolean getBorrowedStatus() {
		return borrowedStatus;
	}
	
	
	public void setBookID(String bookIDIn) {
		bookID = bookIDIn;
	}
	public void setISBN(String isbnIn) {
		isbn = isbnIn;
	}
	public void setTitle(String titleIn) {
		title = titleIn;
	}
	public void setAuthor(String authorIn) {
		author = authorIn;
	}
	public void setPublicationDate(String publicationDateIn) {
		publicationDate = publicationDateIn;
	}
	public void setGenre(String genreIn) {
		genre = genreIn;
	}
	public void setAgeRating(int ageRatingIn) {
		ageRating = ageRatingIn;
	}
	public void setBorrowedStatus(Boolean borrowedStatusIn) {
		borrowedStatus = borrowedStatusIn;
	}
}
