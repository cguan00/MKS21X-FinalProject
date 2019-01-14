# MKS21X-FinalProject

## Instructions

**Compiling**
- Game file: javac Game.java
- Lanterna verion: javac -cp lanterna.jar:. GameDemo.java

**Running file**
- java Game [Player] [Starting Square] [Ending Square]
- Lanterna verion: java -cp lanterna.jar:. GameDemo

## Development Log

### January 3, 2019

**Christy**
- Today, I set up the Square class, Board class, and abstract Piece class. I created the fields for all classes, a constructor in the Board class, and the abstract method in the Piece class. Most of my time today was spent figuring out how to use the branches in GitHub. Even after trying the tutorials posted on the StuyCS website, I had to watch multiple YouTube videos to figure it out. It took many tries to merge and push correctly.

### January 4, 2019

**Sharon**
- Initially, I wrote a toString method in Board.java so that when the class is ran, it would print out an 8 by 8 board with numbers and letters on the sides to signify the row and column. However, later on, I realized that the toString should be in the Game class instead, and proceeded to create the Game class and move the method over. Besides the toString method, the Game class also has two fields. I also set up the Move class with four fields and the Player class with one field and one constructor.

**Christy**
- During the in class work period, I worked on the different Piece classes in the pieceChristy branch. I created classes for all six of the different game pieces, which extended the abstract Piece class. Tomorrow, I will continue to work on the Piece classes by filling in the necessary abstract methods.

**Sharon**
- During class, I worked on fixing and cleaning the toString method so it'd be easier to read. I also wrote a constructor for the Game class and familiarized myself with merging and branching.

### January 5, 2019

**Christy**
- I worked on the game piece aspect of the project today. I added the necessary fields, the constructor, and a toString method in each of the six classes which implement the abstract Piece class. I worked on the checkValidMove for the Pawn and Knight class, but I have yet to go it for the other classes. Halfway through working, I realized that I needed to work on the more basic get/set methods for the Square and Player classes, so I added those

### January 6th, 2019

**Sharon**
- Yesterday (I fell asleep without updating the log) I made another, different constructor for the Game class that would take in a Player, current Square, and new Square. However, today I realized that I had some things mixed up. In my old constructor, I was trying to create a new Board while also creating a new move, and that wasn't what should be happening. So instead, I made the method create() that would create a new board, and another method, addMove(), that would take in the Player, the piece that's to be moved, and the destined location. I also made a new class, pieceSet. It contains two fields but no methods yet.

**Sharon**
- I created get methods for both the Game and Move class. However, I'm really confused about how pieceCaptured in Move is going to find the piece that's in the new location and store it, because Squares don't have access to what piece is currently there. Piece stores the Square that it's currently at, but how will Move know which piece is there given the Square?

### January 7, 2019

**Christy**
- I continued to work on the classes that extend the abstract Piece class. I worked on the checkValidMoves for each class so that this version of chess follows the rules of the game. I'm still not sure how to do the promoting method in the Pawn class and keeping track of the piece it has been promoted to. Tomorrow, I will have to work on the more basic aspects of the Game and Move class to make sure that different classes have the proper access to the different fields.

**Sharon**
- In the Board class, I finished the create() function that I made and currently, I'm trying to get the board to print out all the pieces in their starting positions. However, I'm getting a NullPointerException error. Tomorrow, I'm going to continue working and figure out why.

### January 8, 2019

**Christy**
- As I was working on the Piece classes, Mr. K suggested changing checkValidMove to contain a list of possible Squares the Piece can move to, instead of checking if the desired move is valid. I think this is a great idea because the logic is much easier to understand and implement, so I began to rewrite the checkValidMove in the Pawn and Rook classes. However, most of the method is commented out because more basic get/set/check functions in the Square and Board classes need to be written in order to test the method.


### January 9, 2019

**Sharon**
- I finished the method in PieceSets that initializes the list of pieces for one color. I also added the isBlack() and isWhite() method to make it easier to check the colors of the piece. In the Board class, I added the method setPieceSets so it would be able to store both the black and white pieces in a 2 by 16 array. I thought the best way to do this was to first create two PieceSet objects in the Game class, and then have the setPieceSets method take those in and store each set in one row of the array. Now, I'm trying to print out the arrays to check if they're working, but there are some issues.

**Sharon**
- In the Board class, I created a setSquares function that allows the Squares to store the Pieces at their starting position. Before I did this, I also created the getPiece and storePiece methods in the Square class so that they'd have easier access to the Pieces. Using the squares[][] that I created in the Board class, I was able to print out the board in the Game class, along with the labels of the rows/columns on the side. I pushed all of this onto master. However, we realized that there's a problem in the constructor of the Pieces, and I fixed it in my own branch but it's not yet fixed in the master branch.

**Christy**
- I continued to work on the classes that extend the abstract Piece class. I decided to change the constructor in the Piece class so that the Piece can have access to the board, in order to look at nearby Squares and see if they are empty or not. Because I changed the constructor, it took a while to change it in other files. I also tested the Pawn class and I kept on getting a NullPointerException, so I had to look through all the other files and see where I was getting the error. Later, Sharon updated these files to have the needed methods, so it took even more time to double check and debug. I have two more classes that I need to fix checkValidMove for.

### January 10, 2019

**Christy**
- I continued to work on checkValidMove on the classes I did last night (Pawn, Rook, Bishop, and Queen). Today, I realized that moving to a square with the opponent's piece is still a valid move, so I added conditionals to check for this case. Right now, the code is really long and redundant, so later I will work on code readability and try using exception handling so that I don't need as many if statements. We also need to figure out exactly which files need to be added to the master, and how to merge the branches so that we have the correct version of each file.

### January 12, 2019

**Christy**
- Today I finished the checkValidMove for all the different classes which implement the abstract Piece class and they are all in the master branch. It took me a while to figure out the logic for each class, but I was able to do it through a lot of booleans to avoid any errors being thrown. Tomorrow, I will have to work on lanterna and trying to get the terminal to be interactive with the game. I realized that we will not be able to just print the board each time a player makes a move because Java has no way of remembering the moves.

**Sharon**
- I worked on the Move method and got it to take in three strings, the player color, the current location, and the new location. Using this, it figures out what piece the user wants to move and it then sets the square at the old location to null, before setting the location of the piece to the new square and the new square also stores the piece. The board is also able to print out the pieces after the move is made. Currently, I'm trying to incorporate checkValidMove into this.

### January 13, 2019

**Christy**
- Today was spent working with lanterna to make the game interactive. It was relatively easy to set the board up with the row ("ABCDEFGH") and column ("12345678") markers. After I set the board up and Sharon added the pieces to the board, I tried to make the pieces move, but this was really difficult. Because the only information that I could get about the user input is the x and y coordinates, I had to convert that to the proper row and column and the Square this was pointing to. However, because the terminal is constantly updating, I was not able to store the location of the Piece the player wanted to move. I'm not sure how to get around this, but we can try another method other than using lanterna.
