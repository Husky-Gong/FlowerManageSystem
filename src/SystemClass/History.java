package SystemClass;

import java.sql.Timestamp;

public class History {
	private int id;
	private Timestamp dateTime;
	private String peopleName;
	private String flwName;
	private double flwPrice;
	private double totalPrice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public String getPeopleName() {
		return peopleName;
	}
	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}
	public String getFlwName() {
		return flwName;
	}
	public void setFlwName(String flwName) {
		this.flwName = flwName;
	}
	public double getFlwPrice() {
		return flwPrice;
	}
	public void setFlwPrice(double flwPrice) {
		this.flwPrice = flwPrice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public History(int id, Timestamp dateTime, String peopleName, String flwName, double flwPrice, double totalPrice) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.peopleName = peopleName;
		this.flwName = flwName;
		this.flwPrice = flwPrice;
		this.totalPrice = totalPrice;
	}
	
	
}
