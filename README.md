# EGR283_Project04

## What's Inside
This project consists of 6 classes:
   
   - created in class:  SLL, SLLNode 
   
   - personal testing purposes only:   GameDriver 
   
   - to be graded:  GameCatalogue, GameCatalogueDriver, Game
    
    
         Note: 

            - GameData.txt is the file from which the driver gets its data to process.

            - Project4.doc is the assignment as written by the instructor.

## My Experience
  The majority of this project was very simple and straightforward.  The portions that took me the most time 
  were the sortCatalog and removeGame methods. I began this project early and found an error in the assignment 
  that made the sorting extremely difficult and tedious.  
  
  After raising the issue to my professor, he realized 
  that he forgot to include a setData method in the SLL (in class) program. To solve the remove game problem, 
  I created a private helper method to handle shifting index data after removal. This project taught me that a 
  singly-linked-list is not an ideal data structure to use for most applications.
  
  **SLL Strengths**
  
      * Removal of a node conveniently shifts the index of the following nodes.
      * There could be some application for situations in which you want to restrict knowlege of nodes.
      * Addition of new nodes is very easy and intuitive.
      
  **SLL Weaknesses**
  
      * Sorting is possible, but extremely tedious.
      * Accessing data is extremely tedious.
      * Construction of a SLL using a constant can have major issues when dealing with int types because of their use as both the index AND data type.
    
Justin Cromer

March 1, 2021
