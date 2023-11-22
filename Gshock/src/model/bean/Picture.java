package model.bean;

public class Picture {
	private int id;
	private String picture;
	private int wid;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	
	public Picture() {
		super();
	}
	public Picture(int id, String picture, int wid) {
		super();
		this.id = id;
		this.picture = picture;
		this.wid = wid;
	}
		
}
