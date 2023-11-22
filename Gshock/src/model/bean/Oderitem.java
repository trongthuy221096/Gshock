package model.bean;

public class Oderitem {
	private int id ;
	private String name;
	private int qualiti;
	private int sell;
	private int amount;
	private int wid;
	private int userid;
	private int oderid;
	
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
	public int getQualiti() {
		return qualiti;
	}
	public void setQualiti(int qualiti) {
		this.qualiti = qualiti;
	}
	public int getSell() {
		return sell;
	}
	public void setSell(int sell) {
		this.sell = sell;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public int getOderid() {
		return oderid;
	}
	public void setOderid(int oderid) {
		this.oderid = oderid;
	}
	public Oderitem() {
		super();
	}
	public Oderitem(int id, String name, int qualiti, int sell, int amount, int wid, int userid) {
		super();
		this.id = id;
		this.name = name;
		this.qualiti = qualiti;
		this.sell = sell;
		this.amount = amount;
		this.wid = wid;
		this.userid = userid;
	}
	public Oderitem(int id, String name, int qualiti, int sell, int amount, int wid, int userid, int oderid) {
		super();
		this.id = id;
		this.name = name;
		this.qualiti = qualiti;
		this.sell = sell;
		this.amount = amount;
		this.wid = wid;
		this.userid = userid;
		this.oderid = oderid;
	}
	
	
}
