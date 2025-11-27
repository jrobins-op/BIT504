package libraryapp;

public class Book {
	private String bookID;
	private String ISBN;
	private String title;
	private String author;
	private String publicationDate;
	private String genre;
	private int ageRating;
	
	public Book(String bookIDIn, String ISBNIn, String titleIn, String authorIn, String publicationDateIn, String genreIn, int ageRatingIn) {
		
		this.bookID = bookIDIn;
		this.ISBN = ISBNIn;
		this.title = titleIn;
		this.author = authorIn;
		this.publicationDate = publicationDateIn;
		this.genre = genreIn;
		this.ageRating = ageRatingIn;
		
		
	}
}
