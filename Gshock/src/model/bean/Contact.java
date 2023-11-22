package model.bean;

public class Contact {
	private int id ;
	private String name;
	private int numberphone;
	private String email;
	private String detailtext;
	
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
	public int getNumberphone() {
		return numberphone;
	}
	public void setNumberphone(int numberphone) {
		this.numberphone = numberphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDetailtext() {
		return detailtext;
	}
	public void setDetailtext(String detailtext) {
		this.detailtext = detailtext;
	}
	
	public Contact(int id, String name, int numberphone, String email, String detailtext) {
		super();
		this.id = id;
		this.name = name;
		this.numberphone = numberphone;
		this.email = email;
		this.detailtext = detailtext;
	}
	public Contact() {
		super();
	}
	
	
}
