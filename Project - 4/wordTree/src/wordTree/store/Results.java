package wordTree.store;

import java.util.ArrayList;
import wordTree.util.FileDisplayInterface;
import wordTree.util.MyLogger;
import wordTree.util.StdoutDisplayInterface;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;

public class Results implements FileDisplayInterface,StdoutDisplayInterface{

	private ArrayList<String> resultStore = null;
	private BufferedWriter bwriter = null;
	
	/**
	* Constructor for Results class.
	* Gets the file object and initializes the required objects for respective class.
	* @param file (FileProcessor).
	*/
	public Results(String file){
		this.resultStore = new ArrayList<String>();
		try{
			this.bwriter = new BufferedWriter(new FileWriter(file));
			MyLogger.writeMessage("Inside Results constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Error in writing file");
			System.exit(1);
		}
	}

	// Adds the student detail as a whole to the list
	public void storeNewResult(String string){
		this.resultStore.add(string);
	}

	// Returns the list of students in tree b_number along with course details
	public ArrayList<String> getresultStore(){
		return this.resultStore;
	}

	// Writes a string to output file
	public void writeSchedulesToFile(String string){
		try{
			// MyLogger.writeMessage(string,MyLogger.DebugLevel.FILE_WRITE);
			bwriter.write(string);
			bwriter.newLine();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	// Writes a string to stdout
	public void writeToScreen(String string){
		System.out.println(string);
	}

	// Closes the writer stream
	public void closeFile(){
		try{
			bwriter.close();	
		}
		catch(IOException ignore){}		
	}

}