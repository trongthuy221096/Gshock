package model.bean;

public class Watch {
	private int id;
	private String name;
	private String detailtext;
	private String feature;
	private String parameters;
	private String picture;
	private int sell;
	private int selloff;
	private int catid;
	private int numbervote;
	private float resultvote;
	
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
	public String getDetailtext() {
		return detailtext;
	}
	public void setDetailtext(String detailtext) {
		this.detailtext = detailtext;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getSell() {
		return sell;
	}
	public void setSell(int sell) {
		this.sell = sell;
	}
	public int getSelloff() {
		return selloff;
	}
	public void setSelloff(int selloff) {
		this.selloff = selloff;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public int getNumbervote() {
		return numbervote;
	}
	public void setNumbervote(int numbervote) {
		this.numbervote = numbervote;
	}
	public float getResultvote() {
		return resultvote;
	}
	public void setResultvote(float resultvote) {
		this.resultvote = resultvote;
	}
	
	public Watch() {
		super();
	}
	public Watch(int id, String name, String detailtext, String feature, String parameters, String picture, int sell,
			int selloff, int catid, int numbervote, float resultvote) {
		super();
		this.id = id;
		this.name = name;
		this.detailtext = detailtext;
		this.feature = feature;
		this.parameters = parameters;
		this.picture = picture;
		this.sell = sell;
		this.selloff = selloff;
		this.catid = catid;
		this.numbervote = numbervote;
		this.resultvote = resultvote;
	}
	
	
	
}
