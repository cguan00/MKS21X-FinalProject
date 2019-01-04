public class Board{
  private Square[][] squares;
  //private Piece[][] pieceSets;
  //did not create Piece class yet

  public Board(){
    Square[][] squares = new Square[8][8];
  }

  public String toString() {
    String ans = "";
    for (int r = 0; r < 9; r++) {
      ans += "\n" + "|";
      for (int c = 0; c < 9; c++) {
        ans += " _";
      }
      ans += " |";
    }
    return ans;
  }

  public static void main(String[] args) {
    Board newBoard = new Board();
    System.out.println(newBoard);
  }
}
