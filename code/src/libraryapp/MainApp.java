package libraryapp;
/*
BIT504
Jonathan Robins
5119350
*/
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class MainApp {
	public static Boolean exitStatus = false; // Boolean to check if application should exit
	static LinkedList<Member> memberList = new LinkedList<>(); //Create a linked list to hold member objects
	static LinkedList<Book> bookList = new LinkedList<>(); //Create a linked list to hold book objects
	
	public static void main(String[] args) {
		String membersFile = "members.txt"; //String to hold members file name. Replace the path to point to the location of the file as needed
		String booksFile = "books.txt"; //String to hold books file name. Replace the path to point to the location of the file as needed
		readFile(membersFile);
		readFile(booksFile);
		
		while(exitStatus == false) {
			//Main menu that will loop until the user chooses to exit
			int menuSelected = printMenu();
			//Check for menu inputs and perform the required actions
			if(menuSelected == 1) {
				BookManagement bookManagement = new BookManagement();
				bookManagement.menu(bookList);
			}
			else if (menuSelected == 2) {
				Scanner studentIdScanner = new Scanner(System.in);
				Scanner waitScanner = new Scanner(System.in);

				System.out.println("Press Enter to continue");
				waitScanner.nextLine();
				
			}
			else if (menuSelected == 3) {
				Scanner waitScanner = new Scanner(System.in);

				System.out.println("Press Enter to continue");
				waitScanner.nextLine();
			}
			else if (menuSelected == 4) {
				Scanner waitScanner = new Scanner(System.in);

				System.out.println("Press Enter to continue");
				waitScanner.nextLine();
			}
			else if(menuSelected == 5) {
				setExitStatus(true);
				break;
			}else {
			System.out.println(menuSelected);
			}
		}

	}
	public static void readFile(String fileName) {
		
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			String inputLine;
			while ((inputLine = reader.readLine()) != null) {
				//Process input lines
				String[] inputData = inputLine.split(","); //Splitting data into array on each , in file

				if (fileName.contains("members.txt")) {
					memberList.add(new Member(inputData[0],inputData[1],inputData[2],Integer.parseInt(inputData[3]))); //Add each member to the linked list
				}else if (fileName.contains("books.txt")) {
					bookList.add(new Book(inputData[0],inputData[1],inputData[2],inputData[3],inputData[4],inputData[5],Integer.parseInt(inputData[6]),false));
				}else {
					System.err.println("Unknown input file type. Application will exit");
					setExitStatus(true);
				}
			

			}
			
		} catch (IOException e) { //Catch file open errors and print error message
			System.err.println("Error Unable to read input file: " + e.getMessage());
			setExitStatus(true); //If file can not be read, we should exit
		}
		
	}
	public static void setExitStatus(Boolean exitStatusIn) {
		exitStatus = exitStatusIn;
	}
	private static int printMenu() {
		//Method to print the menu
		Scanner scanner = new Scanner(System.in);
		int menuOption = 0;
		do {
			clearConsole();
			System.out.println("Please Select from one of the options below:");
			System.out.println("1. Book Management");
			System.out.println("2. Member Management");
			System.out.println("3. Loan Management");
			System.out.println("4. Search");
			System.out.println("5. Exit");
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
	public static void updateBookList(LinkedList<Book> newBookList) {
		bookList = newBookList;
	}
}
