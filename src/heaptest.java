import java.util.ArrayList;

public class heaptest {

	public static void main(String [] args) {
		
	PrimaryComparator pC = new PrimaryComparator();
	ArrayList<House> L = new ArrayList<House>();
//	L.add(new House(""));
//	L.add(new House(""));
//	L.add(new House("5"));
//	System.out.println(L);
	Heap<House> L3 = new Heap<House>(L,pC);
	L3.insert(new House("5"));
	L3.insert(new House("10"));
	L3.insert(new House("67"));
	L3.insert(new House("3"));
	System.out.println(L3);
	System.out.println("~~~~~~~~~~");
	L3.remove(1);
	System.out.println(L3);
	
	}
	
}
