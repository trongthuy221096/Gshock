package model.bean;

public class ShopOder {
	private int id ;
	private String fullname;
	private int numberphone;
	private String email;
	private String adress;
	private String codeoder;
	private int userid;
	private int payment;
	private String text;
	
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCodeoder() {
		return codeoder;
	}
	public void setCodeoder(String codeoder) {
		this.codeoder = codeoder;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public ShopOder(int id, String fullname, int numberphone, String email, String adress, String codeoder, int userid,
			int payment, String text) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.numberphone = numberphone;
		this.email = email;
		this.adress = adress;
		this.codeoder = codeoder;
		this.userid = userid;
		this.payment = payment;
		this.text = text;
	}
	public ShopOder() {
		super();
	}
	
}
