
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=delete.txt -Darg2=output1.txt -Darg3=output2.txt -Darg4=output3.txt

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf firstName_secondName_assign_number.tar.gz firstName_secondName_assign_number

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 3-Oct-2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

I have used BST to implement Observer pattern.

Adding a node : Adds a node to the tree.
Time - O(n) = worst case
Search for existing node : Check if the tree already has the node.
Time - O(n) = worst case
Removing a course from a node : Removes the course if exist from the courseName arraylist 
Time - O(n) Space - O(n) , n = list of courseName size
Result which write to file : Inorder Traversal to print sorted BST.
Time - O(n) = worst case
Result to store BST : ArrayList to store the Bnumber and course together as a string.
Time - O(n) Space - O(n) , n = number of nodes
Check if course if valid or not : An arraylist with valid courses as String
Time - O(n) Space - O(n), n = list of available courses size
NotifyAll Listeners : An arrayList to add listener which is constant in this case.
Time - O(2) Space - O(2)

Observer pattern:
When adding nodes/courses,I have created node(first time) and added courses to the three 
nodes in the three trees respectively.When removing courses,I call notifyAll(listenerNodes).
notifyAll is called by node_orig and backup_nodes are available as a list in listenerNodes.
I update the courses in listenerNodes by getting the courses from node_orig("this" to refer to it) and making a new list out of it.I set the courseNames in listeners to point to this new reference of coursenames so that they get updated with changes in the courses of node_orig.
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

BST insertion,search: Used as a reference check
http://jutility-ksvirdi.blogspot.com/2015/09/binary-search-tree-implementation-in.html


