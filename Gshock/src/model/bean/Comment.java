package model.bean;

public class Comment {
	private int id;
	private String name;
	private String comment;
	private int userid;
	private int reviewid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getReviewid() {
		return reviewid;
	}
	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
	}
	public Comment(int id, String name, String comment, int userid, int reviewid) {
		super();
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.userid = userid;
		this.reviewid = reviewid;
	}

	
	
}
