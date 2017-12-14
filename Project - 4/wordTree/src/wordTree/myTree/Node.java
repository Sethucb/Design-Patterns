package wordTree.myTree;

import wordTree.util.MyLogger;

public class Node{
	private String word;
	private int wordLength;
	private int numOfOccurence;
	private Node leftChild;
	private Node rightChild;

	/**
	* Node constructor.
	* Gets the new word.
	* Initializes required objects for respective classes.
	* @param newWord (String)
	*/
	public Node(String newWord){
		word = newWord;
		wordLength = word.length();
		numOfOccurence = 1;
		leftChild = null;
		rightChild = null;	
		MyLogger.writeMessage("Inside Node constructor",MyLogger.DebugLevel.CONSTRUCTOR);	
	}

	/**
	* getWord method.
	* @return int (word)
	*/
	public String getWord(){
		return word;
	}

	/**
	* getNumOfOccurence method.
	* @return int (numOfOccurence)
	*/
	public int getNumOfOccurence(){
		return numOfOccurence;
	}

	/**
	* getWordLength method.
	* @return int (wordLength)
	*/
	public int getWordLength(){
		return wordLength;
	}

	/**
	* incrementCount method.
	* increments numOfOccurence by 1. 
	*/
	public void incrementCount(){
		numOfOccurence++;
	}

	/**
	* decrementCount method.
	* decrements numOfOccurence by 1. 
	*/
	public void decrementCount(){
		if(numOfOccurence > 0){
			numOfOccurence--;	
		}		
	}

	/**
	* getLeftChild method.
	* @return Node (leftChild node)
	*/
	public Node getLeftChild(){
		return leftChild;
	}

	/**
	* setLeftChild method.
	* @param nodeIn (sets the leftChild)
	*/
	public void setLeftChild(Node nodeIn){
		leftChild = nodeIn;
	}

	/**
	* getRightChild method.
	* @return Node (rightChild node)
	*/
	public Node getRightChild(){
		return rightChild;
	}

	/**
	* setLeftChild method.
	* @param nodeIn (sets the rightChild)
	*/
	public void setRightChild(Node nodeIn){
		rightChild = nodeIn;
	}
}