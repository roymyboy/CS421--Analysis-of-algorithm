#PROJECT PEX3: All-Pairs, Shortest-Paths Algorithm 
..*Utsav Roy
..*CS421

##OVERVIEW
The main objective of this project was to solve the all-pairs, short-path problem for the directed graph.
I also used SLOW-ALL-PAIRS-SHORTEST-PATHS and FASTER-ALL-PAIRS-SHORTEST-PATHS algorithm form the textbook.

##INCLUDED FILES:
	*AllPairs.java 
	*README.md 

##COMPILING AND RUNNING:
The program was compiled using:
	$make 

to test the program 
	$java AllPairs <name of file>

to clean the program 
	$make clean

##DISCUSSION
I felt this program was pretty simple. I just followed the pseudo-code given in the textbook. At first my 
program was printing only the shortest path and did not print 'NULL' for the negative weight cycle. After 
debuging the program I saw i had issue with my global variable. My global vriable "isNegative" was being 
manipulated in two different place which was messing uo with the output. Once I fixed that, my program ran
pretty good.  
