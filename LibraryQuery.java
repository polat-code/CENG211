package sourceCode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LibraryQuery {
	
	//For first Question
	
	public static void getMostIssuedBook(Library l1, Library l2, Library l3, 
			LibraryManagement libManagement) {
		//arrays consist of max book and the number of book.
		String[] firstValues = findMostIssuedBookInLibrary(l1,0,libManagement);
		String[] secondValues = findMostIssuedBookInLibrary(l2,1,libManagement);
		String[] thirdValues = findMostIssuedBookInLibrary(l3,2,libManagement);
		
		int max1 = Integer.parseInt(firstValues[1]);
		int max2 = Integer.parseInt(secondValues[1]);
		int max3 = Integer.parseInt(thirdValues[1]);
		
		String result = "";
		if((max1 > max2) && (max1 > max3)) {
			result = firstValues[0];
		}else if ((max2 > max1) && (max2 > max3)) {
			result = secondValues[0];
		}else {
			result = thirdValues[0];
		}
		
		System.out.println("1)" + result);
		
	}
	
	private static String[] findMostIssuedBookInLibrary(Library lib, int libNumber,LibraryManagement libManagement) {
		int max = 0;
		String bookId = "";
		Book maxBook = null;
		// there are some null values in Library
		Book[] books = lib.getBooks();
		//System.out.println(books[0].getTitle());
		
		Issue[] issues = libManagement.getIssues()[libNumber];
		//System.out.println(issues[0].getBookId());
		
		for(int i = 0; i < books.length ; i++) {
			int tempmax = 0;
			if(books[i] != null) {
				String id = books[i].getId();
				
				// search a id in the issue how many times the id occurs
				for(int j = 0; j < issues.length; j++) {
					if(issues[j] != null) {
						String issueId = issues[j].getBookId();
						//System.out.println(issueId);
						if(issueId.equals(id)) {
							tempmax++;
						}
					}
					
				}
			if(tempmax > max) {
				max = tempmax;
				bookId = id;
				maxBook = books[i];
			}
	
			}else {
				continue;
			}
		}
		
		//System.out.println("" +bookId + "  "+ max); 
		//System.out.println(maxBook.toString());
		return new String[]{maxBook.toString(),Integer.toString(max)};
		
	}
	
	
	
	//For second Question
	public static void getMostIssuedMember(Member[] members, LibraryManagement libManagement) {
		int max = 0;
		Member maxMember = null;
		for(int i = 0; i < members.length; i++) {
			
			Member member = members[i];
			if(member == null) {
				continue;
			}
			
			int issueCounter = 0;
			
			//use "for loop" for three library and make for every member.
			for(int j = 0; j < 3; j++) {
				Issue[] issues = libManagement.getIssues()[j];
				for(Issue issue: issues ) {
					if((issue != null) &&(member.equals(issue))) {
						issueCounter++;
					}
				}
			}
			
			if(issueCounter > max) {
				max = issueCounter;
				maxMember = member;
			}
		}
		
		System.out.println("2)" + maxMember.getName());
		//System.out.println(max);
	}

	//For third Question
	
	public static void getMostPenalty(LibraryManagement libManagement) {
		double maxPenalty = 0.0;
		for(int i = 0; i < 3; i++) {
			Issue[] issues = libManagement.getIssues()[i];
			for(Issue issue: issues) {
				String start_date = null;
				String stop_date = null;
				
				if(issue != null) {
					//for issuedDate
					start_date = getDateAsDay(issue.getIssueDate());
					
					//For returningDate
					stop_date = getDateAsDay(issue.getReturningDate());
				} else {
					continue;
				}
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				long differenceInTime = 0;
				long differenceInDay = 0;
				try {
					Date d1 = sdf.parse(start_date);
					Date d2 = sdf.parse(stop_date);
					
					differenceInTime = d2.getTime() - d1.getTime();
					differenceInDay = differenceInTime / (1000 * 60 * 60 * 24);
				}catch(ParseException e) {
					System.out.println(e);
				}
				
				long penaltyDay = differenceInDay - 14;
				double penaltyLira = penaltyDay * 0.5;
				if(penaltyLira > maxPenalty) {
					maxPenalty = penaltyLira;
				}
				
			}
		}
		
		System.out.println("3)" +maxPenalty + " Lira");
	}
	
	private static String getDateAsDay(String date) {
		
		String resultDate = "";
		String extraZeroForDay = "";
		String[] dateArray = date.split("-");
		if(dateArray[0].length() == 1) {
			extraZeroForDay = "0";
		}
		resultDate = extraZeroForDay +  dateArray[0] + "-"+ 
						DayManagement.getMonthAsNumber(dateArray[1]) + 
						"-" + "20" + dateArray[2] + " 01:10:20";
		return resultDate;
	}
	
	
	//For Fourth Question
	public static void getMostCopies(Library... libraries) {
		int max = 0;
		Book maxBook = null;
		for(Library library: libraries) {
			Book[] books = library.getBooks();
			for(Book book: books) {
				if((book != null) && (max < book.getQuantity())) {
					max = book.getQuantity();
					maxBook = book;
				}
			}
		}
		System.out.println("4)" + maxBook.getTitle());
	}

	//For Fifth Question
	public static void getFewestCopies(Library library01,Library library02, Library library03 ,
			LibraryManagement libManagement) {
		int min = library01.getBooks()[0].getQuantity();
		Book minBook = library01.getBooks()[0];
		Book[] books = concatenateAllLibrary(library01,library02,library03);
		for(Book book: books) {
			if((book != null) && (isContainInIssuedBook(book,libManagement))) {
				if(min > book.getQuantity()) {
					min = book.getQuantity();
					minBook = book;
				}
			}
		}
		System.out.println("5)" + minBook.getTitle());
	}
	
	private static boolean isContainInIssuedBook(Book book,LibraryManagement libManagement) {
		for(int i = 0; i < 3; i++) {
			Issue[] issues = libManagement.getIssues()[i];
			for(Issue issue : issues) {
				if((issue != null) && (book.getId().equals(issue.getBookId()))) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static Book[] concatenateAllLibrary(Library... libraries) {
		Book[] books = new Book[100];
		int indexCounter = 0;
		for(Library library : libraries) {
			for(int i = 0; i < library.getBooks().length; i++ ) {
				Book book = library.getBooks()[i];
				if((book != null)) {
					books[indexCounter] = book;
					indexCounter++;
				}
			}
		}
		return books;
	}
	
	
	
	//For Sixth Question
	
	public static void getLeastBookInComp(Member[] members,Issue[] issues) {
		int min = findNumberOfIssue(members[0],issues);
		Member minMember = members[0];
		for(Member member: members) {
			int tempmin = findNumberOfIssue(member, issues);
			if(tempmin < min) {
				min = tempmin;
				minMember = member;
			}
		}
		
		System.out.println("6)" + minMember.getName());
		
	}
	
	private static int findNumberOfIssue(Member member,Issue[] issues) {
		int counter = 0;
		for(Issue issue : issues) {
			if((issue != null) && (issue.getMemberId().equals(member.getId()) )) {
				counter++;
			}
		}
		return counter;
	}
}
