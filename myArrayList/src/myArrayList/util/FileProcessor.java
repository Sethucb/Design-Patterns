package myArrayList.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor{

	private BufferedReader br = null;
	private FileReader fr = null;
	private int index;

	public FileProcessor(String fileName){
		try{
		fr = new FileReader(fileName);
		br = new BufferedReader(fr);
		index = 0;
	}catch(IOException e){
		e.printStackTrace();
	}
	}

	public String readLine(){
		System.out.println("String is " + br.toString());
		return null;
	}
}