This assignment's submission is my own work and I did not discuss with any other past or current student, nor did I have access to a previous submission of this assignment by another student."

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile:
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code

ant -buildfile src/build.xml run -Darg0=mode -Darg1=N -Darg2=output.txt 

Example:
ant -buildfile src/build.xml run -Darg0=serdeser -Darg1=3 -Darg2=output.txt

-----------------------------------------------------------------------
## To create tarball for submission
tar -zcvf sethu_baskaran_assign6.tar.gz sethu_baskaran_assign6

-----------------------------------------------------------------------
## To unzip tarball for execution
tar -xzvf sethu_baskaran_assign6.tar.gz

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: Dec 10, 2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

Serialization:
Converts objects of MyAllTypesFirst and MyAllTypesSecond to XML persistent data.
Used Random class to generate random values.Used Reflection and its classes like Field,
Method to read values from objects.Then generated string based on tagName,tagType and tagValue
and wrote to file.

Deserialization: (Iterated 2*NUM_OF_OBJ times)
Converts the saved XML persistent data to objects of MyAllTypesFirst and MyAllTypesSecond
classes.Used pattern matching to find the class and its relevant field members.
Then used reflection to invoke setters and populate objects.

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).
