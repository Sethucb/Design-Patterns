package airportSecurityState.driver;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.airportStates.SecurityFactors;
import airportSecurityState.util.Results;
import airportSecurityState.util.MyLogger;
import airportSecurityState.airportStates.AirportState;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;

public class Driver {

	// Command line checks
	private static boolean argCheck(String[] args){
		if(args[0].equals("${arg0}") || args[0].equals("") || args[1].equals("${arg1}") || args[1].equals("") || args.length != 3){
			return false;
		}
		String str = "01234";
		if(args[2].equals("${arg2}") || args[2].equals("") || args[2].length() != 1 || (!str.contains(args[2]))){
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		if(argCheck(args) == false){
			System.err.println("Please specify correct three arguments.");
			System.exit(1);
		}
		
		String inputFile = args[0];
		String outputFile = args[1];
		
		try{
			int debug = Integer.parseInt(args[2]);
			MyLogger.setDebugValue(debug);
		}catch(NumberFormatException e){
			System.err.println("Error while converting string to int");
			System.exit(1);
		}

		SecurityFactors factors = new SecurityFactors();
		AirportState airportState = new AirportState();		
		Results results = new Results(outputFile);

		FileProcessor file = null;
		try{
			File myinputFile = new File(inputFile);
			if(!myinputFile.exists() || myinputFile.isDirectory()) {
			    System.err.println("Input file does not exist.Please include it");
			    System.exit(1);
			}
			file = new FileProcessor(inputFile);
			// Make low risk the initial state
			airportState.setInitialState();
			String line;

			while((line = file.readLine()) != null){
				try{
					factors.addTraveller(line);
					airportState.tightenOrLoosenSecurity(factors);
					results.storeNewResult(airportState.getOperations());
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
			try{
				file.closeFile();
				file = null;	
			}catch(Exception ignore){}			
		}
		// Writing results to output file
		ArrayList<String> res = new ArrayList<String>();
		res = results.getresultStore();
		for(String str: res){
			results.writeToFile(str);
		}
		results.closeFile();
	}
}
