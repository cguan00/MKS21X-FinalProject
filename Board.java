public class Board{
  private Square[][] squares;
  //private Piece[][] pieceSets;
  //did not create Piece class yet

  public Board(){
    Square[][] squares = new Square[8][8];
  }

  public String toString() {
    String ans = "";
    String letter = "ABCDEFGH";
    for (int r = 0; r < 9; r++) {
      if (r != 0) {
        ans += "\n" + r;
      }
      else {
        ans += " ";
      }
      for (int c = 0; c < 9; c++) {
        if (r == 0) {
          if (c != 0) {
            ans += " " + letter.charAt(c - 1);
          }
        }
        if (c != 8 && r != 0) {
          ans += " _";
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Board newBoard = new Board();
    System.out.println(newBoard);
  }
}
