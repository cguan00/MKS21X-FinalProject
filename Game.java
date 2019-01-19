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
  private String correctPlayer = "white";

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

  // //creates a new move the necessary information: the current player,
  // //the location of the piece they want to move, and where they want to move it to
  // public void addMove(String color, String currentLoc, String newLoc) {
  //   turn = new Player(color);
  //   String columns = "ABCDEFGH";
  //   String rows = "12345678";
  //   int currentRow = rows.indexOf(currentLoc.charAt(1)); //the original row is stored
  //   int currentColumn = columns.indexOf(currentLoc.charAt(0)); //the original column is stored
  //   int newRow = rows.indexOf(newLoc.charAt(1)); //the new row is stored
  //   int newColumn = columns.indexOf(newLoc.charAt(0)); //the new column is stored
  //   Piece currentPiece = board.getSquare(currentRow,currentColumn).getPiece(); //the piece to be moved is stored
  //   if (currentPiece.checkValidMove(board.getSquare(newRow,newColumn))) {
  //     Move newMove = new Move(board, turn, currentLoc, newLoc);
  //     moves.add(newMove);
  //   }
  // }

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
            Move newMove = new Move(board, turn, current, destination); //new Move is creaated
            moves.add(newMove);
            if (newMove.getPieceCaptured() != null) {
              if (turn.getColor().equals("black")) {
                blackP.remove(newMove.getPieceCaptured());
              }
              if (turn.getColor().equals("white")) {
                whiteP.remove(newMove.getPieceCaptured());
              }
            }
          }
        }
      }
    }
  }

  public Piece pawnPromote(Player color, int currentRow, int currentCol, String promotion){
    if(board.getSquare(currentRow,currentCol).getPiece().isPawn()){//if the piece you chose is a pawn
      Piece chosen = board.getSquare(currentRow,currentCol).getPiece();
      if(chosen.promote()){//check if piece is eligible for promotion
        //ADD CODE TO REMOVE PAWN FROM PLAYER PIECESET
        if(promotion == "Rook"){//player chooses to promote to Rook
          return new Rook(board, color, board.getSquare(currentRow,currentCol));//create Rook
        }
        if(promotion == "Queen"){//player chooses to promote to Queen
          return new Rook(board, color, board.getSquare(currentRow,currentCol));//create Queen
        }
        if(promotion == "Bishop"){//player chooses to promote to Bishop
          return new Rook(board, color, board.getSquare(currentRow,currentCol));//create Bishop
        }
        if(promotion == "Knight"){//player chooses to promote to Knight
          return new Rook(board, color, board.getSquare(currentRow,currentCol));//create Knight
        }
      }
    }
    return null;
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

  public String getCorrectPlayer() {
    return correctPlayer;
  }

  public void setCorrectPlayer(String playerColor) {
    correctPlayer = playerColor;
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
    String promotion;
    Piece newPiece;
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
        columns = "ABCDEFGH";
        rows = "12345678";
        currentRow = rows.indexOf(args[1].charAt(1)); //the original row is stored
        currentColumn = columns.indexOf(args[1].charAt(0)); //the original column is stored
        if(args[2].length() == 2){//if player is choosing the destination Square
          newRow = rows.indexOf(args[2].charAt(1)); //the new row is stored
          newColumn = columns.indexOf(args[2].charAt(0)); //the new column is stored
          if (currentRow == -1 || currentColumn == -1 || newRow == -1 || newColumn == -1) {
            // newGame.addAllMoves(fileName);
            System.out.println(newGame);
            System.out.println("Please choose a valid location" + "\n");
          }
          else {
            // if (newGame.getMoves().size()%2 == 1) { //if it was previously white's turn
            //   newGame.setCorrectPlayer("black");
            // }
            // if (newGame.getMoves().size()%2 == 0) {
            //   newGame.setCorrectPlayer("white");
            // }
            // if (args[0].equals(newGame.getCorrectPlayer())) {
              newGame.write(args[0],args[1],args[2]);
              newGame.addAllMoves(fileName);
              System.out.println(newGame);
              if (newGame.getMoves().size()%2 == 1) { //if it was previously white's turn
                System.out.println("black player goes"); //black now goes
              }
              if (newGame.getMoves().size()%2 == 0) {
                System.out.println("white player goes"); //otherwise it's white's turn
              }
            // }
            // else {
            // System.out.println("Sorry! The " + newGame.getCorrectPlayer() + " player goes");
            // }
          }
        }
        if(args[2].length() > 2){//player types in the piece they want to promote their pawn to
          Player playerColor;
          if(args[0].equals("white")){
            playerColor = new Player("white");
          }else{
            playerColor = new Player("black");
          }
          promotion = args[2];//stores the piece the player wants to promote to
          newPiece = newGame.pawnPromote(playerColor,currentRow,currentColumn, promotion);//create the new piece
          //ADD newPiece TO PLAYER PIECE SET

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
    catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(directions);
      System.exit(1);
    }

  }
}
