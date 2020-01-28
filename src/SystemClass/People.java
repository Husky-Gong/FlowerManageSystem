package SystemClass;

import SystemUtils.SystemAnnotation;

@SystemAnnotation(tableName="people")
public class People {
	@SystemAnnotation(
			readOnly = false,
			setMethod = "setUserName",
			getMethod = "getUserName",
			columnName = "user_userName"
			)
	private String userName;
	
	@SystemAnnotation(
			readOnly = false,
			setMethod = "setPassWord",
			getMethod = "getPassWord",
			columnName = "user_passWord"
			)
	private String passWord;
	
	@SystemAnnotation(
			readOnly = false,
			setMethod = "setName",
			getMethod = "getName",
			columnName = "user_name"
			)
	private String name;
	
	@SystemAnnotation(
			readOnly = false,
			setMethod = "setMoney",
			getMethod = "getMoney",
			columnName = "user_money"
			)
	private double money;
	
	@SystemAnnotation(
			readOnly = false,
			setMethod = "setManager",
			getMethod = "isManager",
			columnName = "user_level"
			)
	private String isManager;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(Object userName) {
		this.userName = (String) userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(Object passWord) {
		this.passWord = (String) passWord;
	}
	public String getName() {
		return name;
	}
	public void setName(Object name) {
		this.name = (String) name;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(Object money) {
		this.money = (double) money;
	}
	public String isManager() {
		return isManager;
	}
	public void setManager(Object isManager) {
		this.isManager = (String) isManager;
	}
	public People() {}
	
	public People(String userName) {
		super();
		this.userName = userName;
	}
	
	public People(String userName, String passWord, String name, double money) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.name = name;
		this.money = money;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isManager == null) ? 0 : isManager.hashCode());
		long temp;
		temp = Double.doubleToLongBits(money);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		People other = (People) obj;
		if (isManager == null) {
			if (other.isManager != null)
				return false;
		} else if (!isManager.equals(other.isManager))
			return false;
		if (Double.doubleToLongBits(money) != Double.doubleToLongBits(other.money))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "People [userName=" + userName + ", passWord=" + passWord + ", name=" + name + ", money=" + money
				+ ", isManager=" + isManager + "]";
	}
	public People(String userName, String passWord, String name, double money, String isManager) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.name = name;
		this.money = money;
		this.isManager = isManager;
	}

	
}
