import java.text.DecimalFormat;
import java.util.Comparator;

public class House {
	private final String street;
	private final String owner;
	private int zip;
	private int year;
	private int bedroom; // bedrooms
	private double price;
	
	
	public House() {
		street = "street unknown";
		owner = "owner unknown";
		zip = -1;
		year = -1;
		bedroom = -1;
		price = -1;
		
		
	}
	

	
	public House(String street) {
		this.street = street;
		this.owner = "no owner";
		this.zip = -1;
		this.year = -1;
		this.bedroom = -1;
		this.price = -1;
		
	}
	
	public House(String owner, int x) {
		this.street = "no street";
		this.owner = owner;
		this.zip = -1;
		this.year = -1;
		this.bedroom = -1;
		this.price = -1;
	}
	
	
	
	
	
	
	public House(String street, String owner, int zip,int year, int bedroom, double price) {
		this.street = street;
		this.owner = owner;
		this.zip = zip;
		this.year = year;
		this.price = price;
		this.bedroom = bedroom;
	}
	
	
	/** ACCESSORS */
	
	public String getStreet() {
		return street;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public int getZip() {
		return zip;
	}
	
	public int getYear() {
		return year;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getBedroom() {
		return bedroom;
	}
	
	
	
	@Override
	public String toString() {
		DecimalFormat d = new DecimalFormat("###,###.0");
		String result = "Street: " + street + "\nOwner: " + owner + "\nZip Code: " + zip + "\nYear: " + year + "\nBedroom Count: "
		+ bedroom + "\nPrice: $" + d.format(price) + "\n";
		return result;
	}
	
	
	
	// EQUALS //
	@Override public boolean equals(Object o) {
		if (o == this) {
			return true;
		} 
		else if (!(o instanceof House)) {
			return false;
		}
		else {
			House otherHouse = (House) o;
			return otherHouse.street.equals(street) && otherHouse.owner.equals(owner);
		}

	}
	
	@Override public int hashCode() {
		String key = street + owner;
		int sum = 0;
		for (int i = 0; i < key.length(); i++) {
			sum += (int) key.charAt(i);
		}
		return sum;
	}
	
	
}


	
class PrimaryComparator implements Comparator<House> {

	@Override
	public int compare(House account1, House account2) {
		String name1 = account1.getStreet();
		String name2 = account2.getStreet();
		if (name1.compareTo(name2) <= -1) {
			return -1;
		} else if (name1.compareTo(name2) >= 1) {
			return 1;
		} else {
			return 0;
		}
	}
} // end class NameComparator

class SecondaryComparator implements Comparator<House> {

	@Override
	public int compare(House account1, House account2) {
		String name1 = account1.getOwner();
		String name2 = account2.getOwner();
		if (name1.compareTo(name2) <= -1) {
			return -1;
		} else if (name1.compareTo(name2) >= 1) {
			return 1;
		} else {
			return 0;
		}
	}
	}
	
	
