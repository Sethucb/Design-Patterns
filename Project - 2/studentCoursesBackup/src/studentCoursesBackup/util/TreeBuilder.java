package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;
import java.util.ArrayList;

public class TreeBuilder {

	private Node rootNode;

	public TreeBuilder(){
		this.rootNode = null;
	}

	// Gets the root node of the tree
	public Node getRoot(){
		return this.rootNode;
	}

	// Adds the node to the tree
	public Node addNode(Node node){
		if(rootNode == null){
			rootNode = node;
			return node;
		}
		Node currentNode = rootNode;
        Node parentNode = currentNode;
		int number = node.getNumber();
		while (true) {
            if (parentNode.getNumber() > number) {
                currentNode = parentNode.getleftChild();
                if (currentNode == null) {
                    parentNode.setleftChild(node);
                    return node;
                }
            } else {
                currentNode = parentNode.getrightChild();
                if (currentNode == null) {
                    parentNode.setrightChild(node);
                    return node;
                }
            }
            parentNode = currentNode;
        }
		
	}

	// Search for a node
	public Node getNode(int number){
		Node currentNode = rootNode;
		
		while(currentNode != null){
			int currentNumber = currentNode.getNumber();
			if(currentNumber == number){
				return currentNode;
			}
			else if(currentNumber < number){
				currentNode = currentNode.getrightChild();
			}
			else{
				currentNode = currentNode.getleftChild();
			}
		}
		return null;
	}

	// Check if the node exists in the tree
	public boolean checkNodeexists(int number){
		Node newNode = getNode(number);
		if(newNode == null){
			return false;
		}
		return true;
	}

	// Prints the tree using inorder traversal
	public void printNodes(Results res,Node node){
		if(node == null){
			return;
		}
		printNodes(res,node.getleftChild());
		String num = String.valueOf(node.getNumber()) + ": ";
		String list = String.join(", ",node.getCourses());
		res.writeToFile(num + list);
		printNodes(res,node.getrightChild());
	}
}