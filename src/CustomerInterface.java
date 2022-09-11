import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Date;

public class CustomerInterface implements java.io.Serializable {

    public static void main(String[] args) throws FileNotFoundException {
    	 int size = 8; // for customer AND employee.
      	 HashTable<Customer> login = new HashTable<Customer>(size); // holds both employee and customer
    	 BST<House> houseData = new BST<House>(); // primary key
    	 BST<House> houseData2 = new BST<House>();
    	 PrimaryComparator pC = new PrimaryComparator();
    	 SecondaryComparator sC = new SecondaryComparator();
    	 PriorityComparator PrC = new PriorityComparator();
    	 ArrayList<Order> tempList = new ArrayList<Order>();
    	 
    	 Heap<Order> history = new Heap<Order>(tempList,PrC);
    	 Heap<Order> shipped = new Heap<Order>(tempList,PrC);
    	 
    	 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    	    Date date = new Date(); 
    	    
    	String first, last, user, password, address, city, state; // for hashTable
    	int zip;
    	String street, owner; // for BST house
		int bedroom;
    	int year;
    	double price;
    	
     
    	
    	File file1 = new File("D:\\Users\\peter\\eclipse-workspace\\real_estate\\src\\customer.txt");
    	File file2 = new File("D:\\Users\\peter\\eclipse-workspace\\real_estate\\src\\house_list.txt");

    	//file3 = new File("heapOrder.txt")
    	/* File file3 = new File("heapOrder.txt")
    	 * if(file3 is not empty)
    	 * while(input.nextLine())
    	 * deserialization
    	 * 
    	 * Order tempo = new Order(deserlization) // should be methods for me to deserialize
    	 * 
    	 * history.insert(tempo)
    	 * else { 
    	 * }
    	 */
    	Scanner input = new Scanner(file1);
    	while(input.hasNextLine()) {
    		
    		first = input.nextLine();
    		last = input.nextLine();
    		user = input.nextLine();
    		password = input.nextLine();
    		address = input.nextLine();
    		city = input.nextLine();
    		state = input.nextLine();
    		zip = Integer.parseInt(input.nextLine());
    		login.insert(new Customer(first,last,user,password,address,city,state,zip)); 
    	}
    	
    	
    	
    	
        //Get House text data
        //Create and populate BST with house data
        //Populate houseData
    	 input =  new Scanner(file2);
    	 while(input.hasNextLine()) {
     		street = input.nextLine();
     		owner = input.nextLine();
     		zip = Integer.parseInt(input.nextLine());
     		year= Integer.parseInt(input.nextLine());
     		bedroom = Integer.parseInt(input.nextLine());
     		price = Double.parseDouble(input.nextLine());
     		houseData.insert(new House(street,owner,zip,year,bedroom,price),pC);
     		houseData2.insert(new House(street,owner,zip,year,bedroom,price),sC);
     	}

    	 
    	 // Customer customer = new Customer();
       //   Customer searchResult = login.get(customer);
    	//  List<Order> list = searchResult.getOrders();
        //Get Order data
        //Create and populate Heap with order data

        //Create menus for Customer and Employee
    	 input = new Scanner(System.in);
    	 boolean employeeKey = false;
    	 char inPut;
         int choice =0;
         int x = 0;
         String result;
         Customer current = null;
      System.out.println("Welcome to the Housing Store!\n");   
        System.out.print("1. Login as a Customer\n2. Login as a Employee\nEnter Choice: ");
        choice = input.nextInt();
        if(choice == 1) {
            System.out.print("\nEnter Login Credentials:");
            user = input.next();
            System.out.print("\nEnter password:");
            password = input.next(); 
            Customer checking = new Customer(user, password);
            Customer searchResult = login.get(checking);
            current = searchResult;
            if(searchResult != null) {
            	System.out.println("Welcome back, " + searchResult.getFirstName() + " " + searchResult.getLastName() + "!\n\n");
            	
            	
            	// search through entire heap (history *all customers unshipped orders*) , compare other customers with searchResult.
            	for(int i = 0; i < history.getHeapSize(); i++) {
            		Order temp = history.getHeap().get(i);
                if(searchResult.equals(temp) == true) {
                		searchResult.getOrders().addFirst(temp);
            	}
     
            	}
            	
            	
            	
            }
            else { 
            	System.out.print("\nNo account found, would you like to create an account?\n"
            			+ "1. Create new account\n2. Log in as a guest\nEnter Choice: ");
            	choice = input.nextInt();
            	if(choice == 1) {
            	System.out.print("Enter your first name: ");
            	input.nextLine();
            	first = input.nextLine();
            	System.out.print("Enter your last name: ");
            	last = input.nextLine();
            	System.out.print("Enter a username: ");
            	user = input.nextLine();
            	System.out.print("enter a password: ");
            	password = input.nextLine();
            	System.out.print("Enter your street address: ");
            	address= input.nextLine();
            	System.out.print("Enter your city: ");
            	city = input.nextLine();
            	System.out.print("Enter your State in initials: ");
            	state = input.nextLine();
            	System.out.print("Enter your zip code: ");
            	zip= Integer.parseInt(input.nextLine());
            	size++;
                current = new Customer(first,last,user,password,address,city,state,zip);
        		login.insert(current);     		
        		System.out.println("\nAccount successfully created!");
            	}
            	else {
            		current = new Customer(user,password);
            	}
            }      
        } 
        // END OF CUSTOMER LOGIN 
        else if(choice == 2) { // employee login
            System.out.print("Enter Login Credentials:");
            user = input.next();
            System.out.print("Enter password:");
            password = input.next(); 
            Customer checking = new Customer(user, password);
            Customer searchResult = login.get(checking);
            if(searchResult != null) {
            	current = searchResult;
            	employeeKey = true;
            	System.out.println("Welcome back, " + searchResult.getFirstName() + " " + searchResult.getLastName() + "!\n\n");
            }
            else {
            	System.out.print("Not existing employee, sorry!\n");
            }
        	
        }
        else {
        	System.out.println("Invalid input, please try again!");
        }

 
        
        
        
        
       if(employeeKey == false) {
    	   while(true) {
    		   System.out.println("Please select from the following options:\n\nA. Search for a product\nB. List Database of Products"
   					+ "\nC. Shipping methods\nD. View Purchases\nX. Exit\n");
   			System.out.print("Enter your choice: ");
   			inPut = input.next().charAt(0);
			System.out.print("\n");

			if (inPut == 'A' || inPut == 'B' || inPut == 'C' || inPut == 'D') {
				switch (inPut) {
				case 'A':
					System.out.print("1. Find and display one record using the primary key\n2. Find "
							+ "display one record using the secondary key\nEnter your choice: ");
					choice = input.nextInt();
					if(choice ==1) {
						System.out.print("Enter the primary key (Street Address): ");
						input.nextLine();
						result = input.nextLine();
						House L = new House(result);
						System.out.print("\n");
						System.out.println(houseData.search(L, pC));
					}
					else {
						System.out.print("Enter the secondary key (Owner name): ");
						input.nextLine();
						result = input.nextLine();
						House L1 = new House(result,x);
						System.out.print("\n");
						System.out.println(houseData2.search(L1, sC));
					}
					break;
					
				case 'B':
					System.out.println("1.List data sorted by primary key\n2.List data sorted by secondary key\nEnter your choice:");
					choice = input.nextInt();
					if(choice==1) {
						houseData.inOrderPrint(); // primary
					}
					else {
						houseData2.inOrderPrint();
					}
					break;
					
					
				case 'C': // place order
					System.out.print("Enter the House address you wish to purchase: ");
					input.nextLine();
					result = input.nextLine();
					House L = new House(result);
					System.out.print("\n");
					House purchase = houseData.search(L, pC);
					
					System.out.print("1. Overnight Shipping\n2. Rush Shipping\n3. Standard Shipping\nEnter your choice:");
					choice = input.nextInt();				
					if(choice == 1) // overnight
					{
						Order overnight = new Order(current,formatter.format(date), purchase,3,3);
						history.insert(overnight);
					} 
					else if(choice == 2)
					{
						Order rush = new Order(current,formatter.format(date), purchase,2,2);
						history.insert(rush);
						
					}else if(choice == 3)
					{
						Order standard = new Order(current,formatter.format(date), purchase,1,1);
						history.insert(standard);
					}
					else
					{
						System.out.println("Invalid Choice!");
					}
				break;
				
				case 'D': // view Purchases
					System.out.print("1.View shipped orders\n2.View unshipped Orders\nEnter your choice:");
					choice = input.nextInt();
					if(choice ==1) {
					System.out.println(shipped);
					}
					else {
						System.out.println(history);
					}
				
				
				
					
				}
			}
			else if(inPut == 'X') {
				System.out.println("Goodbye!");

				System.exit(0);

			} else System.out.print("Invalid menu option. Please enter A-D or X to exit.\n\n");
    	   }	   
    	   
       }
       else if(employeeKey == true) {
    	   while(true) {
    		   System.out.println("Please select from the following options:\n\nA. Search for customer by name"
    		   		+ "\nB. Display customer information"
   					+ "\nC. View Orders by Priority\nD. Ship an Order\nE. List Database Products\nF. Add a new product"
   					+ "\nG. Remove a product\nX. Exit\n");
   			System.out.print("Enter your choice: ");
   			inPut = input.next().charAt(0);
			System.out.print("\n");

			if (inPut == 'A' || inPut == 'B' || inPut == 'C' || inPut == 'D' || inPut == 'E' || inPut == 'F' || inPut == 'G') {
				switch (inPut) {
				
				case 'A': // view by name search		
					break;
					
					
				case 'B':	// display unsorted customer information
					System.out.println(login);
					break;
					
				case 'C': // view by priority
					System.out.println(history);
					break;
					
				case 'D': // remove from heap
					history.remove(1);
					break;
					
				case 'E': // database of Products
					System.out.print("1.List data sorted by primary key\n2.List data sorted by secondary key\nEnter your choice:");
					choice = input.nextInt();
					if(choice==1) {
						houseData.inOrderPrint(); // primary
					}
					else {
						houseData2.inOrderPrint();
					}
					break;
				case 'F': // add a new Product (BST insert)
					System.out.print("Enter Address of House: ");
					input.nextLine();
					street = input.nextLine();
					System.out.print("Enter owner name of House: ");
		     		owner = input.nextLine();
		     		System.out.print("Enter zip code: ");
		     		zip = Integer.parseInt(input.nextLine());
		     		System.out.print("Enter year of House: ");
		     		year= Integer.parseInt(input.nextLine());
		     		System.out.print("Enter ammount of bedrooms: ");
		     		bedroom = Integer.parseInt(input.nextLine());
		     		System.out.print("Enter price of house: ");
		     		price = Double.parseDouble(input.nextLine());
		     		houseData.insert(new House(street,owner,zip,year,bedroom,price),pC);
		     		houseData2.insert(new House(street,owner,zip,year,bedroom,price),sC);
				}
				}
			else if(inPut == 'X') {
				System.out.println("Goodbye!");
				System.exit(0);
				// write to file here?
			}
			else System.out.print("Invalid menu option. Please enter A-D or X to exit.\n\n");
				
				}
    	   }
        
        
        
       }
        
        
 
    	
    	
    	
    }
          
   
    
    
  
