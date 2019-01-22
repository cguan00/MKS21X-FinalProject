import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;


public class Game {
  private Board board;
  private Player turn;
  private ArrayList<Move> moves = new ArrayList<>();
  private ArrayList<String> validMoves = new ArrayList<>();
  private PieceSet blackP;
  private PieceSet whiteP;
  private PieceSet capturedWhite;
  private PieceSet capturedBlack;

  public Game() {
    board = new Board();
  }

  //creates a new Game with a new board and all the pieces in starting position
  public void create() {
    board = new Board();
    moves = new ArrayList<>();
    turn = new Player("black");
    blackP = new PieceSet(turn); //creates a black PieceSet
    capturedBlack = new PieceSet(turn);
    turn = new Player("white");
    whiteP = new PieceSet(turn); //creates a white PieceSet
    capturedWhite = new PieceSet(turn);
    blackP.initialPieces(board); //all pieces are created at starting position
    whiteP.initialPieces(board);
    board.setPieceSets(blackP, whiteP); //sets up the PieceSets in Board so it'll have access
    board.setSquares(blackP, whiteP); //sets up squares[][] in Board
  }

  //creates a new move the necessary information: the current player,
  //the location of the piece they want to move, and where they want to move it to
  public void addMove(String color, String currentLoc, String newLoc) {
    turn = new Player(color);
    String columns = "abcdefgh";
    String rows = "12345678";
    int currentRow = rows.indexOf(currentLoc.charAt(1)); //the original row is stored
    int currentColumn = columns.indexOf(currentLoc.charAt(0)); //the original column is stored
    int newRow = rows.indexOf(newLoc.charAt(1)); //the new row is stored
    int newColumn = columns.indexOf(newLoc.charAt(0)); //the new column is stored
    Piece currentPiece = board.getSquare(currentRow,currentColumn).getPiece(); //the piece to be moved is stored
    if (board.getSquare(currentRow,currentColumn).getPiece() != null) {
      currentPiece = board.getSquare(currentRow,currentColumn).getPiece(); //the piece to be moved is stored
      if (currentPiece.checkValidMove(board.getSquare(newRow, newColumn))) {
        currentPiece.setLocation(board.getSquare(newRow, newColumn));
        Move newMove = new Move(board, turn, currentLoc, newLoc); //new Move is creaated
        if (newMove.getCapturedPiece() != null) { //if there is a piece that was captured
          if (turn.getColor().equals("black")) {
            capturedWhite.addPiece(newMove.getCapturedPiece()); //if it's a white piece, adds it to the list of white pieces captured
          }
          else {
            capturedBlack.addPiece(newMove.getCapturedPiece()); //if it's a black piece, adds it to the list of black pieces captured
          }
        }
        moves.add(newMove); //new move is added to the list of moves
      }
    }
  }

  //Checks that the square with the piece the user chose to move is valid
  public boolean isValidIn(String input) {
    String cols = "abcdefgh";
    String rows = "12345678";
    if (input.length() != 2) { //checks that it has a length of 2
      return false; //if not, it's not valid
    }
    int row = rows.indexOf(input.charAt(1)); //checks if the format of the input is correct
    int col = cols.indexOf(input.charAt(0));
    if (row == -1 || col == -1) { //they should be within the strings
      return false;
    }
    if (board.getSquare(row,col).getPiece() == null) { //the user shouldn't have picked a square without a piece
      return false;
    }
    return true;
  }

  //checks that the square that the user wishes to move to is valid
  public boolean isValidOut(String input) {
    String cols = "abcdefgh";
    String rows = "12345678";
    if (input.length() != 2) { //checks that it has a length of 2
      return false;
    }
    int row = rows.indexOf(input.charAt(1)); //checks if the format of the input is correct
    int col = cols.indexOf(input.charAt(0));
    if (row == -1 || col == -1) { //they should be within the strings
      return false;
    }
    return true;
  }


  //ACCESSOR METHODS

  public Player getTurn() {
    return turn; //returns the Player who's currently making the move
  }

  public Board getBoard() {
    return board; //returns the board
  }

  public ArrayList<Move> getMoves() {
    return moves; //returns array of moves
  }

  public ArrayList<String> getValidMoves() {
    return validMoves; //returns array of valid moves
  }

  public PieceSet getWhiteP() {
    return whiteP; //returns PieceSet of white pieces
  }

  public PieceSet getBlackP() {
    return blackP; //returns PieceSet of black pieces
  }

  public PieceSet getCapturedWhite() {
    return capturedWhite; //returns PieceSet with captured white pieces
  }

  public PieceSet getCapturedBlack() {
    return capturedBlack; //returns PieceSet with captured black pieces
  }

  //MUTATOR METHOD

  public void setTurn(String color) {
    turn = new Player(color); //sets it the color
  }

  //prints the board
  public String toString() {
    String ans = "";
    String letter = "ABCDEFGH";
    for (int r = 0; r < 9; r++) {
      if (r == 0) { //if it's the first row numbers will be printed on the side
        ans += " "; //excluding the first row
      }
      else {
        ans += "\n" + r;
      }
      for (int c = 0; c < 9; c++) { //letters are printed above each column
        if (r == 0) {
          if (c != 0) { //exlcluding the first column
            ans += " " + letter.charAt(c - 1);
          }
        }
        if (r != 0 && c != 0) {
          //for every empty space that has a piece in the Squares array
          //prints out the piece that the Square stores
          if (board.getSquare(r-1, c-1).getPiece() == null) {
            ans += "  ";
          }
          else {
            ans += " " + board.getSquare(r-1,c-1).getPiece();
          }
          }
        }
    }
    return ans + "\n";
  }

  public static void main(String[] args) {
    Game newGame = new Game(); //new Game
    newGame.create(); //sets up everything in Game
    String currentLocation, newLocation;
    Board board = newGame.getBoard(); //stores the board for easier access
    Scanner user_input = new Scanner(System.in);
    String correctPlayer = "white"; //the first player is white
    String columns = "abcdefgh";
    String rows = "12345678";
    int currentRow = 0; //initializes all the variables
    int currentColumn = 0;
    int newRow = 0;
    int newColumn = 0;
    boolean gameOver = false; //sets this up for later
    boolean canPromote = false; //sets this up for later
    String promoteTo;
    Player color;
    Piece newPiece;
    Piece promoting = new Pawn(board, new Player("white"), new Square(0,0)); //initializing; will be changed later
    System.out.println("\n");
    System.out.println("Welcome to Chess!");
    System.out.println("\n");
    System.out.println("TO PLAY: Type the column of the piece that you want to move, and then the row. For instance, you can type in h7 or a7.");
    System.out.print("\n");
    System.out.println("TO WIN: capture the king from the other side.");
    System.out.print("\n");
    System.out.println("TO PROMOTE: When valid, type in the name of the piece you want to promote your pawn to.");
    System.out.print("\n");
    System.out.println("NOTE: Make sure you follow the rules of chess and use lowercases throught the game!");
    System.out.print("\n");
    System.out.println("ANOTHER NOTE: If the board prints out again with no changes, your move was not valid according to the game. Please choose another.");
    System.out.print("\n");
    System.out.println("Good Luck!");
    System.out.print("\n");
    System.out.println(newGame);
    System.out.println("White player goes first!");
    System.out.print("\n");
    try {
      while (!gameOver) { //while the game is still ongoing

        System.out.print("Enter the location of the piece you want to move: ");
        currentLocation = user_input.next(); //the user prints the location of the piece they want to move
        System.out.print("\n");
        System.out.print("Enter the location that you want to move to: ");
        newLocation = user_input.next();
        System.out.print("\n");

        //if the inputs are not valid, or the user is trying to move a piece that is not theirs, a message is printed
        if (!(newGame.isValidIn(currentLocation)) || !(newGame.isValidOut(newLocation)))  {
          System.out.println("Please choose valid locations.");
          System.out.print("\n");
        }
        else {

          //if inputs are valid, the values are stored
          currentRow = rows.indexOf(currentLocation.charAt(1)); //the original row is stored
          currentColumn = columns.indexOf(currentLocation.charAt(0)); //the original column is stored
          newRow = rows.indexOf(newLocation.charAt(1)); //the new row is stored
          newColumn = columns.indexOf(newLocation.charAt(0)); //the new column is stored

          if (board.getSquare(currentRow,currentColumn).getPiece().getColor() != correctPlayer) {
            System.out.println("Please move only the pieces with your color");
            System.out.print("\n");
          }

          else {

            newGame.addMove(correctPlayer, currentLocation, newLocation);
            System.out.println("\n");
            System.out.println("--------------------------------------------------------------");
            System.out.println("\n");
            System.out.println(newGame);

            //PROMOTION
            //if any of the pawns are at the opposide side of the baord, they can promote
            for (int i = 0; i < newGame.getWhiteP().getPawnSize(); i++) { //looking throught the white pawns
              if (newGame.getWhiteP().getPawn(i).getLocation().getRow() == 0) {
                promoting = newGame.getWhiteP().getPawn(i);
                canPromote = true;
              }
            }
            for (int i = 0; i < newGame.getBlackP().getPawnSize(); i++) { //looking through the black pawns
              if (newGame.getBlackP().getPawn(i).getLocation().getRow() == 7) {
                promoting = newGame.getBlackP().getPawn(i);
                canPromote = true;
              }
            }

            if (canPromote) {
              boolean promotedPawn = false;
              //if promote is true, the user will be asked what they want to promote the piece to
              // System.out.println(correctPlayer);
              System.out.print("\n");
              System.out.print("You can promote your pawn! Type in what you want to promote it to: ");
              promoteTo = user_input.next();
              System.out.print("\n");
              if(correctPlayer.equals("white")){//if it is white player
                color = new Player("white");
                newRow = 0; //pawn is moving upward, so row - 1
              } else{//if it is black player
                color = new Player("black");
                newRow = 7;//pawn is moving downward, so row + 1
              }
              if(correctPlayer.equals("white") && newRow == 0){
                if(promoteTo.equals("bishop")){
                  newPiece = new Bishop(board, color, board.getSquare(newRow,newColumn)); //a new piece is created with all of the same information
                  board.getSquare(newRow,newColumn).storePiece(newPiece); //the square stores the new piece
                  newPiece.setLocation(board.getSquare(newRow, newColumn)); //the piece stores the square as its location
                  promotedPawn = true; //becomes true
                }
                if(promoteTo.equals("knight")){
                  newPiece = new Knight(board, color, board.getSquare(newRow,newColumn));
                  board.getSquare(newRow,newColumn).storePiece(newPiece);
                  newPiece.setLocation(board.getSquare(newRow, newColumn));
                  promotedPawn = true;
                }
                if(promoteTo.equals("queen")){
                  newPiece = new Queen(board, color, board.getSquare(newRow,newColumn));
                  board.getSquare(newRow,newColumn).storePiece(newPiece);
                  newPiece.setLocation(board.getSquare(newRow, newColumn));
                  promotedPawn = true;
                }
                if(promoteTo.equals("rook")){
                  newPiece = new Rook(board, color, board.getSquare(newRow,newColumn));
                  board.getSquare(newRow,newColumn).storePiece(newPiece);
                  newPiece.setLocation(board.getSquare(newRow, newColumn));
                  promotedPawn = true;
                }
                newGame.getWhiteP().remove(promoting); //the original white pawn is removed from the array of pawns and white pieces
              }
              if(correctPlayer.equals("black") && newRow == 7){
                if(promoteTo.equals("bishop")){
                  newPiece = new Bishop(board, color, board.getSquare(newRow,newColumn)); //a new piece is created with the same information
                  board.getSquare(newRow,newColumn).storePiece(newPiece); //the square stores the new piece
                  newPiece.setLocation(board.getSquare(newRow, newColumn)); //the new piece sets its location to the square
                  promotedPawn = true; //set to true
                }
                if(promoteTo.equals("knight")){
                  newPiece = new Knight(board, color, board.getSquare(newRow,newColumn));
                  board.getSquare(newRow,newColumn).storePiece(newPiece);
                  newPiece.setLocation(board.getSquare(newRow, newColumn));
                  promotedPawn = true;
                }
                if(promoteTo.equals("queen")){
                  newPiece = new Queen(board, color, board.getSquare(newRow,newColumn));
                  board.getSquare(newRow,newColumn).storePiece(newPiece);
                  newPiece.setLocation(board.getSquare(newRow, newColumn));
                  promotedPawn = true;
                }
                if(promoteTo.equals("rook")){
                  newPiece = new Rook(board, color, board.getSquare(newRow,newColumn));
                  board.getSquare(newRow,newColumn).storePiece(newPiece);
                  newPiece.setLocation(board.getSquare(newRow, newColumn));
                }
                newGame.getBlackP().remove(promoting); //old pawn is removed from the list of pawns and pieces
              }
                canPromote = false; //is false after the promotion
                System.out.println(newGame);
                System.out.print("\n");
            }

            if (newGame.getMoves().size() > 0) {
              if (newGame.getMoves().size() % 2 == 1) { //since the game starts with white, a remainder of one means the black goes
                correctPlayer = "black"; //correct player is black
              }
              else {
                correctPlayer = "white"; //correct player is white
              }
            }
            System.out.print("CURRENT TURN: " + correctPlayer);
            System.out.println("\n");
            System.out.print("Captured White Pieces: "); //the list of white pieces captured is printed
            for (int i = 0; i < newGame.getCapturedWhite().size(); i++) {
              System.out.print(newGame.getCapturedWhite().getPiece(i) + " "); //goes through the list to print each piece out
            }
            System.out.println("\n");
            System.out.print("Captured Black Pieces: "); //the list of black pieces captured is printed
            for (int i = 0; i < newGame.getCapturedBlack().size(); i++) {
              System.out.print(newGame.getCapturedBlack().getPiece(i) + " "); //goes through the list to print each piece out
            }
            System.out.println("\n");
            if (newGame.getCapturedBlack().hasPiece(newGame.getBlackP().getBlackKing())) { //if the black king is captured
              gameOver = true; //game is over
            }
            if (newGame.getCapturedWhite().hasPiece(newGame.getWhiteP().getWhiteKing())) { //if the white king is captured
              gameOver = true; //game is over
            }
            if (newGame.getCapturedBlack().hasPiece(newGame.getBlackP().getBlackKing())) { //if the black king is captured
              System.out.println("GAME OVER! White wins" + "\n"); //white wins
            }
            if (newGame.getCapturedWhite().hasPiece(newGame.getWhiteP().getWhiteKing())) { //if the white king is captured
              System.out.println("GAME OVER! Black wins" + "\n"); //black wins
            }
          }
        }
      }
    }
    catch (IllegalArgumentException e) {
      // System.out.println(directions);
      System.out.println("illegal arg exp");
      System.exit(1);
    }
    catch (ArrayIndexOutOfBoundsException e) {
      //System.out.println(directions);
      // System.out.println("array out of bounds");
      e.printStackTrace();
      System.exit(1);
    }
  }
}
