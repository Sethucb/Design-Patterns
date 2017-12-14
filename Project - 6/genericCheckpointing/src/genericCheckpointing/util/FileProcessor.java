package genericCheckpointing.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class FileProcessor{
	private BufferedReader br = null;
	private FileReader fr = null;

	public FileProcessor(String fileName){
		try{
			MyLogger.writeMessage("Inside FileProcessor constructor",MyLogger.DebugLevel.CONSTRUCTOR);
			File myinputFile = new File(fileName);
			if(!myinputFile.exists() || myinputFile.isDirectory()) {
			    System.err.println("The file " + fileName + " does not exist.Please include it");
			    System.exit(1);
			}
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(0);
		}
	}

	// Reads a file by line
	public String readLine(){
		try{
			return br.readLine();	
		}catch(IOException e){
			e.printStackTrace();
			System.exit(0);
			return null;
		}
	}

	// Closes the buffered and filereader streams
	public void closeFile(){
		try{
			fr.close();
			br.close();	
		}
		catch(IOException ignore){}		
	}
	
}