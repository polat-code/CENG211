package sourceCode;

public class Issue {
	private String id;
	private String memberId;
	private String bookId;
	private String issueDate;
	private String returningDate;
	
	Issue() {
		this(null,null,null,null,null);
	}
	
	Issue(String id, String member,String book,String issueDate,String returningDate ) {
		this.id = id;
		this.memberId = member;
		this.bookId = book;
		this.issueDate = issueDate;
		this.returningDate = returningDate;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMember() {
		return memberId;
	}

	public void setMember(String member) {
		this.memberId = member;
	}

	public String getBook() {
		return bookId;
	}

	public void setBook(String book) {
		this.bookId = book;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturningDate() {
		return returningDate;
	}

	public void setReturningDate(String returningDate) {
		this.returningDate = returningDate;
	}
	
}
