import java.text.DecimalFormat;

public class Customer extends Person{
	private String address;
	private String city;
	private String state;
	private int zip;
	private List<Order> orders;
	
	
	public Customer(String login, String password) {
		super(login, password);
	}
	
	
	
	
	public Customer(String first, String last, String login, String password, String address, String city,String state,int zip) {
		super(first, last, login, password);
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		
	}

	
	
	
	public String getFullAddress() {
		return this.address + ", " + this.city + ", " + this.state + ", " + this.zip;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getCity() {
		return this.city;
	}
	public String getState() {
		return this.state;
	}
	public int getZip() {
		return this.zip;
	}
	
	public List<Order> getOrders() {
		return this.orders;
		
	}
	
	
	
	//Setter
	public void setAddress(String address)
	{
		this.address = address;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}

	public void setOrdersList(List<Order> orderList) {
    	this.orders = new List<Order>(orderList);
    }

	
	@Override
	public String toString() {
		
		String result = "";
		result += "Name: " + getFirstName() + " " + getLastName() + "\n";
		result += "Address: " + getFullAddress() + "\n";
		result += "Order History: " + getOrders()+ "\n";
	

		return result;

	}
	
	
}