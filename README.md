***HepsiBurada Case Study Mars Rover***
-
Project Dependencies & Technical Details
 - Spring Boot application with Java 8
 - Mockito core and Junit Jupiter


####Endpoint

 - http://localhost:8080/api/process-rover
   
   The endpoint start rover process according to input.txt which located 
   under resources directory and generate output.txt file after process finished. 
   If there is an error during process(for example reading input file error), 
   endpoint return error message and success variable return false.
   
   Example Input File:
	- 5 5
    - 1 2 N
    - LMLMLMLMM
    - 3 3 E
    - MMRMMRMRRM
    
   Example Output File: 
    - 1 3 N
    - 5 1 E

 
				