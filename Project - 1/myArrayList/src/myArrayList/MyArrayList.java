package myArrayList;

import java.util.Arrays;

public class MyArrayList {

	private int[] myArray = new int[50];
	private int size;
	private int capacity;
	private int sum;

	public MyArrayList() {
		this.size = 0;
		this.capacity = 50;
		this.sum = 0;
	}

	/* Inserts the newValue into the array if size is less than capacity else the capacity is raised 
	 * by 50% and the size is incremented.
	 */
	public void insertSorted(int newValue) {
		if(size == capacity){
			// Raise the capacity of array
			capacity += (capacity/2);
			int[] newArray = new int[capacity];
			for(int i = 0; i < size(); i++){
				newArray[i] = myArray[i];
			}
			myArray = newArray;
		}
		myArray[size] = newValue;
		this.size++;
		Arrays.sort(myArray,0,size);
	}

	/* Removes all occurrence of a value in the array by copying all but the input element and then
	 * change the reference of the old array to point to new array.
	*/
	public void removeValue(int value) {
	int count = 0;
	int index = 0;
	int[] newArray = new int[capacity];
	for(int i = 0; i < size(); i++){
		if(myArray[i] != value){
			newArray[index++] = myArray[i];
		}
		else{
			count++;
		}
	}
	myArray = newArray;
	this.size -= count;		
	}

	/* Returns the array which is used in Test file
	*/
	public int[] getMyarray(){
		return this.myArray;
	}
	
	/* Returns the index of first occurrence of the element in the arrayList else
	 * returns -1
	*/
	public int indexOf(int value) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (myArray[i] == value) {
				index = i;
				return index;
			}
		}
		return index;
	}

	/* Returns the size of the arrayList
	*/
	public int size() {
		return this.size;
	}

	/* Returns the capacity of the arrayList
	*/
	public int capacity(){
		return this.capacity;
	}

	/* Returns the sum of the elements of the arrayList
	*/
	public int sum() {
		int total = 0;
		for (int i = 0; i < size; i++) {
			if(total >= Integer.MAX_VALUE - myArray[i]){
				System.out.println("Sum exceeds Integer.MAX_VALUE");
				System.exit(1);
			}
			total += myArray[i];
		}
		this.sum = total;
		return this.sum;
	}

	/* Prints the elements of the arrayList
	*/
	public String toString() {
		if(myArray == null){
			return null;
		}
		System.out.println("Array Values:");
		System.out.print("[ ");
		for (int i = 0; i < size; i++) {
			if(i == size -1){
				System.out.print(this.myArray[i]);
				break;
			}
			System.out.print(this.myArray[i] + ", ");
		}
		System.out.print(" ]");
		System.out.println();
		return null;
	}

}
