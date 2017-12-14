package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.myTree.TreeBuilder;
import wordTree.util.MyLogger;
import wordTree.threadMgmt.PopulateThread;
import java.util.ArrayList;

public class CreateWorkers{
	private FileProcessor file;
	private TreeBuilder tree;
	private Thread thread[];

	/**
	* CreateWorkers constructor.
	* Gets the file object and initializes the required objects for respective class.
	* @param file (FileProcessor).
	*/
	public CreateWorkers(FileProcessor fileIn){
		// Required objects are assigned/intialized in the costructor.
		file = fileIn;
		tree = new TreeBuilder();
		MyLogger.writeMessage("Inside CreateWorkers constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	/**
	* startPopulateWorkers method
	* Creates the given number of threads, starts and joins the threads.
	* Each thread is created with the help of PopulateThread class using runnable interface.
	* Used to insert the word as nodes in tree from file.
	* @param NUM_THREADS (int).
	*/
	public void startPopulateWorkers(int NUM_THREADS){
		thread = new Thread[NUM_THREADS];
		for(int i = 0; i < NUM_THREADS; i++ ){
			Runnable populateThread = new PopulateThread(file, tree);
			String threadName = "Thread - "+String.valueOf(i+1);
			thread[i] = new Thread(populateThread,threadName);
			MyLogger.writeMessage("Populate: "+threadName+" created",MyLogger.DebugLevel.THREAD_CREATE);
		}
		// start and join threads
		try{
			for(int i = 0; i < NUM_THREADS; i++ ){
				thread[i].start();
				thread[i].join();
			}
		}catch(Exception ex){
			// prints the error and stack.
			System.err.println(ex.getMessage());
	    	ex.printStackTrace();
	    	System.exit(0);
		}
		file.closeFile();
	}

	/**
	* returns tree object.
	* @return TreeBuilder
	*/
	public TreeBuilder getTree(){
		return tree;
	}

	/**
	* startDeleteWorkers method
	* Creates the given number of threads, starts and joins the threads.
	* Each thread is created with the help of DeleteThread class using runnable interface.
	* Used to delete the word as nodes in tree from given delete argument string.
	* @param NUM_THREADS (int).
	* @param deleteWords (String[]).
	*/
	public void startDeleteWorkers(int NUM_THREADS,String[] deleteWords){
		for(int i = 0; i < NUM_THREADS; i++ ){
			Runnable deleteThread = new DeleteThread(tree,deleteWords[i]);
			String threadName = "Thread - "+String.valueOf(i+1);
			thread[i] = new Thread(deleteThread,threadName);
			MyLogger.writeMessage("Delete: "+threadName+" created",MyLogger.DebugLevel.THREAD_CREATE);
		}
		// start and join threads
		try{
			for(int i = 0; i < NUM_THREADS; i++ ){
				thread[i].start();
				thread[i].join();
			}
		}catch(Exception ex){
			System.err.println(ex.getMessage());
	    	ex.printStackTrace();
	    	System.exit(0);
		}
	}
}