package model.bean;

public class Oder {
	private int id ;
	private String name;
	private int numberphone;
	private String email;
	private String adress;
	private String codeoder;
	private int  userid;
	private int payment;
	private String text;
	
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
	
	public Oder() {
		super();
	}
	public Oder(int id, String name, int numberphone, String email, String adress, String codeoder, int userid,
			int payment, String text) {
		super();
		this.id = id;
		this.name = name;
		this.numberphone = numberphone;
		this.email = email;
		this.adress = adress;
		this.codeoder = codeoder;
		this.userid = userid;
		this.payment = payment;
		this.text = text;
	}
	
	
}
