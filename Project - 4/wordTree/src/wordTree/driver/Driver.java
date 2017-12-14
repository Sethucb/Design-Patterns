package wordTree.driver;

import wordTree.WordCount;
import wordTree.store.Results;
import wordTree.threadMgmt.CreateWorkers;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;
import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) 
	{
	    // Object declared for Results class (Original).
	    Results results;
	    // Object declared for FileProcessor class.
	    FileProcessor file;
		// Object declared for CreateWorkers class.
	    CreateWorkers workers;
		// Object declared for WordCount class.
	    WordCount wordCount;

	    try{
	    	// command line validation for input file and output file respectively.
	    	String inputFile = "", outputFile = "";
	    	String[] deleteStr;
	    	int NUM_THREADS= 0;
		    if(5 == args.length){// validates given arguments array length to 5.
		    	if(!args[0].equals("${arg0}") && !args[0].equals("")){// validates 1st input file argument value.
		    		inputFile = args[0];
		    	}
		    	else{
		    		throw new Exception("Please provide input file.");
		    	}

		    	if(!args[1].equals("${arg1}") && !args[1].equals("")){// validates 2nd output file argument value.
					outputFile = args[1];
		    	}
		    	else{
		    		throw new Exception("Please provide output file.");
		    	}

		    	String threadCheck = "123";// validates number of threads value is between 1 and 3.
		    	if(!args[2].equals("${arg2}") && !args[2].equals("") && (threadCheck.contains(args[2]))){// validates 3rd number of threads argument value.
					try{
						NUM_THREADS = Integer.parseInt(args[2]);
					}catch(Exception ex){
				    	System.err.println("Number of threads should be a number");// prints the error message.
				    	ex.printStackTrace();// prints stack trace.
				    	System.exit(0);
				    }
		    	}
		    	else{
		    		throw new Exception("Please provide number of threads.");
		    	}
		    	if(!args[3].equals("${arg3}") && !args[3].equals("")){// validates 4th delete words argument value.
					String[] arg3 = args[3].split(" ");
					if(arg3.length == NUM_THREADS){
						deleteStr = arg3;
					}else{
						throw new Exception("Number of threads not equal to delete words.");
					}					
		    	}
		    	else{
		    		throw new Exception("Please provide delete words.");
		    	}

		    	String arg4 = "01234";// validates logger value is between 0 and 4.
				if(args[4].equals("${arg4}") || args[4].equals("") || args[4].length() != 1 || (!arg4.contains(args[4]))){
					throw new Exception("Logger value is incorrect");
				}
				else{
					try{
						int log = Integer.parseInt(args[4]);
						MyLogger.setDebugValue(log);
					}
					catch(Exception e){
						e.printStackTrace();
						System.exit(0);
					}
					
				}
		    }
		    else{
		    	throw new Exception("Please pass exactly 5 arguments one for input and another for output files.");
		    }

		    file = new FileProcessor(inputFile);				 
			results = new Results(outputFile);
			workers = new CreateWorkers(file);
			// start populate workers is called
			workers.startPopulateWorkers(NUM_THREADS);
			// start delete workers is called
			workers.startDeleteWorkers(NUM_THREADS,deleteStr);
		 	wordCount = new WordCount(workers.getTree());
		 	wordCount.getWordCount();
		 	// results are stored and printed/writtern to files
		 	wordCount.saveCount(results);
		 	ArrayList<String> list = results.getresultStore();
		 	for(String string : list){
		 		results.writeSchedulesToFile(string);
		 		if(args[4].equals("2")){
			 		results.writeToScreen(string);
			 	}
		 	}
		 	list = null;
		 	results.closeFile();
	    }
	    catch(Exception ex){
	    	System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
	    }
	    finally{// Clears all the objects created.
		    results = null;
		    file = null;
		    workers = null;
		    wordCount = null;
	    }
	}
}