package sourceCode;

public class LibraryQueryDeneme {
	
	public static void main(String[] args) {
		if("abc" == "bac") 
	}
	
	
	public static void getMostIssuedBook(Library lib, int libNumber,LibraryManagement libManagement) {
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
		System.out.println(maxBook.toString());
	}
}
