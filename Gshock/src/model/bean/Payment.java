package model.bean;

public class Payment {
	private int id;
	private String name;
	private int numbercard;
	private String password;
	private int userid;
	
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
	public int getNumbercard() {
		return numbercard;
	}
	public void setNumbercard(int numbercard) {
		this.numbercard = numbercard;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public Payment() {
		super();
	}
	public Payment(int id, String name, int numbercard, String password, int userid) {
		super();
		this.id = id;
		this.name = name;
		this.numbercard = numbercard;
		this.password = password;
		this.userid = userid;
	}
	
	
}
