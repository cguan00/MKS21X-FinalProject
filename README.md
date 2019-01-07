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
<<<<<<< HEAD
=======

**Sharon**
- I created get methods for both the Game and Move class. However, I'm really confused about how pieceCaptured in Move is going to find the piece that's in the new location and store it, because Squares don't have access to what piece is currently there. Piece stores the Square that it's currently at, but how will Move know which piece is there given the Square?
>>>>>>> MoveSharon
