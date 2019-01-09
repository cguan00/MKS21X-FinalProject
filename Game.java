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
    //board.setSquares(blackP, whiteP);
    // System.out.println(blackP.getPlayer().getColor());
    // System.out.println(whiteP.getPlayer().getColor());
    // for (int i = 0; i < 16; i++) {
    //   System.out.println(board.getPiece(0,i));
    //   System.out.println(board.getPiece(1,i));
    // }
    // Rook temp = new Rook(turn, new Square(0,0));
    // System.out.println(temp);
  }

  //creates a new move the necessary information: the current player,
  //the location of the piece they want to move, and where they want to move it to
  public void addMove(Player color, Piece toBeMoved, Square destination) {
    turn = color;
    Square current = toBeMoved.getLocation();
    Move newMove = new Move(toBeMoved, current, destination);
  }

  public Player getTurn() {
    return turn; //returns the Player who's currently making the move
  }

  //prints the board
  public String toString() {
  //   String ans = "";
  //   String letter = "ABCDEFGH";
  //   for (int r = 0; r < 9; r++) {
  //     if (r == 0) { //if it's the first row numbers will be printed on the side
  //       ans += " "; //excluding the first row
  //     }
  //     else {
  //       ans += "\n" + r;
  //     }
  //     for (int c = 0; c < 9; c++) { //letters are printed above each column
  //       if (r == 0) {
  //         if (c != 0) { //exlcluding the first column
  //           ans += " " + letter.charAt(c - 1);
  //         }
  //       }
  //       if (r < 3 && r != 0 && c != 0) {
  //         ans += " _";
  //       }
  //       if (r != 0) {
  //         if (c != 0) {
  //           ans += " " + board.getPiece(0,i) + " ";
  //         }
  //       }
  //   }
  // }

    String ans = "";
    for (int i = 0; i < 16; i++) {
      ans += board.getPiece(0,i) + " ";
    }
    ans += "\n";
    for (int i = 0; i < 16; i++) {
      ans += board.getPiece(1,i) + " ";
    }
    // for (int i = 0; i < 16; i++) {
    //   System.out.println(board.getPiece(0,i));
    //   System.out.println(board.getPiece(1,i));
    // }
    return ans;
  }

  public static void main(String[] args) {
    Game newGame = new Game();
    newGame.create();
    System.out.println(newGame);
  }
}
