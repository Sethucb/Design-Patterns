package wordTree.myTree;

import java.util.ArrayList;
import wordTree.util.MyLogger;

public class TreeBuilder {
	private Node root;

	/**
	* TreeBuilder constructor to intialize TreeBuilder class.
	* Intializes the root object for original, backup 1 and backup 2 trees to null.
	*/
	public TreeBuilder(){
		root = null;
		MyLogger.writeMessage("Inside TreeBuilder constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	/**
	* insertNode public method.
	* To create and clone respective Nodes and to insert the same in BST structure.
	* BST - Binary Search Tree.
	* The public insertNode method called by the threads to insert word is synchronized.
	* @param newWord.
	*/
	public synchronized void insertNode(String newWord){
		try{
			root = insertNode(root, newWord);
		}
		catch(Exception ex){
			System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
		}
	}	

	/**
	* insertNode private method.
	* To creates BST structure with given new node the root node.
	* BST - Binary Search Tree.
	* @param root of the respective tree.
	* @param newNode created or cloned node.
	* @see http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
	* @return Node (root);
	*/
	private Node insertNode(Node root, String word){
		if(root == null){
			root = new Node(word);
			return root;
		}
		int cmpResult =  word.compareTo(root.getWord());
		if(cmpResult == 0){
       		root.incrementCount();
        	return root;
       	}else{
        	if (0 > cmpResult){
	            root.setLeftChild(insertNode(root.getLeftChild(), word));
	        }
	    	else if (0 < cmpResult){
	            root.setRightChild(insertNode(root.getRightChild(), word));
        	}
        	return root;
       	}
	}

	/**
	* returns root node of the tree.
	* @return Node (root).
	*/
	public Node getRoot(){
		return root;
	}

	/**
	* returns the Node for the given word.
	* @param word (String)
	* @return Node
	*/
	public Node getNode(String word){
		Node currentNode = root;
		
		while(currentNode != null)	{
			int cmpResult = currentNode.getWord().compareTo(word);
			if(cmpResult == 0){
				return currentNode;
			}
			else if(cmpResult < 0){
				currentNode = currentNode.getRightChild();
			}
			else{
				currentNode = currentNode.getLeftChild();
			}
		}
		return null;
	}

	/**
	* deleteNode public method.
	* Deletes the node from tree (Only updates and changes number of occurences).
	* @param word (String)
	*/
	public void deleteWord(String word){
		synchronized(this){
			if(root == null){
				return;
			}
			Node node = getNode(word);
			if(node != null){
				node.decrementCount();
			}			
		}
	}
}