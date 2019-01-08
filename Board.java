public class Board{
  private Square[][] squares;
  private Piece[][] pieceSets;

  public void create(){
    Square[][] squares = new Square[8][8];
    Piece[][] pieces = new Piece[2][16];
    Player color = new Player("black");
    for (int i = 0; i < 2; i++) {
      for (int x = 0; x < 16; x++) {
        if (i == 1) {
          color = new Player("white");
        }
        if (x == 0 && x == 7) {
          pieces[i][x] = new Rook(color, squares[i][x]);
        }
        if (x == 1 && x == 6) {
          pieces[i][x] = new Knight(color, squares[i][x]);
        }
        if (x == 2 && x == 5) {
          pieces[i][x] = new Bishop(color, squares[i][x]);
        }
        if (x == 3) {
          pieces[i][x] = new Queen(color, squares[i][x]);
        }
        if (x == 4) {
          pieces[i][x] = new King(color, squares[i][x]);
        }
        if (x > 7) {
          pieces[i][x] = new Pawn(color, squares[i+1][x-8]);
        }
      }
    }
  }

  public static void main(String[] args) {

  }

/**
  //returns the pieceSets
  public Piece[][] getPieceSets() {
    return pieceSets;
  }
**/

}
