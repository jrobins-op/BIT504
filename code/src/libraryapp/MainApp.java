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
	public static Boolean exitStatus; // Boolean to check if application should exit
	static LinkedList<Member> memberList = new LinkedList<>(); //Create a linked list to hold member objects
	static LinkedList<Book> bookList = new LinkedList<>(); //Create a linked list to hold book objects
	
	public static void main(String[] args) {
		String membersFile = "members.txt"; //String to hold members file name. Replace the path to point to the location of the file as needed
		String booksFile = "books.txt"; //String to hold books file name. Replace the path to point to the location of the file as needed
		readFile(membersFile);
		readFile(booksFile);
		
		System.out.println(memberList.size());
		System.out.println(bookList.size());
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
					bookList.add(new Book(inputData[0],inputData[1],inputData[2],inputData[3],inputData[4],inputData[5],Integer.parseInt(inputData[6])));
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
}
