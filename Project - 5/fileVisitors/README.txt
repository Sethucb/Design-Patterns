
Assuming you are in the directory containing this README:
go to fileVisitors directory then,

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=0

-----------------------------------------------------------------------

## To create tarball for submission

tar -czvf venkituswamy_aravindhan_baskaran_sethu_assign_5.tar.gz --exclude=.* venkituswamy_aravindhan_assign_5

-----------------------------------------------------------------------

## To unzip tarball for execution

tar -xvf venkituswamy_aravindhan_baskaran_sethu_assign_5.tar.gz

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 11/22/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

In Result - ArrayList is used 

Add      : O(1)
Remove   : O(n)
Get      : O(1)
Contains : O(n)

Used Binary Search Tree - BST: The advantage of binary search trees over other data structures is that the insert & delete operations are in sorting order, so that the search algorithms such as inorder traversal and relavent future insertion & deletion operations can be very efficient (logarithm), i.e; at most of the times, the above mentioned operation tend to skip half of the tree, they are also easy to code as well.

WorstCase:
Insert: O(n)	
Delete: O(n)
Search: O(n)

AverageCase:
Insert: O(log n)	
Delete: O(log n)
Search: O(log n)

BestCase:
Insert: O(log n)	
Delete: O(log n)
Search: O(log n)

Debug Value to logger:

4 [Print to stdout everytime a constructor is called]
3 [Prints the prime length words]
2 [Print to stdout before writing to file]
1 [prints the palimdrome words]
0 [No output should be printed from the applicatio to stdout. It is ok to write to the output file though" ]


-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).
