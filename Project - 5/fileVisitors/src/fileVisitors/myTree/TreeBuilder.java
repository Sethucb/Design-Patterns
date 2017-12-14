package fileVisitors.myTree;

import java.util.ArrayList;
import fileVisitors.util.MyLogger;
import fileVisitors.visitor.VisitorI;

public class TreeBuilder {
	private Node root;

	/**
	* TreeBuilder constructor to intialize TreeBuilder class.
	* Intializes the root object for original, backup 1 and backup 2 trees to null.
	*/
	public TreeBuilder(){
		MyLogger.writeMessage("Inside TreeBuilder constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		root = null;
	}

	/**
	* insertNode public method.
	* To create and clone respective Nodes and to insert the same in BST structure.
	* BST - Binary Search Tree.
	* @param newWord.
	*/
	public void insertNode(String newWord){
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
	* returns the root Node.
	* @return Node (root)
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
		return getNode(root,word);
	}

	private Node getNode(Node node,String word){
		if(node == null){
			return null;
		}
		Node nodeLeft = getNode(node.getLeftChild(),word);
		if(nodeLeft != null){
			return nodeLeft;
		}
		if(node.getWord().equalsIgnoreCase(word)){
			return node;
		}
		Node nodeRight = getNode(node.getRightChild(),word);	
		if(nodeRight != null){
			return nodeRight;
		}
		return null;	
	}

	/**
	* accept method for visitor pattern
	* @param visitor (VisitorI)
	*/
	public void accept(VisitorI visitor){
		visitor.visit(this);
	}
}