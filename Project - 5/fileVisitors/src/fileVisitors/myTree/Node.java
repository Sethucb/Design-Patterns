package fileVisitors.myTree;

import fileVisitors.util.MyLogger;

public class Node{
	private String word;
	private Node leftChild;
	private Node rightChild;

	/**
	* Node constructor.
	* Gets the new word.
	* Initializes required objects for respective classes.
	* @param newWord (String)
	*/
	public Node(String newWord){
		MyLogger.writeMessage("Inside Node constructor",MyLogger.DebugLevel.CONSTRUCTOR);	
		word = newWord;
		leftChild = null;
		rightChild = null;
	}

	/**
	* getWord method.
	* @return int (word)
	*/
	public String getWord(){
		return word;
	}

	/**
	* setWord method.
	* @param wordIn (String)
	*/
	public void setWord(String wordIn){
		this.word = wordIn;
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