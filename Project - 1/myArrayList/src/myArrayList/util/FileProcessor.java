package myArrayList.util;

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
		}
	}

	public String readLine(){
		try{
			return br.readLine();	
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}

	public void closeFile(){
		try{
			fr.close();
			br.close();	
		}
		catch(IOException ignore){}		
	}
	
}