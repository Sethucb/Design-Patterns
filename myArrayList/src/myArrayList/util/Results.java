package myArrayList.util;

import java.util.ArrayList;
import myArrayList.util.FileDisplayInterface;
import myArrayList.util.StdoutDisplayInterface;

public class Results implements FileDisplayInterface,StdoutDisplayInterface{

	private ArrayList<String> resultStore = null;
	
	public Results(){
		this.resultStore = new ArrayList<String>();
	}

	public void storeNewResult(String validTest){
		this.resultStore.add(validTest);
	}
	public ArrayList<String> getresultStore(){
		return this.resultStore;
	}

	public void writeToFile(String s){

	}

	public void writeToStdout(String s){
		System.out.println(s);
	}

}