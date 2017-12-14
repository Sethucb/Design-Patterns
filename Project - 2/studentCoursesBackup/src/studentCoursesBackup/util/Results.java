package studentCoursesBackup.util;

import java.util.ArrayList;
import myArrayList.util.FileDisplayInterface;
import java.io.BufferedWriter;
import java.io.FileWriter;
import myArrayList.util.StdoutDisplayInterface;
import java.io.IOException;

public class Results implements FileDisplayInterface,StdoutDisplayInterface{

	private ArrayList<String> resultStore = null;
	private BufferedWriter bwriter = null;
	
	public Results(String file){
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
	public void storeNewResult(String studentCourses){
		this.resultStore.add(studentCourses);
	}

	// Returns the list of students in tree b_number along with course details
	public ArrayList<String> getresultStore(){
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