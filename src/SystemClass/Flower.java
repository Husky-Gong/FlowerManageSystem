package SystemClass;

public class Flower {
	private String flowerName;
	private double price;
	private int stock;
	public String getFlowerName() {
		return flowerName;
	}
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public Flower(String flowerName, double price, int stock) {
		super();
		this.flowerName = flowerName;
		this.price = price;
		this.stock = stock;
	};
	
	
}
