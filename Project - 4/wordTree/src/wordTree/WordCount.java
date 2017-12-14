package wordTree;

import wordTree.myTree.TreeBuilder;
import wordTree.myTree.Node;
import wordTree.store.Results;
import wordTree.util.MyLogger;

public class WordCount{

	TreeBuilder tree;
	int words;
	int characters;
	int distinctWords;

	/**
	* WordCount constructor.
	* Gets the tree object and initializes the required objects for respective class.
	* @param treeIn (TreeBuilder)
	*/
	public WordCount(TreeBuilder treeIn){
		tree = treeIn;
		words = 0;
		characters = 0;
		distinctWords = 0;
		MyLogger.writeMessage("Inside WordCount constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	/**
	* Public getWordCount method.
	* In turn this will call the private getWordCount with root parameter.
	*/
	public void getWordCount(){
		Node root = tree.getRoot();
		getWordCount(root);
	}

	/**
	* Private getWordCount method.
	* Uses inorder traversal of the tree to calculate number of words, number of charectors, 
	* and number of distinctWords.
	* @param node (Node)
	*/
	private void getWordCount(Node node){
		if(node == null){
			return;
		}
		getWordCount(node.getLeftChild());
		distinctWords++;
		words += node.getNumOfOccurence();
		characters += (node.getWordLength() * node.getNumOfOccurence());
		getWordCount(node.getRightChild());
	}

	/**
	* saveCount method.
	* stores the required details like number of words, number of charectors, 
	* and number of distinctWords to result object.
	* @param results (Results)
	*/
	public void saveCount(Results results){
		results.storeNewResult("The total number of words: "+words);
		results.storeNewResult("The total number of characters: "+characters);
		results.storeNewResult("The total number of distinct words: "+distinctWords);
	}
}