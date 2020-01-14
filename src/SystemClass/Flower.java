package SystemClass;

import SystemUtils.SystemAnnotation;

/*
 * create table if not exists flower(
	 flower_name varchar(20) not null,
	 flower_number int(5) not null,
	 flower_price decimal(5) not null,
	 primary key(flower_name, flower_price)
)engine=innodb;

 */

/*
 * readOnly = false, flowerName not only be read but also be written and modified and inserted
 * setMethod = "setFlowerName". It's the set method corresponding to flowerName value and it will be used in reflection
 * getMethod = "getFlowerName". It's the get method corresponding to flowerName value and it will be used in reflection
 * columnName = "flower_name". It's the column name in table corresponding to flowerName
 */

@SystemAnnotation(tableName="flower")
public class Flower {
	@SystemAnnotation(readOnly = false, 
					  setMethod = "setFlowerName", 
					  getMethod = "getFlowerName", 
					  columnName = "flower_name")
	private String flowerName;
	
	@SystemAnnotation(readOnly = false,
					  setMethod = "setPrice",
					  getMethod = "getPrice",
					  columnName = "flower_price")
	private double price;
	
	@SystemAnnotation(readOnly = false,
					  setMethod = "setStock",
					  getMethod = "getStock",
					  columnName = "flower_number")
	private int stock;
	
	public String getFlowerName() {
		return flowerName;
	}
	
	public void setFlowerName(Object flowerName) {
		this.flowerName = (String) flowerName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(Object price) {
		this.price = (double) price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(Object stock) {
		this.stock = (int) stock;
	}
	
	public Flower() {}
	
	public Flower(String flowerName, double price, int stock) {
		super();
		this.flowerName = flowerName;
		this.price = price;
		this.stock = stock;
	}
	
	/* This constructor will be used in the find entity
	 * because we do not need more information other than its name.	 
	 */
	public Flower(String flowerName) {
		super();
		this.flowerName = flowerName;
		this.price = 0.0;
		this.stock = 0;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flowerName == null) ? 0 : flowerName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + stock;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flower other = (Flower) obj;
		if (flowerName == null) {
			if (other.flowerName != null)
				return false;
		} else if (!flowerName.equals(other.flowerName))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (stock != other.stock)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Flower [flowerName=" + flowerName + ", price=" + price + ", stock=" + stock + "]";
	};
	
	
}
