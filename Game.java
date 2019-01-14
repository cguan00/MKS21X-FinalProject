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
  private String error;

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
    //System.out.println(currentPiece.checkValidMove(board.getSquare(currentRow, currentColumn), board.getSquare(newRow,newColumn)));
    // System.out.println(currentRow);
    // System.out.println(currentColumn);
    // System.out.println(currentPiece);
    // System.out.println(board.getSquare(newRow, newColumn));
    if (currentPiece.checkValidMove(board.getSquare(newRow,newColumn))) {
      Move newMove = new Move(board, turn, currentLoc, newLoc);
      moves.add(newMove);
    }
  }

  // public void addMove(Player color, Square currentLoc, Square newLoc) {
  //   Piece currentPiece = currentLoc.getPiece(); //the piece to be moved is stored
  //   if (currentPiece.checkValidMove(newLoc)) {
  //     Move newMove = new Move(board, color, currentLoc, newLoc);
  //   }
  // }

  public void addAllMoves(String fileName) throws FileNotFoundException {
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    String newLine;
    String color, current, destination, columns, rows;
    int currentRow, currentColumn, newRow, newColumn;
    Piece currentPiece;
    while(sc.hasNextLine()) {
      newLine = sc.nextLine();
      if (newLine.length() < 5) {
        newLine = sc.nextLine();
      }
      color = newLine.substring(0,5);
      current = newLine.substring(6,8);
      destination = newLine.substring(9,11);
      turn = new Player(color);
      columns = "ABCDEFGH";
      rows = "12345678";
      currentRow = rows.indexOf(current.charAt(1)); //the original row is stored
      currentColumn = columns.indexOf(current.charAt(0)); //the original column is stored
      newRow = rows.indexOf(destination.charAt(1)); //the new row is stored
      newColumn = columns.indexOf(destination.charAt(0)); //the new column is stored
      if (board.getSquare(currentRow,currentColumn).getPiece() != null) {
        currentPiece = board.getSquare(currentRow,currentColumn).getPiece(); //the piece to be moved is stored
        if (currentPiece.checkValidMove(board.getSquare(newRow, newColumn))) {
          Move newMove = new Move(board, turn, current, destination);
          moves.add(newMove);
        }
      }
      else {
        error = "Please choose a location with a Piece" + "\n";
      }
    }
  }

  public Player getTurn() {
    return turn; //returns the Player who's currently making the move
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
    Game newGame = new Game();
    String fileName = "moves.txt";
    newGame.create();
    String directions = "Output must be in this format: java Game white H7 B8";
    try {
      if (args.length < 3 || args.length > 3) {
        System.out.println(directions);
      }
      else {
        newGame.write(args[0],args[1],args[2]);
        newGame.addAllMoves(fileName);
        System.out.println(newGame);
      }
    }
    catch (IllegalArgumentException e) {
      System.out.println(directions);
      System.exit(1);
    }
    catch (FileNotFoundException e) {
      System.out.println(directions);
      System.exit(1);
    }
    catch (IOException e) {
      System.out.println(directions);
      System.exit(1);
    }

    // newGame.addMove("white","H7", "H5");
    // System.out.println(newGame);
    // newGame.addMove(playing,newGame.getBoard().getSquare(7,7), newGame.getBoard().getSquare(5,7));
    // System.out.println(newGame);
    // newGame.addMove(playing,newGame.getBoard().getSquare(7,1), newGame.getBoard().getSquare(5,2));
    // System.out.println(newGame);
    // newGame.addMove(playing,newGame.getBoard().getSquare(6,1), newGame.getBoard().getSquare(5,1));
    // System.out.println(newGame);
    // newGame.addMove(playing,newGame.getBoard().getSquare(6,1), newGame.getBoard().getSquare(5,1));
    // System.out.println(newGame);
  }
}
