package myArrayList;

public class MyArrayList {

	private int[] myArray = new int[50];
	private int size;
	private int capcaity;
	private int sum;

	public MyArrayList() {
		this.size = 0;
		this.capcaity = 50;
		this.sum = 0;
	}

	public void insertSorted(int newValue) {
		
//		System.out.println("Size is "+size+" ind is "+myArray[0]);
	}

	public void removeValue(int value) {

	}

	public int indexOf(int value) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (myArray[i] == value) {
				index = i;
			}
		}
		return index;
	}

	public int size() {
		return this.size;
	}

	public int sum() {
		for (int i = 0; i < size; i++) {
			sum += myArray[i];
		}
		return sum;
	}

	// overriding the toString() method
	public String toString() {
		System.out.println("Array Values:\n");

		for (int i = 0; i < size; i++) {
			System.out.print(myArray[i] + " ");
		}

		return null;

	}
}
