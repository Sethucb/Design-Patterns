package studentCoursesBackup.driver;

import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.FileProcessor;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;

public class Driver {

	// Command line checks
	private static boolean argCheck(String[] args){
		if(args[0].equals("${arg0}") || args[0].equals("") || args[1].equals("${arg1}") || args[1].equals("") || args.length != 5){
			return false;
		}
		if(args[2].equals("${arg2}") || args[2].equals("") || args[3].equals("${arg3}") || args[3].equals("") || args[4].equals("${arg4}") || args[4].equals("")){
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		
		if(argCheck(args) == false){
			System.err.println("Please specify five arguments.");
			System.exit(1);
		}
		String inputFile = args[0];
		String deleteFile = args[1];
		String output1 = args[2];
		String output2 = args[3];
		String output3 = args[4];

		// Create 3 trees
		TreeBuilder tree_orig = new TreeBuilder();
		TreeBuilder tree_backup1 = new TreeBuilder();
		TreeBuilder tree_backup2 = new TreeBuilder();
		

		FileProcessor file = null;
		try{
			File myinputFile = new File(inputFile);
			if(!myinputFile.exists() || myinputFile.isDirectory()) {
			    System.err.println("Input file does not exist.Please include it");
			    System.exit(1);
			}
			file = new FileProcessor(inputFile);
			String line;

			while((line = file.readLine()) != null){
				try{
					// Parse input string
					String[] arr = line.split(":");
					int number = Integer.parseInt(arr[0]);
					String course = arr[1];
					Node node_orig;
					Node backup_Node_1 = null;
					Node backup_Node_2 = null;
					if(!tree_orig.checkNodeexists(number)){
						node_orig = new Node(number);
						if(node_orig.checkValidCourse(course) == false){
							continue;
						}
						backup_Node_1 = (Node)node_orig.clone();
						backup_Node_2 = (Node)node_orig.clone();
						node_orig.addListener(backup_Node_1);
						node_orig.addListener(backup_Node_2);
						node_orig = tree_orig.addNode(node_orig);
						// Add two back up nodes to two treess
						backup_Node_1 = tree_backup1.addNode(backup_Node_1);
						backup_Node_2 = tree_backup2.addNode(backup_Node_2);
						
					}
					else{
						node_orig = tree_orig.getNode(number);
						backup_Node_1 = tree_backup1.getNode(number);
						backup_Node_2 = tree_backup2.getNode(number);
					}					
					node_orig.addCourse(course);
					backup_Node_1.addCourse(course);
					backup_Node_2.addCourse(course);
				}catch(Exception e){
					continue;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in reading file");
			System.exit(1);
		}
		finally{
			try{
				file.closeFile();
				file = null;	
			}catch(Exception ignore){}			
		}

		Results results_orig = new Results(output1);
		Results results_backup1 = new Results(output2);
		Results results_backup2 = new Results(output3);

		try{
		    File mydeleteFile = new File(deleteFile);
			if(!mydeleteFile.exists() || mydeleteFile.isDirectory()) {
			    System.out.println("Delete file does not exist.Please include it");
			    System.exit(1);
			}

			file = new FileProcessor(deleteFile);
			String line;
			while((line = file.readLine()) != null){
				try{
					String[] arr = line.split(":");
					int number = Integer.parseInt(arr[0]);
					String course = arr[1];
					if(!tree_orig.checkNodeexists(number)){
						continue;
					}
					Node node = tree_orig.getNode(number);
					node.removeCourse(course);
				}
				catch(Exception e){ continue;}
			}
			tree_orig.printNodes(results_orig, tree_orig.getRoot());
			tree_backup1.printNodes(results_backup1, tree_backup1.getRoot());
			tree_backup2.printNodes(results_backup2, tree_backup2.getRoot());
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Error in reading file");
			System.exit(1);
		}
		finally{
			try{
				file.closeFile();
				file = null;	
			}catch(Exception ignore){}
			
		}

		// Writing results to 3 output files
		ArrayList<String> res = new ArrayList<String>();
		res = results_orig.getresultStore();
		for(String str:res){
			results_orig.writeToFile(str);
		}
		results_orig.closeFile();
		res = null;	

		res = results_backup1.getresultStore();
		for(String str:res){
			results_backup1.writeToFile(str);
		}	
		results_backup1.closeFile();
		res = null;	
		
		res = results_backup2.getresultStore();
		for(String str:res){
			results_backup2.writeToFile(str);
		}
		results_backup2.closeFile();
		res = null;
	}
}
