package model;

public class Account {
	private int id;
	private String type;
	private int amount;
	private String date;
	
	public Account(int id, String type, int amount, String date) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", type=" + type + ", amount=" + amount + ", date=" + date + "]";
	}

}
