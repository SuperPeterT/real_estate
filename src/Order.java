import java.util.Comparator;

public class Order<T> {
	private Customer customer;
	private String date;
	private House orderContents;
	private int shippingSpeed;
	private int priority;
	
	
	public Order() {
		customer = null;
		date = null; 
		orderContents = null;
		shippingSpeed = 0;
		priority = 0;
	}
	
	
	
	
	public Order(Customer customer, String date, House orderContents, int shippingSpeed, int priority) {
		this.customer = customer;
		this.date = date; 
		this.orderContents = orderContents;
		this.shippingSpeed = shippingSpeed;
		this.priority = priority;
	}
	

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public House getOrderContents() {
	return orderContents;
}

public void setOrderContents(House orderContents) {
	this.orderContents = orderContents;
}

public int getShippingSpeed() {
	return shippingSpeed;
}

public void setShippingSpeed(int shippingSpeed) {
	this.shippingSpeed = shippingSpeed;
}

public int getPriority() {
	return priority;
}

public void setPriority(int priority) {
	// priority = (current date - order date) * shippingSpeed
	this.priority = priority;
	
}

@Override
public String toString() {
	
	String result = "";
	result += "House Description: " + orderContents.toString() + "\n";
	result += "Customer: " + customer.toString() + "\n";
	result += "Date Ordered: " + date +  "\n";
	if(shippingSpeed == 3) {
		result += "Shipping Speed: Overnight\n";
	}
	else if(shippingSpeed == 2) {
		result += "Shipping Speed: Rush\n";
	}
	else {
		result += "Shipping Speed: Standard\n";
	}


	return result;

}


}

class PriorityComparator implements Comparator<Order> {

	@Override
	public int compare(Order account1,Order account2) {
		int totalVal1 = account1.getPriority();
		int totalVal2 = account2.getPriority();

		return Integer.compare(totalVal1, totalVal2);
	}
	
	
	
	
}






