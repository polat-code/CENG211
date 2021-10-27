package sourceCode;

public class Member {
	private String id;
	private String name;
	private String email;
	
	Member() {
		this(null,null,null);
	}
	Member(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean equals(Issue issue) {
		return id.equals(issue.getMemberId());
	}
	
}
