import java.util.ArrayList;

public class Game {
  private Board board;
  private Player turn;
  private ArrayList<Move> moves = new ArrayList<>();
  private PieceSet blackP;
  private PieceSet whiteP;

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
    // String columns = "ABCDEFGH";
    // String rows = "12345678";
    // int currentRow = rows.indexOf(currentLoc.charAt(1)); //the original row is stored
    // int currentColumn = columns.indexOf(currentLoc.charAt(0)); //the original column is stored
    // int newRow = rows.indexOf(newLoc.charAt(1)); //the new row is stored
    // int newColumn = columns.indexOf(newLoc.charAt(0)); //the new column is stored
    // Piece currentPiece = board.getSquare(currentRow,currentColumn).getPiece(); //the piece to be moved is stored
    // if (currentPiece.checkValidMove(board.getSquare(newRow,newColumn))) {
      Move newMove = new Move(board, turn, currentLoc, newLoc);
    // }
  }

  public Player getTurn() {
    return turn; //returns the Player who's currently making the move
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
    return ans;
  }

  public static void main(String[] args) {
    Game newGame = new Game();
    newGame.create();
    System.out.println(newGame);
    String directions = "Output must be in this format: java Game white H7 B8";
    try {
      if (args.length < 3 || args.length > 3) {
        System.out.println(directions);
      }
      else {
        newGame.addMove(args[0],args[1],args[2]);
        System.out.println(newGame);
      }
    }
    catch (IllegalArgumentException e) {
      System.out.println(directions);
      System.exit(1);
    }
  }
}
