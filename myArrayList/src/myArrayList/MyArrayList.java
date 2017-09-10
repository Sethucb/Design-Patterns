package myArrayList;

import java.util.Arrays;

public class MyArrayList {

	private int[] myArray = new int[2];
	private int size;
	private int capacity;
	private int sum;

	public MyArrayList() {
		this.size = 0;
		this.capacity = 2;
		this.sum = 0;
	}

	public void insertSorted(int newValue) {
		if(size == capacity){
			//raise capacity of array
			capacity += (capacity/2);
			System.out.println("Same size "+capacity);
			int[] newArray = new int[capacity];
			for(int i = 0; i < size; i++){
				newArray[i] = myArray[i];
			}
			myArray = newArray;
		}
		myArray[size] = newValue;
		this.size++;
		Arrays.sort(myArray,0,size);
	}

	public void removeValue(int value) {
	int count = 0;
	int index = 0;
	int[] newArray = new int[capacity];
	for(int i = 0; i < size; i++){
		if(myArray[i] != value){
			newArray[index++] = myArray[i];
		}
		else{
			count++;
		}
	}
	// System.out.println("count is "+count);
	myArray = newArray;
	this.size -= count;		
	}

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

	public int size() {
		return this.size;
	}

	public int capacity(){
		return this.capacity;
	}

	public int sum() {
		for (int i = 0; i < size; i++) {
			this.sum += myArray[i];
		}
		return this.sum;
	}

	// overriding the toString() method
	public String toString() {
		// if(arr == null){
		// 	return null;
		// }
		// System.out.println("Array Values:");

		// for (int i = 0; i < size; i++) {
		// 	System.out.print(String.valueOf(this.myArray[i]) + " ");
		// }
		// return null;
		System.out.println(Arrays.toString(myArray));
		return null;
	}

	public void disp(){
		System.out.println(Arrays.toString(myArray));
	}
}
