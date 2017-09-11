package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.Results;
import myArrayList.util.FileProcessor;
import java.util.ArrayList;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) {
		// System.out.println("le is "+args.length);
		System.out.println("Hello World");
		// if(args[0]== null || args[1] == null){
		// 	System.err.println("Please specify two arguments");
		// 	return;
		// }
		// System.out.println("arg is " + args[0] + " arg1 is "+ args[1]);
		String inputFile = args[0];
		String outputFile = args[1];
			
	// 	try{
	// 	FileProcessor file = new FileProcessor(inputFile);

	// 	String line;

	// 	file.readLine();

	// 	// while((line = file.readLine()) != null){
	// 	// 	System.out.println(line);
	// 	// }
	// }catch (Exception e) {
	// 		e.printStackTrace();
	// 	}

		MyArrayList lis = new MyArrayList();
		Results results = new Results();
		MyArrayListTest listTest = new MyArrayListTest();
		listTest.testMe(lis,results);
		// System.out.println("Results store is:");
		// System.out.println(results.getresultStore());
		ArrayList<String> res = results.getresultStore();
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
	}
}
