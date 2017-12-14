
Assuming you are in the directory containing this README:

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

[Date: 19-Oct-2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

I have used an ArrayList within Results to save the operations performed by 
the 3 risk states. O(n)
A HashMap is used to save the traveller info(Day as key,Prohibited
items on that day as value[ArrayList]).O(1), in worst case O(n)
I calculate the avgTrafficperDay and avgProhibitedperDay in SecurityFactors class.
Use those values in AirportState class to determine the type of risk.
For MyLogger,Value=2:Prints the operation performed by the states before saving it 
to Result;Value=1:Print the operations saved in Result before writing to output file

How I have calculated security factors:
I read a line of string(traveller) and calculate two security factors in SecurityFactors 
class using Hashmap.Key => Days,Value => Prohibited items on that day.
Total number of travellers = Number of lines read so far(Each line a travller)
Total number of days = Key size of the hashmap.
Total number of prohibited items = sum the size of values of all keys in the map.
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).


