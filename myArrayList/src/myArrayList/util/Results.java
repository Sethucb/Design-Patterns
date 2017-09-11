package myArrayList.util;

import java.util.ArrayList;
import myArrayList.util.FileDisplayInterface;
import java.io.BufferedWriter;
import myArrayList.util.StdoutDisplayInterface;

public class Results implements FileDisplayInterface,StdoutDisplayInterface{

	private ArrayList<String> resultStore = null;
	private BufferedWriter bwriter = null;
	
	public Results(){
		this.resultStore = new ArrayList<String>();
	}

	public void storeNewResult(String validTest){
		this.resultStore.add(validTest);
	}
	public ArrayList<String> getresultStore(){
		return this.resultStore;
	}

	public void setBuffereredWriter(BufferedWriter writer){
		this.bwriter = writer;
	}

	public void writeToFile(String s){
		try{
			bwriter.write(s);
			bwriter.newLine();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void writeToStdout(String s){
		System.out.println(s);
	}

}