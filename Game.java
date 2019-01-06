import java.util.ArrayList;

public class Game {
  private Board board;
  private Player turn;
  private ArrayList<Move> moves = new ArrayList<>();

  public Game() {
    board = new Board();
  }

  //Constructor
  //A new board is created with pieces in starting position
  public Game(Player color, Square current, Square destination) {
    board = new Board();
    turn = color;
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
        if (r != 0) {
          if (c != 0) {
            ans += " _";
          }
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Game newGame = new Game();
    System.out.println(newGame);
  }
}
