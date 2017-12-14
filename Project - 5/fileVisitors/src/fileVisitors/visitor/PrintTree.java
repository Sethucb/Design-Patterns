package fileVisitors.visitor;

import fileVisitors.util.MyLogger;
import fileVisitors.util.FileProcessor;
import fileVisitors.myTree.TreeBuilder;
import fileVisitors.myTree.Node;
import fileVisitors.store.Results;
/**
* PrintTree class.
* Created for cs542 - Design patterns, Assignment 5.
*/
public class PrintTree implements VisitorI{
	private Results results;

	/**
	* PrintTree constructor to intialize PrintTree class.
	* @param resultsIn (Results)
	*/
	public PrintTree(Results resultsIn){
		MyLogger.writeMessage("Inside PrintTree constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		results = resultsIn;
	}

	/**
	* printTree method.
	* printTree method to print the tree in inorder traversal (ascending).
	* @param node (Node)
	*/
	private void printTree(Node node){
		if(node == null){
			return;
		}
		printTree(node.getLeftChild());
		String word = node.getWord();
		results.storeNewResult(word);
		results.writeToScreen(word);
		results.writeSchedulesToFile(word);
		printTree(node.getRightChild());
	}

	/**
	* visit method.
	* Vist method for visitor pattern.
	* @param TreeBuilder (tree)
	*/
	public void visit(TreeBuilder tree){
		// System.out.println("Priting within visitor +===");
		printTree(tree.getRoot());
		results.closeWriter();// closes file
	}
}