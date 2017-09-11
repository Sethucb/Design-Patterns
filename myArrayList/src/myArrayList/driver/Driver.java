package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.Results;
import myArrayList.util.FileProcessor;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		// System.out.println("0 is "+ args[0] + " 1 is " + args[1]);
		if(args[0].equals("${arg0}") || args[1].equals("${arg1}")){
			System.err.println("Please specify two arguments");
			return;
		}
		
		String inputFile = args[0];
		String outputFile = args[1];

		MyArrayList list = new MyArrayList();
		FileProcessor file = null;
		try{
			File myFile = new File(inputFile);
			if(!myFile.exists()) {
			    System.out.println("Input file does not exist.Please include it");
			    return;
			}
			file = new FileProcessor(inputFile);
			String line;

			while((line = file.readLine()) != null){
				try{
					int val = Integer.parseInt(line);
					list.insertSorted(val);
				}catch(Exception e){
					// System.err.println("Not a number");
					continue;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			file = null;
		}
		// System.out.println("sum is "+ list.sum()+ " sizE is "+list.size());
		
		MyArrayListTest testCases = new MyArrayListTest();
		MyArrayList listTest = new MyArrayList();
		Results results = new Results();
		testCases.testMe(listTest,results);
		ArrayList<String> resultList = results.getresultStore();

		BufferedWriter writer = null;

		try {
		    writer = new BufferedWriter(new FileWriter(outputFile));
		    results.setBuffereredWriter(writer);
		    writer.write("The sum of all the values in the array list is: "+ list.sum());
		    writer.newLine();writer.newLine();
		    writer.write("Test results in Result instance");writer.newLine();
		    writer.newLine();
		    for(int i = 0; i < resultList.size(); i++){
				results.writeToFile(resultList.get(i));
				results.writeToStdout(resultList.get(i));
			}
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    if (writer != null) 
		    	try { 
		    		writer.close(); 
		    	} catch (IOException ignore) {}
		}
		
	}
}
