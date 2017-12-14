package fileVisitors.visitor;

import fileVisitors.util.MyLogger;
import fileVisitors.util.FileProcessor;
import fileVisitors.myTree.TreeBuilder;
import fileVisitors.myTree.Node;

/**
* PrimeLength class.
* Created for cs542 - Design patterns, Assignment 5.
*/
public class PrimeLength implements VisitorI{

	/**
	* PrimeLength constructor to intialize PrimeLength class.
	*/
	public PrimeLength(){
		MyLogger.writeMessage("Inside PrimeLength constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	/**
	* checkPrimelength method.
	* checks whether the given string is prime length or not.
	* @param word (String)
	* @return boolean
	*/
	private boolean checkPrimelength(String word){
		int length = word.length();
		if(length < 2){
			return false;
		}
		for(int i = 2; i < length; i++){
			if(length % i == 0){
				return false;
			}
		}
		return true;
	}

	/**
	* primedTree method.
	* Traverse the tree inorder and add PRIME string to words which has lenght of prime number.
	* @param node (Node)
	*/
	private void primedTree(Node node){
		if(node == null){
			return;
		}
		primedTree(node.getLeftChild());
		if(checkPrimelength(node.getWord())){
			String primeString = node.getWord() + "-PRIME";
			node.setWord(primeString);
			MyLogger.writeMessage("Prime Length - "+node.getWord(),MyLogger.DebugLevel.PRIME_LENGTH);
		}
		primedTree(node.getRightChild());
	}

	/**
	* visit method.
	* Vist method for visitor pattern.
	* @param TreeBuilder (tree)
	*/
	public void visit(TreeBuilder tree){
    	primedTree(tree.getRoot());
	}

}