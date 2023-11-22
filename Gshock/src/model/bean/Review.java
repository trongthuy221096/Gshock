package model.bean;

public class Review {
	private int id ;
	private String fullname;
	private String email;
	private int vote;
	private String comment;
	private int  wid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}

	
	public Review() {
		super();
	}
	public Review(int id, String fullname, String email, int vote, String comment, int wid) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.vote = vote;
		this.comment = comment;
		this.wid = wid;

	}
	
	
}
