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
  private PieceSet blackP;
  private PieceSet whiteP;
  private String error = "";

  public Game() {
    board = new Board();
  }

  //Constructor
  /**not needed??
  public Game(Player color, Piece toBeMoved, Square destination) {
    turn = color;
  }
  **/

  //creates a new Game with a new board and all the pieces in starting position
  public void create() {
    board = new Board();
    moves = new ArrayList<>();
    turn = new Player("black");
    blackP = new PieceSet(turn); //creates a black PieceSet
    turn = new Player("white");
    whiteP = new PieceSet(turn); //creates a white PieceSet
    blackP.initialPieces(board); //all pieces are created at starting position
    whiteP.initialPieces(board);
    board.setPieceSets(blackP, whiteP); //sets up the PieceSets in Board so it'll have access
    board.setSquares(blackP, whiteP); //sets up squares[][] in Board
  }

  //creates a new move the necessary information: the current player,
  //the location of the piece they want to move, and where they want to move it to
  public void addMove(String color, String currentLoc, String newLoc) {
    turn = new Player(color);
    String columns = "ABCDEFGH";
    String rows = "12345678";
    int currentRow = rows.indexOf(currentLoc.charAt(1)); //the original row is stored
    int currentColumn = columns.indexOf(currentLoc.charAt(0)); //the original column is stored
    int newRow = rows.indexOf(newLoc.charAt(1)); //the new row is stored
    int newColumn = columns.indexOf(newLoc.charAt(0)); //the new column is stored
    Piece currentPiece = board.getSquare(currentRow,currentColumn).getPiece(); //the piece to be moved is stored
    if (currentPiece.checkValidMove(board.getSquare(newRow,newColumn))) {
      Move newMove = new Move(board, turn, currentLoc, newLoc);
      moves.add(newMove);
    }
  }

  //a file is opened to store all of the moves
  public void addAllMoves(String fileName) throws FileNotFoundException {
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    String newLine;
    String color, current, destination, columns, rows;
    int currentRow, currentColumn, newRow, newColumn;
    Piece currentPiece;
    while(sc.hasNextLine()) { //while it has next line, it gets the next line
      newLine = sc.nextLine();
      if (newLine.length() < 5) {
        newLine = sc.nextLine();
      }
      if(newLine.length() > 5 && newLine.length() < 12){
        color = newLine.substring(0,5); //splits it into three pieces of information for the Move constructor
        current = newLine.substring(6,8);
        destination = newLine.substring(9,11);
        turn = new Player(color);
        columns = "ABCDEFGH";
        rows = "12345678";
        currentRow = rows.indexOf(current.charAt(1)); //the original row is stored
        currentColumn = columns.indexOf(current.charAt(0)); //the original column is stored
        newRow = rows.indexOf(destination.charAt(1)); //the new row is stored
        newColumn = columns.indexOf(destination.charAt(0)); //the new column is stored
        if (currentRow == -1 || currentColumn == -1 || newRow == -1 || newColumn == -1) {
          error = "Please choose a valid location" + "\n";
        }
        else {
          if (board.getSquare(currentRow,currentColumn).getPiece() != null) {
            currentPiece = board.getSquare(currentRow,currentColumn).getPiece(); //the piece to be moved is stored
            if (currentPiece.checkValidMove(board.getSquare(newRow, newColumn))) {
              currentPiece.setLocation(board.getSquare(newRow, newColumn));
              Move newMove = new Move(board, turn, current, destination); //new Move is creaated
              moves.add(newMove);
            }
          }
        }
      }
      if(newLine.length() > 12){
        color = newLine.substring(0,5); //splits it into three pieces of information for the Move constructor
        current = newLine.substring(6,8);
        String desiredPiece = newLine.substring(9,newLine.length());
        System.out.println(desiredPiece);
        turn = new Player(color);
        columns = "ABCDEFGH";
        rows = "12345678";
        currentRow = rows.indexOf(current.charAt(1)); //the original row is stored
        currentColumn = columns.indexOf(current.charAt(0)); //the original column is stored
        if(color.equals("white")){//if it is white player
          newRow = 0; //pawn is moving upward, so row - 1
        } else{//if it is black player
          newRow = 7;//pawn is moving downward, so row + 1
        }
        newColumn = currentColumn; //pawn moves in vertical line, so column stays the same

        if(board.getSquare(currentRow,currentColumn).getPiece() != null){
          currentPiece = board.getSquare(currentRow,currentColumn).getPiece();

          boolean promotedPawn = false;

          if(currentPiece.checkValidMove(board.getSquare(newRow, newColumn))){//if this is a valid move
            Piece newPiece;
            if(color.equals("white") && newRow == 0){
              board.getSquare(currentRow,currentColumn).storePiece(null);
              if(desiredPiece.equals("Bishop")){
                newPiece = new Bishop(board, turn, board.getSquare(newRow,newColumn));
                board.getSquare(newRow,newColumn).storePiece(newPiece);
                newPiece.setLocation(board.getSquare(newRow, newColumn));
              }
              if(desiredPiece.equals("Knight")){
                newPiece = new Knight(board, turn, board.getSquare(newRow,newColumn));
                board.getSquare(newRow,newColumn).storePiece(newPiece);
                newPiece.setLocation(board.getSquare(newRow, newColumn));
              }
              if(desiredPiece.equals("Queen")){
                newPiece = new Queen(board, turn, board.getSquare(newRow,newColumn));
                board.getSquare(newRow,newColumn).storePiece(newPiece);
                newPiece.setLocation(board.getSquare(newRow, newColumn));
              }
              if(desiredPiece.equals("Rook")){
                newPiece = new Rook(board, turn, board.getSquare(newRow,newColumn));
                board.getSquare(newRow,newColumn).storePiece(newPiece);
                newPiece.setLocation(board.getSquare(newRow, newColumn));
              }
            }
            if(color.equals("black") && newRow == 7){
              board.getSquare(currentRow,currentColumn).storePiece(null);
              if(desiredPiece.equals("Bishop")){
                newPiece = new Bishop(board, turn, board.getSquare(newRow,newColumn));
                board.getSquare(newRow,newColumn).storePiece(newPiece);
                newPiece.setLocation(board.getSquare(newRow, newColumn));
              }
              if(desiredPiece.equals("Knight")){
                newPiece = new Knight(board, turn, board.getSquare(newRow,newColumn));
                board.getSquare(newRow,newColumn).storePiece(newPiece);
                newPiece.setLocation(board.getSquare(newRow, newColumn));
              }
              if(desiredPiece.equals("Queen")){
                newPiece = new Queen(board, turn, board.getSquare(newRow,newColumn));
                board.getSquare(newRow,newColumn).storePiece(newPiece);
                newPiece.setLocation(board.getSquare(newRow, newColumn));
              }
              if(desiredPiece.equals("Rook")){
                newPiece = new Rook(board, turn, board.getSquare(newRow,newColumn));
                board.getSquare(newRow,newColumn).storePiece(newPiece);
                newPiece.setLocation(board.getSquare(newRow, newColumn));
              }
            }
          }
        }



      }
    }
  }

  public Player getTurn() {
    return turn; //returns the Player who's currently making the move
  }

  public void setTurn(String color) {
    turn = new Player(color); //sets it the color
  }

  public Board getBoard() {
    return board;
  }

  public ArrayList<Move> getMoves() {
    return moves;
  }

  //writes and stores the move in a file
  public void write(String color, String current, String destination) throws IOException {
    FileWriter fw = new FileWriter("moves.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(color + " " + current + " " + destination);
    bw.newLine();
    bw.close();
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
    return ans + "\n" + "\n" + error;
  }

  public static void main(String[] args) {
    Game newGame = new Game(); //new Game
    String fileName = "moves.txt";
    File file = new File(fileName);
    newGame.create();
    String columns, rows;
    int currentRow, currentColumn, newRow, newColumn;
    Board board = newGame.getBoard();
    String directions = "To restart: java Game new" + "\n" + "To play: output must be in the format: java Game white H7 B8";
    try {
      if (args.length != 1 && args.length != 3) {
        System.out.println(directions);
        System.exit(1);
      }
      if (args[0].equals("new")) { //a new Game will be generated and the file is cleared
        file.delete();
        file.createNewFile();
        System.out.println(newGame);
        System.out.println("white player goes first");
      }
      else {
        if(args[2].length() == 2){//if the third input is a square (length will be 2)
          columns = "ABCDEFGH";
          rows = "12345678";
          currentRow = rows.indexOf(args[1].charAt(1)); //the original row is stored
          currentColumn = columns.indexOf(args[1].charAt(0)); //the original column is stored
          newRow = rows.indexOf(args[2].charAt(1)); //the new row is stored
          newColumn = columns.indexOf(args[2].charAt(0)); //the new column is stored
          if (currentRow == -1 || currentColumn == -1 || newRow == -1 || newColumn == -1) {
            newGame.addAllMoves(fileName);
            System.out.println(newGame);
            System.out.println("Please choose a valid location" + "\n");
          }
          else {
            newGame.write(args[0],args[1],args[2]);
            newGame.addAllMoves(fileName);
            System.out.println(newGame);
            if (newGame.getMoves().size()%2 == 1) { //if it was previously white's turn
              System.out.println("black player goes"); //black now goes
            }
            if (newGame.getMoves().size()%2 == 0) {
              System.out.println("white player goes"); //otherwise it's white's turn
            }
          }
        }


        if(args[2].length() > 2){//PAWN PROMOTION
          newGame.addAllMoves(fileName);

          String desiredPiece = args[2];//the piece the player wants to promote to

          columns = "ABCDEFGH";
          rows = "12345678";
          currentRow = rows.indexOf(args[1].charAt(1)); //the original row is stored
          currentColumn = columns.indexOf(args[1].charAt(0)); //the original column is stored


          if(args[0].equals("white")){//if it is white player
            newRow = 0; //pawn is moving upward, so row - 1
          } else{//if it is black player
            newRow = 7;//pawn is moving downward, so row + 1
          }
          newColumn = currentColumn; //pawn moves in vertical line, so column stays the same

          Player color = new Player(args[0]);

          boolean promotedPawn = false;

          if(board.getSquare(currentRow,currentColumn).getPiece() != null){
            Piece currentPiece = board.getSquare(currentRow,currentColumn).getPiece();

            if(currentPiece.checkValidMove(board.getSquare(newRow, newColumn))){//if this is a valid move
              Piece newPiece;
              if(args[0].equals("white") && newRow == 0){
                board.getSquare(currentRow,currentColumn).storePiece(null);
                if(args[2].equals("Bishop")){
                  newPiece = new Bishop(board, color, board.getSquare(newRow,newColumn));
                  board.getSquare(newRow,newColumn).storePiece(newPiece);
                  newPiece.setLocation(board.getSquare(newRow, newColumn));
                  promotedPawn = true;
                  newGame.write(args[0],args[1],args[2]);
                }
                if(args[2].equals("Knight")){
                  newPiece = new Knight(board, color, board.getSquare(newRow,newColumn));
                  board.getSquare(newRow,newColumn).storePiece(newPiece);
                  newPiece.setLocation(board.getSquare(newRow, newColumn));
                  promotedPawn = true;
                  newGame.write(args[0],args[1],args[2]);
                }
                if(args[2].equals("Queen")){
                  newPiece = new Queen(board, color, board.getSquare(newRow,newColumn));
                  board.getSquare(newRow,newColumn).storePiece(newPiece);
                  newPiece.setLocation(board.getSquare(newRow, newColumn));
                  promotedPawn = true;
                  newGame.write(args[0],args[1],args[2]);
                }
                if(args[2].equals("Rook")){
                  newPiece = new Rook(board, color, board.getSquare(newRow,newColumn));
                  board.getSquare(newRow,newColumn).storePiece(newPiece);
                  newPiece.setLocation(board.getSquare(newRow, newColumn));
                  promotedPawn = true;
                  newGame.write(args[0],args[1],args[2]);
                }
              }


              if(args[0].equals("black") && newRow == 7){
                board.getSquare(currentRow,currentColumn).storePiece(null);
                if(args[2].equals("Bishop")){
                  newPiece = new Bishop(board, color, board.getSquare(newRow,newColumn));
                  board.getSquare(newRow,newColumn).storePiece(newPiece);
                  newPiece.setLocation(board.getSquare(newRow, newColumn));
                  promotedPawn = true;
                  newGame.write(args[0],args[1],args[2]);
                }
                if(args[2].equals("Knight")){
                  newPiece = new Knight(board, color, board.getSquare(newRow,newColumn));
                  board.getSquare(newRow,newColumn).storePiece(newPiece);
                  newPiece.setLocation(board.getSquare(newRow, newColumn));
                  promotedPawn = true;
                  newGame.write(args[0],args[1],args[2]);
                }
                if(args[2].equals("Queen")){
                  newPiece = new Queen(board, color, board.getSquare(newRow,newColumn));
                  board.getSquare(newRow,newColumn).storePiece(newPiece);
                  newPiece.setLocation(board.getSquare(newRow, newColumn));
                  promotedPawn = true;
                  newGame.write(args[0],args[1],args[2]);
                }
                if(args[2].equals("Rook")){
                  newPiece = new Rook(board, color, board.getSquare(newRow,newColumn));
                  board.getSquare(newRow,newColumn).storePiece(newPiece);
                  newPiece.setLocation(board.getSquare(newRow, newColumn));
                  promotedPawn = true;
                  newGame.write(args[0],args[1],args[2]);
                }
              }
            }
          }
          if(promotedPawn){
            System.out.println(newGame);
            if (newGame.getMoves().size()%2 == 1) { //if it was previously white's turn
              System.out.println("black player goes"); //black now goes
            }
            if (newGame.getMoves().size()%2 == 0) {
              System.out.println("white player goes"); //otherwise it's white's turn
            }
          } else{
            newGame.addAllMoves(fileName);
            System.out.println(newGame);
            System.out.println("Please choose a valid location" + "\n");
          }
        }
      }
    }
    catch (IllegalArgumentException e) {
      // System.out.println(directions);
      System.out.println("illegal arg exp");
      System.exit(1);
    }
    catch (FileNotFoundException e) {
      // System.out.println(directions);
      System.out.println("file not found");
      System.exit(1);
    }
    catch (IOException e) {
      // System.out.println(directions);
      System.out.println("IOexception");
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
