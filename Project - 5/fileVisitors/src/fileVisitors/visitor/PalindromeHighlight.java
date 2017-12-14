package fileVisitors.visitor;

import fileVisitors.util.MyLogger;
import fileVisitors.util.FileProcessor;
import fileVisitors.myTree.TreeBuilder;
import fileVisitors.myTree.Node;
import java.util.Iterator;

/**
* PalindromeHighlight class.
* Created for cs542 - Design patterns, Assignment 5.
*/
public class PalindromeHighlight implements VisitorI{
    
    /**
	* PalindromeHighlight constructor to intialize PalindromeHighlight class.
	*/
	public PalindromeHighlight(){
		MyLogger.writeMessage("Inside PalindromeHighlight constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	/**
	* checkPalindrome method.
	* checks whether the given string is palindrome or not.
	* @param word (String)
	* @return boolean
	*/
	private boolean checkPalindrome(String word){
		if(word.length() <= 3){
			return false;
		}
		int start = 0;
		int end = word.length()-1;
		while(start < end){
			if(Character.toLowerCase(word.charAt(start)) != Character.toLowerCase(word.charAt(end))){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	/**
	* highlightPalindrome method.
	* Traverse the tree inorder and highlight the palindrome words to capital letters.
	* @param currentNode (Node)
	*/
	public void highlightPalindrome(Node currentNode){
		if(currentNode != null){
			highlightPalindrome(currentNode.getLeftChild());
			String word = currentNode.getWord();
			if(checkPalindrome(word)){
				currentNode.setWord(word.toUpperCase());
				MyLogger.writeMessage("Palindrome Highlight - "+currentNode.getWord(),MyLogger.DebugLevel.PALINDROME_HIGHLIGHT);
			}
			highlightPalindrome(currentNode.getRightChild());
		}
	}

	/**
	* visit method.
	* Vist method for visitor pattern.
	* @param TreeBuilder (tree)
	*/
	public void visit(TreeBuilder tree){
		highlightPalindrome(tree.getRoot());
	}
}