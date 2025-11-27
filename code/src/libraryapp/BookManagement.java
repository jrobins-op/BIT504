package libraryapp;
/*
BIT504
Jonathan Robins
5119350
*/
import java.util.Scanner;
import java.util.LinkedList;

public class BookManagement {



	public void menu(LinkedList<Book> bookList) {
		Boolean returnStatus = false;
		while(returnStatus == false) {
			//Main menu that will loop until the user chooses to exit
			int menuSelected = printMenu();
			//Check for menu inputs and perform the required actions
			if(menuSelected == 1) {
				Scanner waitScanner = new Scanner(System.in);
				String resultsTable = printTableHeader() + "\n";
				for (Book books : bookList) {
					resultsTable += books.getBookID() +"\t" + books.getISBN() + "\t" + books.getTitle() + "\t\t" + books.getAuthor() + "\t" + books.getPublicationDate() + "\t\t" + books.getGenre() + "\t\t\t" + books.getAgeRating() + "\n";	
				}
				System.out.println(resultsTable);
				System.out.println("Press Enter to continue");
				waitScanner.nextLine();
			}
			else if (menuSelected == 2) {
				Scanner waitScanner = new Scanner(System.in);
				String resultsTable = printTableHeader() + "\n";
				for (Book books : bookList) {
					if (books.getBorrowedStatus() == true) {
						resultsTable += books.getBookID() +"\t" + books.getISBN() + "\t" + books.getTitle() + "\t\t" + books.getAuthor() + "\t" + books.getPublicationDate() + "\t\t" + books.getGenre() + "\t\t\t" + books.getAgeRating() + "\n";	
					}
				}
				System.out.println(resultsTable);
				System.out.println("Press Enter to continue");
				waitScanner.nextLine();
				
			}
			else if (menuSelected == 3) {
				Scanner waitScanner = new Scanner(System.in);
				String resultsTable = printTableHeader() + "\n";
				for (Book books : bookList) {
					if (books.getBorrowedStatus() == false) {
						resultsTable += books.getBookID() +"\t" + books.getISBN() + "\t" + books.getTitle() + "\t\t" + books.getAuthor() + "\t" + books.getPublicationDate() + "\t\t" + books.getGenre() + "\t\t\t" + books.getAgeRating() + "\n";	
					}
				}
				System.out.println(resultsTable);
				System.out.println("Press Enter to continue");
				waitScanner.nextLine();
			}
			else if (menuSelected == 4) {
				Scanner waitScanner = new Scanner(System.in);
				Scanner bookAddScanner = new Scanner(System.in);
				int newISBN = 0;
				Boolean validISBN = false;
				String finalISBN = "";
				//Loop while ISBN is not 10 digits long
				do { 
					//Try statement to validate input of ISBN is an int and the correct length, if not will print error and wait for next input
					System.out.println("Enter Book ISBN in format xxxxxxxxxx");
					try {
						newISBN = bookAddScanner.nextInt();
						if (Integer.toString(newISBN).length() < 10 || Integer.toString(newISBN).length() > 10) {
							System.out.println("Error invalid ISBN length, should be 10 numbers long");
							bookAddScanner.next();
						}
						finalISBN = "978-" + Integer.toString(newISBN).charAt(0) + "-" + Integer.toString(newISBN).charAt(1) + Integer.toString(newISBN).charAt(2) + Integer.toString(newISBN).charAt(3) + "-" + Integer.toString(newISBN).charAt(4) + Integer.toString(newISBN).charAt(5) + Integer.toString(newISBN).charAt(6) + Integer.toString(newISBN).charAt(7) + Integer.toString(newISBN).charAt(8) + "-" + Integer.toString(newISBN).charAt(9);
						for (Book books : bookList) { // Check ISBN is unique
							if (books.getISBN().equals(finalISBN)) {
								System.out.println("Error invalid ISBN, ISBN already in Book list and must be unique");
								bookAddScanner.next();
							}else {
								validISBN = true;
							}
						}

					} catch (final Exception e) {
				        System.out.println("Pleaes ISBN as 10 digit number");
				        //Sleep for 2 seconds to allow the user to read the error before continuing
				        try {
				        	  Thread.sleep(2000);
				        	} catch (InterruptedException error) {
				        	  Thread.currentThread().interrupt();
				        	}
						bookAddScanner.next();
					}

				}while (validISBN == false);
				
				String newTitle = "";
				do {
					System.out.println("Enter Book Title:");
					newTitle = bookAddScanner.nextLine();
				}while(newTitle == "");
				String newAuthor = "";
				do {
					System.out.println("Enter Book Author:");
					newAuthor = bookAddScanner.nextLine();
				}while(newAuthor == "");
				String newPublicationDate = "";
				do {
					System.out.println("Enter Book Publication Date (yyyy-mm-dd):");
					newPublicationDate = bookAddScanner.next();
				}while(newPublicationDate == "");
				String newGenre  = "";
				do {
					System.out.println("Enter Book Genre:");
					newGenre = bookAddScanner.nextLine();
				}while(newGenre == "");
				int newAgeRating = -1;
				System.out.println("Enter Book Age Rating");
				do {
					try {
						newAgeRating = bookAddScanner.nextInt();
					} catch (final Exception e) {
				        System.out.println("Pleaes enter a number for Age Rating");
				        //Sleep for 2 seconds to allow the user to read the error before continuing
				        try {
				        	  Thread.sleep(2000);
				        	} catch (InterruptedException error) {
				        	  Thread.currentThread().interrupt();
				        	}
				        bookAddScanner.next();
					}
				}while (newAgeRating < 0 || newAgeRating > 130);
					bookList.add(new Book(Integer.toString(bookList.size()+1),finalISBN,newTitle,newAuthor,newPublicationDate,newGenre,newAgeRating,false));
					MainApp.updateBookList(bookList);
					System.out.println("Book added Successfully, press enter to continue");
					waitScanner.nextLine();
				
			}
			else if(menuSelected == 5) {
				returnStatus = true;
				break;
			}else {
			System.out.println(menuSelected);
			}
		}
	}
	private static int printMenu() {
		//Method to print the menu
		Scanner scanner = new Scanner(System.in);
		int menuOption = 0;
		do {
			clearConsole();
			System.out.println("===== Book Management Menu =====");
			System.out.println("Please Select from one of the options below:");
			System.out.println("1. Display All Books");
			System.out.println("2. Display Borrowed Books");
			System.out.println("3. Display Unborrowed Books");
			System.out.println("4. Add Book");
			System.out.println("5. Return");
			System.out.println("Enter Menu Option 1-5:");
			//Try statement to validate input of menu is an int, if not will print error and wait for next input
			try {
				menuOption = scanner.nextInt();
			} catch (final Exception e) {
		        System.out.println("Pleaes enter a valid option");
		        //Sleep for 2 seconds to allow the user to read the error before continuing
		        try {
		        	  Thread.sleep(2000);
		        	} catch (InterruptedException error) {
		        	  Thread.currentThread().interrupt();
		        	}
				scanner.next();
			}
		}while(menuOption <  1 || menuOption > 5 );
		return menuOption;
	}
	public static void clearConsole() {
		//Will clear the console to keep the screen clean
	    try {
	        final String os = System.getProperty("os.name");
	        if (os.contains("Windows")) {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        } else { // Linux/macOS
	            new ProcessBuilder("clear").inheritIO().start().waitFor();
	        }
	    } catch (final Exception e) {
	        // Handle exceptions
	    	
	        System.err.println("Error clearing console: " + e.getMessage());
	    }
	}
	public String printTableHeader() {
		// Prints the table header used for table output
		return "ID\tISBN\t\t\tTitle\t\t\t\tAuthor\t\tPublication Date\tGenre\t\t\tAge Rating\n-----------------------------------------------------------------------------------------------------------------------------------------";

	}
}
