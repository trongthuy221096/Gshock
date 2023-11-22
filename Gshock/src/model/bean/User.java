package model.bean;

public class User {
	private int id;
	private String username;
	private String password;
	private String fullname;
	private String email;
	private int numberphone;
	private int role;
	private int payid;
	private int numbercard;
	private String passwordcard;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public int getNumberphone() {
		return numberphone;
	}
	public void setNumberphone(int numberphone) {
		this.numberphone = numberphone;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	public int getPayid() {
		return payid;
	}
	public void setPayid(int payid) {
		this.payid = payid;
	}
	public int getNumbercard() {
		return numbercard;
	}
	public void setNumbercard(int numbercard) {
		this.numbercard = numbercard;
	}
	public String getPasswordcard() {
		return passwordcard;
	}
	public void setPasswordcard(String passwordcard) {
		this.passwordcard = passwordcard;
	}
	public User(int id, String username, String password, String fullname, String email, int numberphone, int role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.numberphone = numberphone;
		this.role = role;
	}
	
	public User(int id, String username, String password, String fullname, String email, int numberphone, int role,
			int payid, int numbercard, String passwordcard) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.numberphone = numberphone;
		this.role = role;
		this.payid = payid;
		this.numbercard = numbercard;
		this.passwordcard = passwordcard;
	}
	public User() {
		super();
	}
	
}
