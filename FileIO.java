package sourceCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIO {
	public static Library getLibraryData(String dataPath) {
		Scanner fileIn = null;
		Library library = new Library();
		try {
			fileIn = new Scanner(new FileInputStream(dataPath));
			while(fileIn.hasNext()) {
				String[] bookInfo = fileIn.nextLine().split(",");
				Book book = new Book();
				book.setId(bookInfo[0]);
				book.setTitle(bookInfo[1]);
				book.setAuthor(bookInfo[2]);
				book.setPublisher(bookInfo[3]);
				book.setEdition(bookInfo[4]);
				book.setGenre(bookInfo[5]);
				book.setQuantity(Integer.parseInt(bookInfo[6]));
				library.addBook(book);
			}
			fileIn.close();
			
		}catch(FileNotFoundException e ) {
			System.out.println("File Not Found");
		}
		
		return library;
		
	}
	
	public static Member[] getMemberData(String dataPath) {
		Scanner scanner = null;
		Member[] members = new Member[5];
		try {
			scanner  = new Scanner(new FileInputStream(dataPath));
			// for first line in member.csv.
			scanner.nextLine();
			
			int index = 0;
			while(scanner.hasNext()) {
				String data = scanner.nextLine();
				String[] arrayData = data.split(",");
				Member member = new Member(arrayData[0],arrayData[1],arrayData[2]);
				members[index] = member;
				index++;
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found");
		}		
		
		return members;
	}
	
	public static void getIssueData(String path,LibraryManagement libraryManagement,int indexLibrary) {
		Scanner scanner = null;
				
		try {
			scanner =new Scanner(new FileInputStream(path));
			int index = 0;
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				System.out.println(line);
				String[] data = line.split(",");
				//assert data[0] != null : "data is null";
				Issue issue = new Issue();
				issue.setId(data[0]);
				issue.setMember(data[1]);
				issue.setBook(data[2]);
				issue.setIssueDate(data[3]);
				issue.setReturningDate(data[4]);
				libraryManagement.getIssues()[indexLibrary][index] = issue;
				
			}
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
		
		
	}
}
