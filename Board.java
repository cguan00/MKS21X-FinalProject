public class Board{
  private Square[][] squares;
  private Piece[][] pieceSets;

  public void create(){
    squares = new Square[8][8];
    pieceSets = new Piece[2][16];
    Player color = new Player("black");
    for (int i = 0; i < 2; i++) {
      for (int x = 0; x < 16; x++) {
        if (i == 1) {
          color = new Player("white");
        }
        if (x == 0 && x == 7) {
          pieceSets[i][x] = new Rook(color, squares[i][x]);
        }
        if (x == 1 && x == 6) {
          pieceSets[i][x] = new Knight(color, squares[i][x]);
        }
        if (x == 2 && x == 5) {
          pieceSets[i][x] = new Bishop(color, squares[i][x]);
        }
        if (x == 3) {
          pieceSets[i][x] = new Queen(color, squares[i][x]);
        }
        if (x == 4) {
          pieceSets[i][x] = new King(color, squares[i][x]);
        }
        if (x > 7) {
          pieceSets[i][x] = new Pawn(color, squares[i+1][x-8]);
        }
      }
    }
  }

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
        if (r == 1 && c > 0) {
          ans += (pieceSets[1][c-1]);
        }
        if (r == 2 && c > 0) {
          ans += (pieceSets[1][c+7]);
        }
        if (r != 1 && r!= 2 && c != 0) {
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

/**
  //returns the pieceSets
  public Piece[][] getPieceSets() {
    return pieceSets;
  }
**/

}
