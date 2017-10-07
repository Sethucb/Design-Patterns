package studentCoursesBackup.myTree;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class Node implements ObserverI,SubjectI,Cloneable{

	private int b_number;
	private ArrayList<String> courseNames;
	private Node leftChild;
	private Node rightChild;
	private static final ArrayList<String> availablecourseNames = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"));
	private ArrayList<Node> listenerNodes;

	public Node(int number){
		this.b_number = number;
		this.courseNames = new ArrayList<String>();
		this.leftChild = null;
		this.rightChild = null;
		this.listenerNodes = new ArrayList<Node>();
	}

	// Returns b_number of the node
	public int getNumber(){
		return this.b_number;	
	}

	// Returns leftchild of the node
	public Node getleftChild(){
		return this.leftChild;
	}

	// Sets the node as leftchild of the node
	public void setleftChild(Node node){
		this.leftChild = node;
	}

	// Sets the node as rightchild of the node
	public void setrightChild(Node node){
		this.rightChild = node;
	}

	// Returns rightchild of the node
	public Node getrightChild(){
		return this.rightChild;
	}

	// CHecks if the course is one of the valid course
	public boolean checkValidCourse(String course){
		if(!availablecourseNames.contains(course)){
			return false;
		}
		return true;
	}

	// Adds a course to the list of courses in node
	public void addCourse(String course){
		if(checkValidCourse(course) == false){
			return;
		}
		if(this.courseNames.contains(course)){
			return;
		}
		this.courseNames.add(course);
		Collections.sort(courseNames);
	}

	// Removes a course from the list of courses in node
	public void removeCourse(String course){
		if(checkValidCourse(course) == false){
			return;
		}
		if(!this.courseNames.contains(course)){
			return;
		}
		this.courseNames.remove(course);
		notifyAll(listenerNodes);
	}

	// Notifies the changes from node_orig to the back_up nodes
	public void notifyAll(ArrayList<Node> listenerNodes){
		// Iterate over the list and invoke update using listener nodes
		for(Node node:listenerNodes){
			node.update(this);
		}
	}

	// Gets the course from node_orig and update them in listener node courses.
	public void update(Node node){
		ArrayList<String> courses = node.getCourses();
		this.courseNames = null;
		ArrayList<String> updateCourses = new ArrayList<String>();
		for(String s:courses){
			updateCourses.add(s);
		}
		this.courseNames = updateCourses;
	}

	// Returns the list of courses of the current node
	public ArrayList<String> getCourses(){
		return this.courseNames;
	}

	// Returns the clone of the node_orig
	public Object clone() throws CloneNotSupportedException{
		try{
			int number = this.getNumber();
			Node node = new Node(number);
			return node;
		}
		catch(Exception e){
			e.printStackTrace();
			System.exit(0);
			return null;
		}
	}

	// Adds the node as a listener node
	public void addListener(Node node){
		this.listenerNodes.add(node);
	}
}