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

**Sharon**
- Instead of using lantera like we had originally planned to do, we decided to use an csv file to store all of the moves. In the end, I got the Game class to be able to write to a file each time it ran, thus storing all of the moves that the user inputs. And then, it would read the file from top to bottom and make all of the Moves, up to the latest one. I also added a few if statements in the Piece classes to keep an ArrayIndexOutOfBoundsException from happening. In the end, I added a print statement that would tell the user which player's it is.

### January 14, 2019

**Christy**
- I worked on testing and debugging checkValidMove for the Piece classes. To do this, I would have to run the Game file and manually move the pieces to see if the outcome was what I expected. Although I have most of the logic  completed, I wanted to move each piece to double check that the logic is correct. I was able to double check the Pawn and the Rook class and I think those are complete. One bug that I ran into today was that I was receiving a NullPointerException when I was trying to move a Queen piece or a Bishop piece. However, the code that was throwing this error is the same across all the Piece classes, so I'm not sure why the error is only being thrown in certain cases. I also updated Game.java so that after the Piece moved, you set the location to the new location. This was really important because the Piece should update its location each time you move it, so it properly checks the right squares for checkValidMove.

### January 15, 2019

**Christy**
- Today, I did extensive testing and debugging of the checkValidMove for all the classes except for the Knight class. Because I could easily test out the moves in the terminal, it was a lot easier to visualize and test the possible places the chess piece could be moved to. Although I had all of the logic completed, there were many minor bugs that were fixed and I also made the code more readable and tested for edge cases. I also realized today that all chess pieces, except for the Knight, cannot jump over other pieces, so I added that to checkValidMove. I think that there is a bug in the Rook class because the piece can move forward and left to right, but cannot move backwards (in terms of where the player is "sitting" facing the board). I had the same exact code in the Rook class as the Queen class, and it works for the Queen, but not the Rook. I will have to continue to test the Rook class tomorrow and finish checkValidMove for the Knight class.

### January 16, 2019

**Christy**
- Today, I did the checkValidMove debugging for the Knight class. This was relatively easy because there are only 8 possible spots the Knight can move to, so I created conditionals for each. I also fixed the diagonal capturing of the Pawn, so now the Pawn can move diagonally if it the piece in that Square is an opponent's piece. A huge chunk of my time was spent testing out the code to make sure that all the moves are correct. This was difficult because although I had the same code as the GitHub master and the school computer, the Pieces were not moving the same as when I was testing it out during class today. I spent a lot of time comparing the code to see what was different, but it was the same. I ended up creating a new clone of the repository on my own computer and replacing the previous folder.

**Sharon**
- I made sure that when a piece is captured by another piece, the captured piece would be deleted from that player's list of total pieces. As I was looking over the code, I also found some things that we wrote in the beginning but don't really seem to use. I also created a new method in Pawn.java that would allow us to set the field Moved to true. This way, we can access it from the Move class so that when a Pawn is moved for the first time, it's set to true. I realized that since our list of pieces are all part of the Piece class, I had to add that method in Piece.java as well. I also added to the Game file so that if the user tried to make a move for the white while it was black's turn, for instance, the terminal would print out an error message. 
