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
		if(args[0].equals("${arg0}") || args[0].equals("") || args[1].equals("${arg1}") || args[1].equals("")){
			System.err.println("Please specify two arguments.");
			return;
		}
		
		String inputFile = args[0];
		String outputFile = args[1];

		// ArrayList object to add input elements from file and calculate sum
		MyArrayList list = new MyArrayList();
		FileProcessor file = null;
		try{
			File myFile = new File(inputFile);
			if(!myFile.exists()) {
			    System.out.println("Input file does not exist.Please include it");
			    System.exit(1);
			}
			file = new FileProcessor(inputFile);
			String line;

			while((line = file.readLine()) != null){
				try{
					int val = Integer.parseInt(line);
					list.insertSorted(val);
				}catch(Exception e){
					continue;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in reading file");
			System.exit(1);
		}
		finally{
			file.closeFile();
			file = null;
		}

		// ArrayList object that is passed to test methods		
		MyArrayList listTest = new MyArrayList();
		MyArrayListTest testCases = new MyArrayListTest();
		Results results = new Results();
		testCases.testMe(listTest,results);
		ArrayList<String> resultList = results.getresultStore();

		BufferedWriter writer = null;

		try {
		    writer = new BufferedWriter(new FileWriter(outputFile));
		    File myFile = new File(outputFile);
			if(!myFile.exists()) {
			    System.out.println("Output file does not exist.Please include it");
			    System.exit(1);
			}
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
		    System.err.println("Error in writing file");
			System.exit(1);
		} finally {
		    if (writer != null || results != null){
		    	try { 
		    		writer.close(); 
		    		results.closeFile();
		    		results = null;
		    	} catch (IOException ignore) {}
		    }
		}
		
	}
}
