package airportSecurityState.util;

import java.util.ArrayList;
import airportSecurityState.util.FileDisplayInterface;
import java.io.BufferedWriter;
import java.io.FileWriter;
import airportSecurityState.util.StdoutDisplayInterface;
import java.io.IOException;

public class Results implements FileDisplayInterface,StdoutDisplayInterface{

	private ArrayList<String> resultStore = null;
	private BufferedWriter bwriter = null;
	
	public Results(String file){
		MyLogger.writeMessage("Inside Results constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		this.resultStore = new ArrayList<String>();
		try{
			this.bwriter = new BufferedWriter(new FileWriter(file));
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Error in writing file");
			System.exit(1);
		}
	}

	// Adds the student detail as a whole to the list
	public void storeNewResult(String operation){
		MyLogger.writeMessage("Saving " + operation + " to result",MyLogger.DebugLevel.IN_RESULTS);
		this.resultStore.add(operation);
	}

	// Returns the list of students in tree b_number along with course details
	public ArrayList<String> getresultStore(){
		MyLogger.writeMessage("Fetching from result " + resultStore.toString(),MyLogger.DebugLevel.FROM_RESULTS);
		return this.resultStore;
	}

	// Writes a string to output file
	public void writeToFile(String s){
		try{
			bwriter.write(s);
			bwriter.newLine();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	// Writes a string to stdout
	public void writeToStdout(String s){
		System.out.println(s);
	}

	// Closes the writer stream
	public void closeFile(){
		try{
			bwriter.close();	
		}
		catch(IOException ignore){}		
	}

}