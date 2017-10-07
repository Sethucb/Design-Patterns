package studentCoursesBackup.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor{

	private BufferedReader br = null;
	private FileReader fr = null;

	public FileProcessor(String fileName){
		try{
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