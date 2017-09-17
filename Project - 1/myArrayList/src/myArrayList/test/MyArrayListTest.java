package myArrayList.test;

import myArrayList.MyArrayList;
import myArrayList.util.Results;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class MyArrayListTest{

	public void testMe(MyArrayList myArrayList, Results results){

		myArrayList.insertSorted(4);
		myArrayList.insertSorted(1);
		myArrayList.insertSorted(3);
		myArrayList.insertSorted(1);
		myArrayList.insertSorted(2);

		checkSizeafterInsertion(myArrayList,results);
		checkSortedafterInsertion(myArrayList,results);
		negativeTCforsorting(myArrayList,results);
		checkSizeafterDeletion(myArrayList,results);
		checkSortedafterDeletion(myArrayList,results);
		findIndexofExistingNumber(myArrayList,results);
		findIndexofNonExistingNumber(myArrayList,results);
		checkSumofList(myArrayList,results);
		checkResizeofList(myArrayList,results);		
	}

	/* Test to check the size of ArrayList after insertion
	*/
	public void checkSizeafterInsertion(MyArrayList myArrayList, Results results){		
		if(myArrayList.size() == 5){
			results.storeNewResult("Test to check the size of ArrayList after insertion : " + "PASSED");
		}
		else{
			results.storeNewResult("Test to check the size of ArrayList after insertion : " + "FAILED");
		}
	}

	/* Test to check the if ArrayList is sorted after insertion
	*/
	public void checkSortedafterInsertion(MyArrayList myArrayList, Results results){
		int[] myArray = myArrayList.getMyarray();
		int[] sortedArray = {1,1,2,3,4};
		for(int i = 0; i < sortedArray.length; i++){
			if(sortedArray[i] != myArray[i]){
				results.storeNewResult("Test to check the if ArrayList is sorted after insertion : " + "FAILED");
				return;
			}
		}
		results.storeNewResult("Test to check the if ArrayList is sorted after insertion : " + "PASSED");
	}

	/* Test to check the if ArrayList is sorted(NegativeTC)
	*/
	public void negativeTCforsorting(MyArrayList myArrayList, Results results){
		int[] myArray = myArrayList.getMyarray();
		int[] sortedArray = {1,1,2,4};
		for(int i = 0; i < sortedArray.length; i++){
			if(sortedArray[i] != myArray[i]){
				results.storeNewResult("Test to check the if ArrayList is sorted(NegativeTC) : " + "FAILED" + " - ArrayList doesn't miss element after sorting");
				return;
			}
		}
		results.storeNewResult("Test to check the if ArrayList is sorted : " + "PASSED");
	}

	/* Test to check the size of ArrayList after deletion 
	*/
	public void checkSizeafterDeletion(MyArrayList myArrayList, Results results){
		myArrayList.removeValue(1);
		if(myArrayList.size() != 3){
			results.storeNewResult("Test to check the size of ArrayList after deletion : " + "FAILED");
		}
		else{
			results.storeNewResult("Test to check the size of ArrayList after deletion : " + "PASSED");
		}
	}

	/* Test to check the if ArrayList is sorted after deletion
	*/
	public void checkSortedafterDeletion(MyArrayList myArrayList, Results results){
		int[] myArray = myArrayList.getMyarray();
		int[] sortedArray = {2,3,4};
		for(int i = 0; i < sortedArray.length; i++){
			if(sortedArray[i] != myArray[i]){
				results.storeNewResult("Test to check the if ArrayList is sorted after deletion : " + "FAILED");
				return;
			}
		}
		results.storeNewResult("Test to check the if ArrayList is sorted after deletion : " + "PASSED");
	
	}

	/* Test to find index of existing element
	*/
	public void findIndexofExistingNumber(MyArrayList myArrayList, Results results){
		int index = myArrayList.indexOf(3);
		if(index != 1){
			results.storeNewResult("Test to find index of existing element : " + "FAILED");
			return;
		}
		results.storeNewResult("Test to find index of existing element : " + "PASSED");
	}

	/* Test to find index of existing element
	*/
	public void findIndexofNonExistingNumber(MyArrayList myArrayList, Results results){
		int index = myArrayList.indexOf(6);
		if(index != -1){
			results.storeNewResult("Test to find index of existing element : " + "FAILED");
			return;
		}
		results.storeNewResult("Test to find index of existing element : " + "PASSED");
	}

	/* Test to check the sum of the list elements
	*/
	public void checkSumofList(MyArrayList myArrayList, Results results){
		int sum = myArrayList.sum();
		if(sum == 9){
			results.storeNewResult("Test to check the sum of the list elements : " + "PASSED");
			return;
		}
		results.storeNewResult("Test to check the sum of the list elements : " + "FAILED");
	}

	/* Test to check the resize of the list
	*/
	public void checkResizeofList(MyArrayList myArrayList, Results results){
		
		FileReader fr = null;
		BufferedReader br = null;
		try{
			File myFile = new File("testInput.txt");
			if(!myFile.exists()) {
			    System.out.println("Test input file does not exist.Please include it");
			    System.exit(1);
			}
			fr = new FileReader("testInput.txt");
			br = new BufferedReader(fr);

			String currentLine = null;

			while((currentLine = br.readLine()) != null){
				try{
					int val = Integer.parseInt(currentLine);
					myArrayList.insertSorted(val);
				}catch(Exception e){
					continue;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				fr.close();
				br.close();
			}  catch (IOException ignore) {}
		}
		if(myArrayList.capacity() == 75){
			results.storeNewResult("Test to check the resize of the list : " + "PASSED");
			return;
		}
		results.storeNewResult("Test to check the resize of the list : " + "FAILED");
	}

	/* est to check the sum and size of the list after resizing
	*/
	public void checkSizeSumafterResizing(MyArrayList myArrayList, Results results){
		if(myArrayList.size() == 52 && myArrayList.sum() == 1234){
			results.storeNewResult("Test to check the sum and size of the list after resizing : " + "PASSED");
			return;	
		}
		results.storeNewResult("Test to check the sum and size of the list after resizing : " + "FAILED");
	}

}