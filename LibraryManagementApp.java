package sourceCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LibraryManagementApp {

	public static void main(String[] args) {
		Library library01 = FileIO.getLibraryData("src/data/L1_Books.csv");
		//System.out.println(library01.getBooks()[0].getTitle());
		Library library02 = FileIO.getLibraryData("src/data/L2_Books.csv");
		Library library03 = FileIO.getLibraryData("src/data/L3_Books.csv");
		
		Member[] members = FileIO.getMemberData("src/data/Members.csv");
		
		LibraryManagement libManagement = new LibraryManagement();
		// there are some null datas in Issue Arrays.
		FileIO.getIssueData("src/data/L1_Issues.csv", libManagement,0);
		FileIO.getIssueData("src/data/L2_Issues.csv", libManagement,1);
		FileIO.getIssueData("src/data/L3_Issues.csv", libManagement,2);
		//System.out.println(libManagement.getIssues()[0][0].getBookId()); 
		//System.out.println(libManagement.getIssues()[0][0].getIssueDate().split("-")[0]); 
		
		//For First Question
		LibraryQuery.getMostIssuedBook(library01, library02, library03, libManagement);
		
		//For Second Question
		LibraryQuery.getMostIssuedMember(members, libManagement);
		
		//For Third Question
		LibraryQuery.getMostPenalty(libManagement);
		
		//For Fourth Question
		LibraryQuery.getMostCopies(library01, library02, library03);
		
		//For Fifth Question
		LibraryQuery.getFewestCopies(library01,library02,library03,libManagement);
		
		// For Sixth Question
		LibraryQuery.getLeastBookInComp(members, libManagement.getIssues()[2]);
		
		
		//System.out.println(members[0].getName());
		
		
		
	}

}
