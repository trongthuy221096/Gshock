package model.bean;

public class Book {
	 private Integer id;
	    private String title;
	    private Integer quantity;
	    private Integer price;
	    private Integer totalMoney;
	    
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public Integer getPrice() {
			return price;
		}
		public void setPrice(Integer price) {
			this.price = price;
		}
		public Integer getTotalMoney() {
			return totalMoney;
		}
		public void setTotalMoney(Integer totalMoney) {
			this.totalMoney = totalMoney;
		}
		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Book(Integer id, String title, Integer quantity, Integer price) {
			super();
			this.id = id;
			this.title = title;
			this.quantity = quantity;
			this.price = price;
		}

	
	    
}
