package genericCheckpointing.store;

import genericCheckpointing.util.FileDisplayInterface;
import genericCheckpointing.util.MyLogger;
import genericCheckpointing.util.StdoutDisplayInterface;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class Results implements FileDisplayInterface,StdoutDisplayInterface{

	private BufferedWriter bwriter = null;
	
	/**
	* Constructor for Results class.
	* Gets the file object and initializes the required objects for respective class.
	* @param file (FileProcessor).
	*/
	public Results(String fileName){
		try{
			this.bwriter = new BufferedWriter(new FileWriter(fileName));
			MyLogger.writeMessage("Inside Results constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Error in writing file");
			System.exit(1);
		}
	}

	// Writes a string to output file
	public void writeSchedulesToFile(String string){
		try{
			bwriter.write(string);
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
			// System.out.println("INSIDE close");
			bwriter.close();	
		}
		catch(IOException ignore){}		
	}

}