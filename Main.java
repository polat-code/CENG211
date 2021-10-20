package sourceCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Library library01 = FileIO.getLibraryData("src/data/L1_Books.csv");
		System.out.println(library01.getBooks()[0].getTitle());
		Library library02 = FileIO.getLibraryData("src/data/L2_Books.csv");
		Library library03 = FileIO.getLibraryData("src/data/L3_Books.csv");
		
		Member[] members = FileIO.getMemberData("src/data/Members.csv");
		
		LibraryManagement libManagement = new LibraryManagement();
		// there are some null datas in Issue Arrays.
		FileIO.getIssueData("src/data/L1_Issues.csv", libManagement,0);
		FileIO.getIssueData("src/data/L2_Issues.csv", libManagement,1);
		FileIO.getIssueData("src/data/L3_Issues.csv", libManagement,2);
		System.out.println(libManagement.getIssues()[0][0]);   
		
		
		
		
		
		//System.out.println(members[0].getName());
		
	}

}
