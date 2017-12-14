package fileVisitors.visitor;

import fileVisitors.util.MyLogger;
import fileVisitors.util.FileProcessor;
import fileVisitors.myTree.TreeBuilder;
import java.util.ArrayList;
import java.util.Iterator;

/**
* PopulateVisitor class.
* Created for cs542 - Design patterns, Assignment 5.
*/
public class PopulateVisitor implements VisitorI{

	private FileProcessor file;

	/**
	* PopulateVisitor constructor to intialize PopulateVisitor class.
	* @param fileIn (FileProcessor)
	*/
	public PopulateVisitor(FileProcessor fileIn){
		MyLogger.writeMessage("Inside PopulateVisitor constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		file = fileIn;
	}

	/**
	* visit method.
	* Vist method for visitor pattern.
	* @param TreeBuilder (tree)
	*/
	public void visit(TreeBuilder tree){
		String line;
		while ((line = file.readLine(true)) != null)
	    {		    
    		String[] words = line.split(" ");
    		for(String word : words){
    			if(!word.equals("")){
    				tree.insertNode(word);
    			}
    		}
    	}
	}
}