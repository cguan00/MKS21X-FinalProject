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
    Move newMove = new Move(board, turn, currentLoc, newLoc);
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
    newGame.addMove("black", "C8", "B5");
    System.out.println(newGame);
  }
}
