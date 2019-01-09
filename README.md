# MKS21X-FinalProject

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
