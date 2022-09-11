
/**
 * @author
 * Final Project
 */

import java.util.Comparator;
import java.util.ArrayList;
public class Heap<T> {

    private int heapSize;
    private ArrayList<T> heap;
    private Comparator<T> comparator;


    /**Constructors/

    /**
     * Constructor for the Heap class
     * @param data an unordered ArrayList
     * @param comparator determines organization
     * of heap based on priority
     */
    public Heap(ArrayList<T> data, Comparator<T> comparator){
        heap = data;
        this.comparator = comparator;
        heapSize = heap.size();
        buildHeap();
    }
    

    
    
    /**Mutators*/

    /**
     * Converts an ArrayList into a valid
     * max heap. Called by constructor
     * Calls helper method heapify
     */
    public void buildHeap(){
        int n = heapSize;

        for(int i = (int)Math.floor(n/2); i >= 2; i--) {
        	heapify(i);																
        }
    } 
    
    /** 
     * helper method to buildHeap, remove, and sort
     * bubbles an element down to its proper location within the heap
     * @param index an index in the heap
     */
    private void heapify(int index) {
    	int indexMax = index; 
    	int l = get_left(index);
    	int r = get_right(index);
 
    	
    														
    	if(l <= heapSize && comparator.compare(heap.get(l), heap.get(index)) > 0 ) {
    		indexMax = l; 
    	}
    	
    	if(r <= heapSize && comparator.compare(heap.get(r), heap.get(indexMax)) > 0) {
    		indexMax = r; // 0
    	}
    	
    	if(index != indexMax) {
    		T temp = heap.get(index); // 2
    		heap.set(index, heap.get(indexMax)); 
    		heap.set(indexMax, temp);
    		heapify(indexMax);
    		
    	}
    }
    /**
     * Inserts the given data into heap
     * Calls helper method heapIncreaseKey
     * @param key the data to insert
     */
    public void insert(T key){
        heapSize++;
        heap.add(key); 
        heapIncreaseKey(heapSize-1, key); // should be passing in last, index = heapSize
    } 
    
    /**
     * Helper method for insert
     * bubbles an element up to its proper location
     * @param index the current index of the key
     * @param key the data
     */
    private void heapIncreaseKey(int index, T key){
    	int parent = getParent(index); // parent index of passing in index
        if(comparator.compare(key,heap.get(index)) > 0) {
        	heap.set(index, key);
        }
        while(comparator.compare(heap.get(parent), heap.get(index)) < 0){
        	T temp = heap.get(index);
        	heap.set(index, heap.get(parent));
        	heap.set(parent, temp);
        	index = parent;
        	parent = getParent(index);
        	
        	
        }
    }
    
    
    /**
     * removes the element at the specified index
     * Calls helper method heapify
     * @param index the index of the element to remove
     */
    public void remove(int index){
    	heap.remove(index);
    	buildHeap(); 	
    }   
   
    /**Accessors*/

    /**
     * returns the maximum element (highest priority)
     * @return the max value
     */
    public T getMax(){
        return heap.get(1);
    }
   
    /**
     * returns the location (index) of the 
     * parent of the element stored at index
     * @param index the current index
     * @return the index of the parent
     * @precondition 0 < i <= heap_size
     * @throws IndexOutOfBoundsException
     */
    public int getParent(int index) throws IndexOutOfBoundsException {
    	int parent = (int) Math.floor((index-1)/2);
    	
        return parent; // parent index 
    }

    /**
     * returns the location (index) of the 
     * left child of the element stored at index
     * @param index the current index
     * @return the index of the left child
     * @precondition 0 < i <= heap_size
     * @throws IndexOutOfBoundsException
     */
    public int get_left(int index) throws IndexOutOfBoundsException {
    	if( index < 0 || index > heapSize) {
    		throw new IndexOutOfBoundsException("get_left: Index is out of bounds!");
    	}
        return index = (2*index)+1;
        
    }

    /**
     * returns the location (index) of the 
     * right child of the element stored at index
     * @param index the current index
     * @return the index of the right child
     * @precondition 0 < i <= heap_size
     * @throws IndexOutOfBoundsException
     */
    public int get_right(int index) throws IndexOutOfBoundsException {
    	if( index < 0 || index > heapSize) {
    		throw new IndexOutOfBoundsException("get_right: Index is out of bounds!");
    	}
        return index = (2*index) + 2;
    } 
 
    /**
     * returns the heap size (current number of elements)
     * @return the size of the heap
     */
    public int getHeapSize() {
        return heapSize;
    }

    
    
    public ArrayList<T> getHeap(){
    	return heap;
    }
    /**
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public T getElement(int index) throws IndexOutOfBoundsException {
    	if( index <= 0 || index > heapSize) {
    		throw new IndexOutOfBoundsException("getElement: Index is out of bounds!");
    	}
        return heap.get(index); // not sure if this is correct 
    }

    /**Additional Operations*/

    /**
     * Creates a String of all elements in the heap
     */
    @Override public String toString(){
        return  heap + "\n";
    }  

    /**
     * Uses the heap sort algorithm to
     * sort the heap into ascending order
     * Calls helper method heapify
     * @return an ArrayList of sorted elements
     * @postcondition heap remains a valid heap
     */
    public ArrayList<T> sort() {
    	int n = heapSize;
    	for(int i = n; i >= 2; i--) {
    		T temp = heap.get(1);
    		heap.set(1, heap.get(i));
    		heap.set(i, temp);
    		heapSize--;
    		heapify(1);
    	}
    	
        return new ArrayList<T>(); //
    }
    
    
    
   
}
