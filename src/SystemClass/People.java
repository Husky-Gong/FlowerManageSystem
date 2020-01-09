package SystemClass;

public class People {
	private String userName;
	private double money;
	private boolean isManager;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	
	public People(String userName, double money, boolean isManager) {
		super();
		this.userName = userName;
		this.money = money;
		this.isManager = isManager;
	}
	
}
