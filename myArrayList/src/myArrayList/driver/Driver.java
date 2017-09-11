package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.Results;
import myArrayList.util.FileProcessor;
import java.io.File;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) {
		// System.out.println("le is "+args.length);
		System.out.println("Hello World");
		if(args[0].equals("${arg0}")){
			args[0] = "input.txt";
		}
		if(args[1].equals("${arg1}")){
			args[1] = "output.txt";
		}
		
		String inputFile = args[0];
		String outputFile = args[1];
		// System.out.println("arg is " + args[0] + " arg1 is "+ args[1]);
		MyArrayList list = new MyArrayList();

		try{
			FileProcessor file = new FileProcessor(inputFile);
			String line;

			while((line = file.readLine()) != null){
				try{
					int val = Integer.parseInt(line);
					list.insertSorted(val);
				}catch(Exception e){
					System.err.println("Not a number");
					continue;
				}
			}
		}catch (Exception e) {
				e.printStackTrace();
		}
		// finally{
		// 	if(file != null){
		// 		file.close();
		// 	}
		// }
		System.out.println("sum is "+ list.sum());

		try{
			// File file = new File(outputFile);
			// BufferedWriter br = new BufferedWriter(new FileWriter(outputFile));
			// PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
			// list.sum()
			// String disp = "The sum of all the values in the array list is: " +  list.sum();
			// br.write("disp hellooo");
			writer.println("hello");
			System.out.println("File written Successfully");
		}catch(Exception e){
			 e.printStackTrace();
		}
		// finally {
  //         if ( br != null ) {
  //           br.close();
  //         }
  //        } 


		list.toString();
		// list.removeValue(1);
		// list.toString();
		// list.removeValue(12);
		// list.toString();
		// list.removeValue(0);
		// list.toString();
		// System.out.println(list.indexOf(1));
		// System.out.println(list.sum());
		// MyArrayList lis = new MyArrayList();
		// Results results = new Results();
		// MyArrayListTest listTest = new MyArrayListTest();
		// listTest.testMe(lis,results);
		// // System.out.println("Results store is:");
		// // System.out.println(results.getresultStore());
		// ArrayList<String> resultList = results.getresultStore();
		// for(int i = 0; i < resultList.size(); i++){
		// 	results.writeToStdout(resultList.get(i));
		// }
		// lis.toString();
	}
}
