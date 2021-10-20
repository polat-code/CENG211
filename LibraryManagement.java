package sourceCode;

public class LibraryManagement {
	private Issue[][] issues ;
	LibraryManagement() {
		this(new Issue[3][30]);
	}
	
	
	LibraryManagement(Issue[][] issues) {
		this.issues = issues;
		
	}
	public Issue[][] getIssues() {
		return issues;
	}
	public void setIssues(Issue[][] issues) {
		this.issues = issues;
	}
	
	
}
