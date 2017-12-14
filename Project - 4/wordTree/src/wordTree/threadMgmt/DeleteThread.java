package wordTree.threadMgmt;

import wordTree.myTree.TreeBuilder;
import wordTree.util.MyLogger;

public class DeleteThread implements Runnable{
	
	private TreeBuilder tree;
	private String word;

	/**
	* PopulateThread constructor.
	* Gets the file, tree object and initializes the required objects for respective class.
	* @param treeIn (TreeBuilder)
	* @param wordIn (String)
	*/
	public DeleteThread(TreeBuilder treeIn,String wordIn){
		tree = treeIn;
		word = wordIn;
		MyLogger.writeMessage("Inside DeleteThread constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	* run method overrides the runnable interface run method.. 
	* The words are deleted using tree object's deleteWord methode to delete the word in tree.
	*/
	public void run(){
		tree.deleteWord(word);
		MyLogger.writeMessage("DeleteThread run",MyLogger.DebugLevel.THREAD_RUN);
	}

}