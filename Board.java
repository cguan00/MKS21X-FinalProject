public class Board{
  private Square[][] squares;
  private Piece[][] pieceSets;

  public Board(){
    Square[][] squares = new Square[8][8];
    Piece[][] pieces = new Piece[4][16]; //what should the dimensions be?
  }

  public void setPieceSets(PieceSet blackPieces, PieceSet whitePieces) {
    for (int i = 0; i < 2; i++) {
      for (int x = 0; x < 16; x++) {
        if (i == 0) {
          pieceSets[i][x] = blackPieces.getPiece(x); //copies over the black pieces
        }
        if (i == 1) {
          pieceSets[i][x] = whitePieces.getPiece(x);
        }
      }
    }
  }

  //returns the pieceSets
  public Piece[][] getPieceSets() {
    return pieceSets;
  }

  //return a piece
  public Piece getPiece(int row, int col) {
    return pieceSets[row][col];
  }
  
  //return the square
  public Square getSquare(int row, int col){
    return squares[row][col];
  }

}
