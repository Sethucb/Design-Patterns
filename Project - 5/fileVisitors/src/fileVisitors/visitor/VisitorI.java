package fileVisitors.visitor;

import fileVisitors.myTree.TreeBuilder;

/**
* VisitorI interface.
* Created for cs542 - Design patterns, Assignment 5.
*/
public interface VisitorI{
	/**
	* visit method.
	* Vist method for visitor pattern.
	* @param TreeBuilder (tree)
	*/
	public void visit(TreeBuilder tree);
}